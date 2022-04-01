
fun main() {
//    Hello World / Output
    println("Hello World!")
//    variable & data types
    var language: String = "French"
    val score: Int = 95
//    Kotlin Operator
    val number1 = 12.5
    val number2 = 3.5
    var result: Double

    result = number1 + number2
    println("number1 + number2 = $result")

    result = number1 - number2
    println("number1 - number2 = $result")

    result = number1 * number2
    println("number1 * number2 = $result")

    result = number1 / number2
    println("number1 / number2 = $result")

    result = number1 % number2
    println("number1 % number2 = $result")
//    Kotlin Type Conversion
    val number3 = number1.toInt()
    println(number3)
//    Kotlin expression & Statement
//    10 + 5 adalah expresion sedangkan prinln(10+5) adalah statement
    println(10+5)
    /*kotlin comment
    *Kotlin Input/Output
    */
    print("Enter text: ")

    val stringInput = readLine()!!
    println("You entered: $stringInput")
    /*Kotlin if expression*/
    val number4 = -10
    if (number4 > 0) {
        print("Positive number")
    } else {
        print("Negative number")
    }
    /*Kotlin when expression*/
    val a = 12
    val b = 5

    println("Enter operator either +, -, * or /")
    val operator = readLine()

    val result1 = when (operator) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b
        else -> "$operator operator is invalid operator."
    }
    println("result = $result1")
//    Kotlin While loop $ do while
    var i = 1

    while (i <= 5) {
        println("Line $i")
        ++i
    }

    var sum: Int = 0
    var input: String
    do {
        print("Enter an integer: ")
        input = readLine()!!
        sum += input.toInt()

    } while (input != "0")

    println("sum = $sum")
//    Kotlin for loop
    for (i in 1..5) {
        println(i)
    }
//    Kotlin break
    for (i in 1..10) {
        if (i == 5) {
            break
        }
        println(i)
    }
//    Kotlin continue
    for (i in 1..5) {
        println("$i Always printed.")
        if (i > 1 && i < 5) {
            continue
        }
        println("$i Not always printed.")
    }
}