// main function
fun main(){
    // objects example
    val obj = Example()
    println("obj.calculateSquare(): ${obj.calculateSquare()}")
    val stu = Student("Chaitanya", 31)
    val stu2 = Student("Fulan")
    val stu3 = Student()
    val a = Animal("black", 2)
    val c = Cat("white", 1)
    c.meow()
    val h = Horse("brown", 8)
    h.neigh()

    // overriding properties of base class
    println("properties overriding:")
    println(a.misc)
    println(c.misc)
    println(h.misc)

    // calling property and function of base class from child class
    println("calling property and function of base class from child class:")
    c.superPrintFun()
    print("super misc: ")
    c.printSuperMisc()

    // visibility modifier example
    /* parent.num and parent.number are visible
     * parent.ch, parent.demo(), and parent.str are not visible
     */
    val parent = Parent()
    /* child.ch and child.demo() are not visible because
     * if you override protected members in child class
     * without specifying modifier then they are by default
     * protected
     */
    val child = Child()

    // abstract class' child class in action
    val colleger = Colleger("Evan", 21)
    colleger.func("I'm a designer.")
    colleger.demo()

    // class with interface implement in action
    val myObj = MyClass()
    myObj.demo()
    myObj.func()
    println(myObj.str)
    myObj.demoX()
    myObj.funcX()

    // accessing data member of nested class
    println(OuterClass.NestedClass().nStr)
    // accessing member function of nested class
    OuterClass.NestedClass().demo()
    // creating object of the nested class
    val nestedObj = OuterClass.NestedClass()
    println(nestedObj.demo())
    // inner class in action
    val o = OuterClass()
    o.InnerClass().demo()
    val i = OuterClass().InnerClass()
    i.demo()

    // data class in action
    val dev = Developer("Evan", 21, "designing")
    val dev2 = Developer("Anindya", 22, "sleeping")
    var dev3 = Developer("Evan", 21, "designing")
    println("dev1 name is ${dev.name}, age is ${dev.age}, hobby is ${dev.hobby}")
    println("dev2 name is ${dev2.name}, age is ${dev2.age}, hobby is ${dev2.hobby}")
    // data class automatically generated functions
    // equals()
    println("dev equals dev2 is: ${dev.equals(dev2)}")
    println("dev equals dev3 is: ${dev.equals(dev3)}")
    // hashCode()
    println("hashcode of dev: ${dev.hashCode()}")
    println("hashcode of dev2: ${dev2.hashCode()}")
    println("hashcode of dev3: ${dev3.hashCode()}")
    // copy()
    dev3 = dev.copy(name = "Wahyuaji")
    println("dev3 name is ${dev3.name}, age is ${dev3.age}, hobby is ${dev3.hobby}")
    // toString()
    println(dev.toString())
    // componentN()
    val name = dev.component1()
    val age = dev.component2()
    val hobby = dev.component3()
    println("name: $name, age: $age, hobby: $hobby")

    // subclass of sealed class in action
    val r = Color.Red()
    eval(r)
}

// class example
class Example{  // class default access modifier is public
    // property
    private var number = 5
    // behaviour
    fun calculateSquare(): Int{
        return number*number
    }
}

// primary constructor, default value, and initializer block
class Student(val name: String = "Student", var age: Int = 12){
    val stuName: String
    var stuAge: Int
    init{
        if(name == "Student")
            stuName = "N/A"
        else
            stuName = name.toUpperCase()
        stuAge = age
        print("student name is: $stuName, ")
        println("age is: $stuAge.")
    }
}

// inheritance. don't forget to type "open" before parent class
open class Animal(color: String, age: Int){
    init{
        print("color: $color, ")
        println("age: $age.")
    }
    open var misc = "this is an animal."
    fun printFun(){
        println("parent class function.")
    }
}
class Cat(color: String, age: Int): Animal(color, age){
    fun meow(){
        println("cat meows.")
    }
    override var misc = "this is a cat."    // property overriding
    fun superPrintFun(){   // function overriding
        super.printFun()
    }
    fun printSuperMisc(){
        println(super.misc)
    }
}
class Horse(color: String, age: Int): Animal(color, age){
    fun neigh(){
        println("horse neighs.")
    }
    override var misc = "this is a horse."  // property overriding
}

// visibility modifier example
open class Parent(){
    var num = 100   // by default public
    private var str = "BeginnersBook"
    protected open val ch = 'A'
    internal val number = 99
    open protected fun demo(){ }
}
class Child: Parent(){
    /* num, ch, number and function demo() are
     * visible in this class but str is not visible
     */
    override val ch = 'Z'
    override fun demo(){
        println("demo function of child class.")
    }
}

// abstract class example
abstract class Person(name:String, age:Int){
    init{
        println("Person name is: $name.")
        println("Person age is: $age.")
    }
    // non-abstract function
    fun demo(){
        println("Non-abstract function of abstract class.")
    }
    // abstract function
    abstract fun func(message: String)
}
class Colleger(name: String, age: Int): Person(name, age){
    override fun func(message: String){
        println(message)
    }
}

// interface example (be careful w/ interfaces that have same method name)
interface MyInterface{
    var str: String
    fun demo()
    fun func(){
        println("Hello")
    }
}
interface X{
    fun demoX(){
        println("demoX function")
    }
    fun funcX()
}
class MyClass: MyInterface, X{
    override var str: String = "str"
    override fun demo(){
        println("demo function")
    }
    override fun funcX(){
        println("HelloX")
    }
}

// nested and inner class
class OuterClass{
    val oStr = "outer string"
    class NestedClass{
        val nStr = "nested string"
        fun demo() {
            println("demo() function of nested class")
        }
    }
    inner class InnerClass{
        val iStr = "inner string"
        fun demo() {
            println("inner demo() function using $oStr")
        }
    }
}

/* Data Class Requirements
 1.The primary constructor of the data class must have
   at least one parameter. Also, the parameters are
   either  market var or val.
 2.The class cannot be marked as open, abstract, sealed,
   or inner
 3.The class can extend (inherit) other class and it can
   also implements other interfaces
 */
// data class example
data class Developer(val name: String, val age: Int, val hobby: String)

/* Rules of a Sealed Class
 1.Sealed class cannot be instantiated.
 2.All the subclasses of a sealed class must be declared
   within the same file where the sealed class is declared
 3.The constructor of sealed class is by default private
   and cannot be made non-private
 */
// sealed class example
sealed class Color{
    class Red: Color()
    class Green: Color()
    class Blue: Color()
}
fun eval(c: Color) = when(c){
    is Color.Red -> println("paint in red color.")
    is Color.Green -> println("paint in green color.")
    is Color.Blue -> println("paint in blue color.")
}