// WORK IN PROGRESS
import java.util.Scanner
fun main(){
    println("<------------ Sort Program ----------->")
    println("Sort types available:")
    println("1. floating point,   3. character,")
    println("2. integer,          4. string")
    print("Pick type: ")
    val type = readLine()
    if (type != null) {
        if(type.contains('1') || type.contains("float")){
            val input = stringInput("floating point")
            if (isValidInput("floating point", input)){
                val floats = stringToFloatMutableList(input)
                print("Input data: ")
                for(float in floats)
                    print("$float, ")
                println("\nDo floating point sort.")
            }
            else
                println("Input data is not valid.")
        }
        else if(type.contains('2') || type.contains("int")) {
            val input = stringInput("integer")
            if (isValidInput("integer", input)) {
                val ints = stringToIntegerMutableList(input)
                print("Input data: ")
                for(int in ints)
                    print("$int, ")
                println("\nDo integer sort.")
            }
            else
                println("Input data is not valid.")
        }
        else if (type.contains('3') || type.contains("char")) {
            val input = stringInput("character")
            if(isValidInput("character", input)){
                val chars = stringToCharMutableList(input)
                print("Input data: ")
                for(char in chars)
                    print("$char, ")
                println("\nDo character sort.")
            }
            else
                println("Input data is not valid.")
        }
        else if(type.contains('4') || type.contains("str")) {
            val input = stringInput("string")
            if(isValidInput("string", input)){
                val strings = stringToStringMutableList(input)
                print("Input data: ")
                for(string in strings)
                    print(string + ", ")
                println("\nDo string sort.")
            }
            else
                println("Input data is not valid.")
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