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
        if(type.contains('1') || type.contains("float"))
            println("Do floating point sort.")
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
fun doublesInput(): FloatArray{
    println("Please input floating point values (example: 1.2 2.3 4.3)")
    print("input: ")
    val input = readLine()
    val read = Scanner(input)
    return floatArrayOf()
}
