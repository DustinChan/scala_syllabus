package basic
import scala.math._

object UseFunction {
  def main(args: Array[String]): Unit = {
    val a = 100
    println(sqrt(a))
    //1、静态方法调用
    println(BigInt.probablePrime(16, scala.util.Random))
    //2、非静态方法的调用
    println("HelloWorld".distinct)
    //3、apply
    println("Hello"(4))
    println("Hello".apply(4))
    //int[] arr = new int[]{1, 2, 3};
    //val arr = Array(1, 2, 3)
    println(Array(1, 2, 3))
    //5、update
    val arr2 = Array(1, 2, 3)
    arr2.update(0, 2)
    println(arr2.mkString(" "))
    arr2(2) = 4
    println(arr2.mkString(" "))
    /*
      小结：
        1、scala变量的定义
        2、方法的调用（静态，非静态）
        3、apply和update方法的调用
     */
    //6、option
    val map1 = Map("name" -> "Lion", "age" -> "22")
    println(map1.get("sex"))
    println(map1("sex"))
  }
}
