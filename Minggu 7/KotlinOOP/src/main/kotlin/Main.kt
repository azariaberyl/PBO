// Abstract class
abstract class Person1(name: String) {

    init {
        println("My name is $name.")
    }

    fun displaySSN(ssn: Int) {
        println("My SSN is $ssn.")
    }

    abstract fun displayJob(description: String)
}

class Teacher(name: String): Person1(name) {

    override fun displayJob(description: String) {
        println(description)
    }
}
// Interface
interface MyInterface {

    val test: Int

    fun foo() : String

    fun hello() {
        println("Hello there, pal!")
    }
}

class InterfaceImp : MyInterface {

    override val test: Int = 25
    override fun foo() = "Lol"

}
// Inner & Nested Class
class Outer {

    val a = "Outside Nested class."

    class Nested {
        val b = "Inside Nested class."
        fun callMe() = "Function call from inside Nested class."
    }
}
// Data Class
data class User(val name: String, val age: Int)
// Sealed Class
sealed class Expr
class Const(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()
object NotANumber : Expr()
// Kotlin Object Declaration & Expression
open class Person2() {
    fun eat() = println("Eating food.")

    fun talk() = println("Talking with people.")

    open fun pray() = println("Praying god.")
}
// Companion Object
class Person3 {
    companion object Test {
        fun callMe() = println("I'm called.")
    }
}
fun main(args: Array<String>) {
    val jack = Teacher("Jack Smith")
    jack.displayJob("I'm a mathematics teacher.")
    jack.displaySSN(23123)
    println()
//     Interface
    val obj = InterfaceImp()
    println("test = ${obj.test}")
    print("Calling hello(): ")
    obj.hello()
    print("Calling and printing foo(): ")
    println(obj.foo())
    println()
//     Nested & Inner Class
    // accessing member of Nested class
    println(Outer.Nested().b)

    // creating object of Nested class
    val nested = Outer.Nested()
    println(nested.callMe())
//    Data Class
    val jacky = User("jacky", 29)
    println("name = ${jacky.name}")
    println("age = ${jacky.age}")
    println()
//     Kotlin Object Declaration & Expression
    val atheist = object : Person2() {
        override fun pray() = println("I don't pray. I am an atheist.")
    }
    atheist.eat()
    atheist.talk()
    atheist.pray()
    println()
//    Companion Object
    Person3.callMe()
    println()
//    Extension Function
    val myString= "Hello Everyone"
    val result = myString.removeFirstLastChar()
    println("First character is: $result")
}
// Sealed Class
fun eval(e: Expr): Int =
    when (e) {
        is Const -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        NotANumber -> java.lang.Double.NaN.toInt()
    }
// Extension Function
fun String.removeFirstLastChar(): String =  this.substring(1, this.length - 1)