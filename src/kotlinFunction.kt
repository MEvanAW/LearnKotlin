import kotlin.math.sqrt
// main function
fun main(){
    // standard library function
    val num = 16
    println("square root of $num is: ${sqrt(num.toDouble())}")

    // user-defined functions
    sayHello()

    // user-defined function with arguments and return type
    println("the sum of 10, 20, 30, and 40 is: ${sum(10,20,30,40)}.")

    // inline functions
    val sumOfTwo = {num1: Int, num2: Int -> num1 + num2}
    println("6 + 4 = ${sumOfTwo(6,4)}")

    // head recursion example
    println("factorial of 3 is: ${fact(3)}")

    // tail recursion example
    println("factorial of 4 is: ${tailFact(4)}")

    // named arguments lets you override n-th default value(s)
    demo(ch='Z')

    // lambda function example
    var lambdaSum = {num1: Int, num2: Int -> num1 + num2}
    println("10 + 5: ${lambdaSum(10,5)}")

    // HIGHER ORDER FUNCTION EXAMPLES
    // passing a function to another function
    highOrderDemo(0, 'a', ::demo)

    // function returns another function
    val addTen = addNum(10)
    println("10 + 20: ${addTen(20)}")
}
// create user defined functions
fun sayHello() {
    println("Hello")
}
fun sum(vararg numbers: Int): Int{
    var sum = 0
    numbers.forEach {num -> sum += num}
    return sum
}
fun fact(num: Int): Int{
    return if(num == 1){
        num
    }
    else{
        num*fact(num-1)
    }
}
tailrec fun tailFact(n: Int, temp: Int = 1): Int{
    return if(n == 1){
        temp
    } else {
        tailFact(n-1, temp*n)
    }
}
fun demo(number:Int=100, ch:Char='A'){
    println("number is: $number and character is: $ch.")
}
fun highOrderDemo(number:Int, ch:Char, myfunc: (Int, Char) -> Unit){
    myfunc(number, ch)
}
fun addNum(num: Int): (Int) -> Int = {num2 -> num2 + num}