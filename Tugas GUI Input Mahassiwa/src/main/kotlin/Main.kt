import javax.swing.*

fun main(args: Array<String>) {
    val frame = JFrame("Hello, Kotlin/Swing")
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    val labelName = JLabel("Nama: ")
    labelName.setBounds(50, 50, 100, 30)
    frame.add(labelName)

    val tf = JTextField("Bagong")
    tf.setBounds(100,55, 150,20);
    frame.add(tf)

    val labelNim = JLabel("NIM: ")
    labelNim.setBounds(50, 90, 100, 30)
    frame.add(labelNim)

    val tf1 = JTextField("A11.2020.80011")
    tf1.setBounds(100,95, 150,20);
    frame.add(tf1)

    val labelHasil = JLabel()
    labelHasil.setBounds(230, 200, 400, 30)
    frame.add(labelHasil)

    val button = JButton("Save")
    button.setBounds(100,130, 95, 30)
    button.addActionListener {
        val nama = tf.getText()
        val nim = tf1.getText()
        labelHasil.setText("Nama: $nama dan NIM: $nim")
    }
    frame.add(button)

    frame.setSize(600,300)
    frame.layout = null
    frame.setVisible(true)

}