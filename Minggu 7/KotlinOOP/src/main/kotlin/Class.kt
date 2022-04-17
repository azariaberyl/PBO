class Lamp {

    // property (data member)
    private var isOn: Boolean = false

    // member function
    fun turnOn() {
        isOn = true
    }

    // member function
    fun turnOff() {
        isOn = false
    }
}

fun main() {
//    Kotlin Class & Object
    val l1 = Lamp()
    val l2 = Lamp()
//    Kotlin Constructor
    val person = Person("John",25)
    println()
//    Kotlin Setter & Getter
    val angela = Girl()
    angela.actualAge = 35
    angela.age = 35
    println("Angela: actual age = ${angela.actualAge}")
    println("Angela: pretended age = ${angela.age}")
    println()
//    Inheritance
    val t1 = MathTeacher(25, "Jack")
    t1.teachMaths()

}
open class Person(fName: String, personAge: Int) {
    val firstName: String
    var age: Int

    // initializer block
    init {
        firstName = fName
        age = personAge

        println("First Name = $firstName")
        println("Age = $age")
    }
}
// Kotlin setter & getter
class Girl {
    var age: Int = 0
        get() = field
        set(value) {
            field = if (value < 18)
                18
            else if (value >= 18 && value <= 30)
                value
            else
                value-3
        }

    var actualAge: Int = 0
}
// Kotlin Inheritance & Visibility
private class MathTeacher(age: Int, name: String): Person(name, age) {

    fun teachMaths() {
        println("I teach in primary school.")
    }
}