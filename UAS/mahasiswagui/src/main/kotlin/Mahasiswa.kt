import java.io.File
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Paths

class Mahasiswa(var name: String, var nim: String, var foto: FileInputStream){
    override fun toString(): String {
        return name
    }
}