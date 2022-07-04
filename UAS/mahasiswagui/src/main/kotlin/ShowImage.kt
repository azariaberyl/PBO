import sun.misc.IOUtils
import java.awt.BorderLayout
import java.awt.Image
import java.awt.Toolkit
import java.io.FileInputStream
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel

class ShowImage(image: FileInputStream): JFrame() {
    init{
        val bytes: ByteArray = IOUtils.readAllBytes(image)
        val img: Image = Toolkit.getDefaultToolkit().createImage(bytes)
        val icone = ImageIcon(img)
        val l = JLabel()
        l.setIcon(icone)

        setSize(300,300)
        add(l)
        isVisible = true
        defaultCloseOperation = DISPOSE_ON_CLOSE
    }
}