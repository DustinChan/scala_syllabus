package unit3

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello Scala")
    val a = 10
    var b = 20
    b = 30
    println(a + "," + b)
    println(a + b)
    println(a.+(b))
  }
}
