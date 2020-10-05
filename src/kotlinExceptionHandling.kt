fun main(){
    var num:Int
    // exception handling example: arithmetic
    try{
        num = 10/0
        println("BeginnersBook.com")
        println(num)
    } catch (e: ArithmeticException){
        println("Arithmetic Exception")
    } catch (e: Exception) {
        println(e)
    } finally{
        println("finally will print in any case.")
    }

    // exception handling example: array index out of bound
    try{
        val a = IntArray(5)
        a[10] = 99
    } catch(e: ArrayIndexOutOfBoundsException){
        println("array index is out of range")
    }

    // throwing an exception
    try{
        println("before exception.")
        throw Exception("something went wrong... not really")
        println("after exception.")
    } catch(e: Exception){
        println(e)
    }
    finally{
        println("hiya finally is here again.")
    }

    // nested try-catch block example
    try{
        num = 100/5
        println("num is: $num")
        try{
            num = 100/0
            println(num)
        } catch(e: NumberFormatException){
            println("Number Format Exception")
        }
    } catch(e: ArithmeticException){
        println("Arithmetic Exception")
    }

    // try as an expression
    var str = "Beginnersbook.com"
    num = try{
        str.toInt()
    } catch(e: NumberFormatException){ -1 }
    println(num)
    str = "100"
    num = try{
        str.toInt()
    } catch(e: NumberFormatException){ -1 }
    println(num)

    /* At least one catch or finally block should be present.
       Always put parent Exception class in the last catch block,
            cuz it is checked sequentially duh.
       If the exception is not handled in the child catch block,
            the the handlers of parent catch blocks are checked
            for the occurred exception.
     */
}