import java.awt.BorderLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.io.FileInputStream
import javax.swing.*


class App: JFrame() {
    val mahasiswaModel: DefaultListModel<Mahasiswa>
    val list: JList<Mahasiswa>
    val listScrollPane: JScrollPane
    val buttonPane: JPanel
    val tambahButton: JButton

    init {
        mahasiswaModel = DefaultListModel<Mahasiswa>()

        //Create the list and put it in a scroll pane.
        list = JList<Mahasiswa>(mahasiswaModel)
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
        list.setSelectedIndex(0)
        list.addListSelectionListener{
            if (it.valueIsAdjusting == false){
                val selected = list.selectedValue
                println("Nama ${selected.name} Nim: ${selected.nim}")
                println(selected.foto)
            }
        }
        val mouseListener: MouseListener = object : MouseAdapter() {
            override fun mouseClicked(mouseEvent: MouseEvent) {
                val theList: JList<Mahasiswa> = mouseEvent.source as JList<Mahasiswa>

                if (mouseEvent.clickCount == 2) {
                    val index = theList.locationToIndex(mouseEvent.point)
                    if (index >= 0) {
                        val o = theList.model.getElementAt(index)
                        val edit = Edit(o, index)
                        edit.isVisible = true
                        dispose()
                    }
                }
            }
        }
        list.addMouseListener(mouseListener)
        list.setVisibleRowCount(-1)
        listScrollPane = JScrollPane(list)


        //Create a panel that uses BoxLayout.
        buttonPane = JPanel()
        buttonPane.layout = BoxLayout(
            buttonPane,
            BoxLayout.LINE_AXIS
        )
        tambahButton = JButton("Tambah")
        tambahButton.addActionListener {
            val tambah = Tambah()
            tambah.isVisible = true
            dispose()
        }
        buttonPane.add(tambahButton)
        buttonPane.border = BorderFactory.createEmptyBorder(5, 5, 5, 5)

        add(listScrollPane, BorderLayout.CENTER)
        add(buttonPane, BorderLayout.PAGE_END)

        defaultCloseOperation = EXIT_ON_CLOSE
        title = "JList Renderer Example"
        this.setSize(300, 350)
        isResizable = false
    }

    fun tambahMahaiswa(nama: String, nim: String, foto: FileInputStream){
        mahasiswaModel.addElement(Mahasiswa(nama, nim, foto))
    }
    fun editMahasiswa(m: Mahasiswa, i: Int){
        mahasiswaModel.setElementAt(m, i)
    }
}