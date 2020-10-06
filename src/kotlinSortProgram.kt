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
                println("\nDo float sort.")
            }
            else
                println("Input data is not valid.")
        }
        else if(type.contains('2') || type.contains("int"))
            println("Do integer sort.")
        else if (type.contains('3') || type.contains("char"))
            println("Do character sort.")
        else if(type.contains('4') || type.contains("str"))
            println("Do string sort.")
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
    print("input: ")
    return readLine().toString()
}

fun isValidInput(type: String, input:String): Boolean{
    val read = Scanner(input)
    when (type){
        "floating point" -> if (read.hasNextFloat()) return true
        "integer" -> if(read.hasNextInt()) return true
        "character", "string" -> if(read.hasNext(".")) return true
        else -> println("WRONG PARAMETER")
    }
    return false
}

fun stringToFloatMutableList(str: String): MutableList<Float>{
    val read = Scanner(str)
    val floats = mutableListOf(0f)
    floats.set(0, read.nextFloat())
    while (read.hasNextFloat()){
        floats.add(read.nextFloat())
    }
    return floats
}
