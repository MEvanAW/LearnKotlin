// WORK IN PROGRESS
import java.util.Scanner
fun main(){
    println("<------------ Sort Program ----------->")
    println("Data types available:")
    println("1. floating point,   3. character,")
    println("2. integer,          4. string")
    print("Pick data type: ")
    val type = readLine()
    if (type != null) {
        println("Sort types available:")
        println("1. ascending, 2. descending")
        print("Pick sort type: ")
        var isAscending = true
        val ascString = readLine()
        if(ascString != null)
            if(ascString.contains('2') || ascString.contains("des"))
                isAscending = false
        if(type.contains('1') || type.contains("float")){
            val input = stringInput("floating point")
            val floats: MutableList<Float>
            if (isValidInput("floating point", input))
                floats = stringToFloatMutableList(input)
            else{
                println("Input data is not valid.")
                return
            }
            if(isAscending)
                floats.sort()
            else
                floats.sortDescending()
            print("Sorted data: ")
            for(float in floats)
                print("$float, ")
            println()
        }
        else if(type.contains('2') || type.contains("int")) {
            val input = stringInput("integer")
            val ints: MutableList<Int>
            if (isValidInput("integer", input))
                ints = stringToIntegerMutableList(input)
            else{
                println("Input data is not valid.")
                return
            }
            if(isAscending)
                ints.sort()
            else
                ints.sortDescending()
            print("Sorted data: ")
            for(int in ints)
                print("$int, ")
            println()
        }
        else if (type.contains('3') || type.contains("char")) {
            val input = stringInput("character")
            val chars: MutableList<Char>
            if(isValidInput("character", input))
                chars = stringToCharMutableList(input)
            else{
                println("Input data is not valid.")
                return
            }
            if(isAscending)
                chars.sort()
            else
                chars.sortDescending()
            print("Sorted data: ")
            for(char in chars)
                print("$char, ")
            println()
        }
        else if(type.contains('4') || type.contains("str")) {
            val input = stringInput("string")
            val strings: MutableList<String>
            if(isValidInput("string", input))
                strings = stringToStringMutableList(input)
            else{
                println("Input data is not valid.")
                return
            }
            if(isAscending)
                strings.sort()
            else
                strings.sortDescending()
            print("Sorted data: ")
            for(string in strings)
                print("$string, ")
            println()
        }
        else
            println("Invalid input.")
    }
}

fun stringInput(type: String): String{
    print("Please input $type values (example: ")
    when (type) {
        "floating point" -> println("1.2 2.3 4.3)")
        "integer" -> println("1 3 2 4)")
        "character" -> println("b A c E)")
        "string" -> println("1stString 2ndString)")
        else -> println("WRONG PARAMETER")
    }
    print("Input: ")
    return readLine().toString()
}

fun isValidInput(type: String, input:String): Boolean{
    val read = Scanner(input)
    when (type){
        "floating point" -> if (read.hasNextFloat()) return true
        "integer" -> if(read.hasNextInt()) return true
        "character" -> if(read.hasNext(".")) return true
        "string" -> if(input.isNotBlank()) return true
        else -> println("WRONG PARAMETER")
    }
    return false
}

fun stringToFloatMutableList(str: String): MutableList<Float>{
    val read = Scanner(str)
    val floats = mutableListOf(0f)
    floats[0] = read.nextFloat()
    while (read.hasNextFloat())
        floats.add(read.nextFloat())
    return floats
}

fun stringToIntegerMutableList(str: String): MutableList<Int>{
    val read = Scanner(str)
    val ints = mutableListOf(0)
    ints[0] = read.nextInt()
    while(read.hasNextInt())
        ints.add(read.nextInt())
    return ints
}

fun stringToCharMutableList(str: String): MutableList<Char>{
    val read = Scanner(str)
    val chars = mutableListOf('0')
    var temp = read.next(".")
    chars[0] = temp[0]
    while(read.hasNext(".")){
        temp = read.next(".")
        chars.add(temp[0])
    }
    return chars
}

fun stringToStringMutableList(str: String): MutableList<String>{
    val strings = str.split(" ").map{ it.trim() }
    return strings.toMutableList()
}