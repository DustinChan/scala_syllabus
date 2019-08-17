package opera

object Lazy {
  def main(args: Array[String]): Unit = {
    def play1(a1: Int) = {
      println("play1方法被执行")
      a1
    }

    lazy val l1 = play1(10)
    println("l1变量定义完毕")
    println(l1)
  }
}
