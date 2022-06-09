fun main(args: Array<String>) {
//    Soal no 1
    val userNumber = readLine()!!;
    val stringArray = userNumber.toString();
    val halfString = stringArray.length/2;
    var numberLength = stringArray.length-1;
    var simetris = true
    for (x in 1..halfString){
        if (x.toString() != stringArray[numberLength].toString()){
            simetris = false;
        }
        numberLength--
    }
    println(simetris)
//    Soal no 2
    val input = readLine()!!.toInt();
    var result = input;
    for (i in 1..(input-1)){
        result *= i
    }
    println(result)
//    Soal no 3
    print("Masukan jumlah array: ");
    val nArray = readLine()!!.toInt();
    print("Masukan kelipatan yang ingin dicari: ");
    val nSearch = readLine()!!.toInt();
    val numbers: MutableList<Int> = mutableListOf();
    for (x in 1..nArray){
        numbers.add(readLine()!!.toInt())
    }
    var index = 0;
    for (x in numbers){
        if (x % nSearch == 0){
            println("Element $x ditemukan di index ke 4 merupakan kelipatan bilangan $nSearch")
        }
        index++;
    }
}