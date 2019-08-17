package unit7

object HighOrderFunction {
  def main(args: Array[String]): Unit = {
    //定义高阶函数
    def play(x:String, y:Int, f: (String, Int) => String) = {
      f(x, y)
    }

    def f(x:String, y:Int):String = {
      return x + y
    }

    val h1 = play("Hello", 10, f)
    println(h1)

    List(1, 2, 3, 4).map((x:Int) => x + 1)
    List(1, 2, 3, 4).map(x => x + 1)

    //闭包
    def minusxy(x: Int) = (y: Int) => x - y
    println(minusxy(10)(20))

    //Curry应用
    val a = Array("Hello", "World")
    val b = Array("hello", "world")
    println(a.corresponds(b)(_.equalsIgnoreCase(_)))

    //控制抽象
    def runOnThread(f1:() => Unit): Unit = {
      new Thread{
        override def run() = {
          f1()
        }
      }.start()
    }

    runOnThread{
      () => println("干活")
        Thread.sleep(5000)
        println("活干完了")
    }

  }
}
