import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException


class DB {
    var url = "jdbc:mysql://localhost:3306/app"
    var user = "root"
    var password = ""

    fun tambahData(nama: String, nim: String, foto: FileInputStream){
        try{
            val conn: Connection = DriverManager.getConnection(url, user, password)

            val sql = "INSERT INTO mahasiswa (nama, nim, foto) values (?, ?, ?)"
            val statement: PreparedStatement = conn.prepareStatement(sql)

            statement.setString(1, nama)
            statement.setString(2, nim)

            val inputStream: InputStream = foto
            statement.setBlob(3, inputStream)

            val row = statement.executeUpdate()
            if (row > 0) {
                println("A contact was inserted with photo image.")
            }
            conn.close()
        } catch (ex: SQLException){
            ex.printStackTrace();
        } catch (ex: IOException){
            ex.printStackTrace();
        }
    }
}