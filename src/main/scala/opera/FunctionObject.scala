package opera

object FunctionObject {
  def main(args: Array[String]): Unit = {
    //最标准形式
    def play1(a1: Int, a2: Int): String = {
      String.valueOf(a1 + a2)
    }
    println(play1(10, 20))

    //2
    def play2(a1:Int, a2: Int) = {
      a1 + a2
      println(a1 + a2)
    }
    println(play2(10, 10))

    //3
    def play3(a1:Int, a2: Int) = a1 + a2
    println(play3(5, 5))

    //4
    def play4(a1: Int, a2:Int = 10) = {
      a1 + a2
    }

    println(play4(1, 1))

    //5变长 类似Java的...
    def play5(args: Int*) ={
      for(i <- args){
        println(i)
      }
    }
    play5(1, 2, 2, 3, 3, 4)

    //递归实现一个数字的阶乘
    def factorial(n : Int):Int = {
      if(n == 1)
        n
      else
       factorial(n - 1) * n
    }

    println(factorial(3))

    //没有等号的定义过程
    def play6(msg: String){

    }

    def play6_1(msg: String):Unit = {

    }
    println(play6("haha"))

    //匿名函数
    /**
      * 1、匿名函数右边的函数体应该使用 => 符号来指定
      * 2、匿名函数的函数体，可以是一个包含多行代码的代码块
      * 3、函数的类型，为参数个数的类型
      */
    val play7 = (a1: Int, a2:Int) => {
      a1 + a2
      a2 - 10 + a1
    }
    println(play7(10, 20))

    //元组
//    Tuple(1, 2, 3, 4, 5, 7, 8, 9, 10)

  }
}
