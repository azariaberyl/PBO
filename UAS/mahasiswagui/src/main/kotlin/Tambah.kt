import java.io.File
import java.io.FileInputStream
import java.util.*
import javax.swing.*
import javax.swing.filechooser.FileFilter


class Tambah: JFrame() {
    var foto: FileInputStream? = null

    init{

        val txtNama = JLabel ("Nama")
        val txtNim =  JLabel ("Nim")
        val txtIpk = JLabel ("IPK");
        val txtMatkul = JLabel ("Mata Kuliah Aktif");
        val txtFoto = JLabel ("Foto");
        val txtPath = JLabel()

        val tfNama =  JTextField (20)
        val tfNim =  JTextField (20)
        val tfIpk = JTextField (20);
        val tfMatkul = JTextField (20);

        val btPilih =  JButton ("Pilih")
        val btSave =  JButton ("Save")

        btPilih.addActionListener {
            val chooser = JFileChooser()
            val filter = object : FileFilter() {
                override fun getDescription(): String {
                    return "JPG Images (*.jpg)"
                }
                override fun accept(f: File): Boolean {
                    return if (f.isDirectory) {
                        true
                    } else {
                        val filename = f.name.lowercase(Locale.getDefault())
                        filename.endsWith(".jpg") || filename.endsWith(".jpeg")
                    }
                }
            }
            chooser.fileFilter = filter
            chooser.showOpenDialog(null)
            val f: File? = chooser.selectedFile
//            println(f)
            if (f != null) {
                txtPath.text = f.absolutePath
                foto = FileInputStream(f)
            } else {
                foto = null
            }
        }
        btSave.addActionListener{
            val nama = tfNama.text
            val nim= tfNim.text
            val main = App()
            if (nama == "" || nim == "" || foto == null){
                main.isVisible = true
                dispose()
            } else {
                main.tambahMahaiswa(nama, nim, foto!!)
                main.isVisible = true
                dispose()
            }
            dispose()
        }

        add (txtNama)
        add (txtNim)
        add (txtIpk)
        add (txtMatkul)
        add (txtFoto)
        add (txtPath)
        add (tfNama)
        add (tfNim)
        add (tfIpk)
        add (tfMatkul)
        add (btPilih)
        add (btSave)

        txtNama.setBounds (50, 60, 150, 70);
        txtNim.setBounds (50, 115, 150, 70);
        txtIpk.setBounds (50, 170, 150, 70);
        txtMatkul.setBounds (50, 225, 150, 70);
        txtFoto.setBounds (45, 280, 150, 70);
        txtPath.setBounds (50, 345, 200, 25);
        tfNama.setBounds (150, 80, 395, 30);
        tfNim.setBounds (150, 135, 395, 30);
        tfIpk.setBounds (150, 190, 395, 30);
        tfMatkul.setBounds (150, 245, 395, 30);
        btPilih.setBounds (150, 300, 100, 25);
        btSave.setBounds (450, 375, 100, 25);


        defaultCloseOperation = EXIT_ON_CLOSE
        title = "JList Renderer Example"
        setSize(590,460)
        layout = null
        isResizable = false
    }
}