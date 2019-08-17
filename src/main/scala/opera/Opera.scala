package opera

object Opera {
  def main(args: Array[String]): Unit = {
    //1、if else
    var a  = 10;
    var resultString = ""
    val desc = if(a > 10){
      "a大于等于10"
    }else if(a == 10){
      resultString = "a等于10"
    }else{

    }

    println(desc)
    println(resultString)

    //2、while...do...while
    val result = while (a < 10){
      println("a的值是：" + a)
      a += 1
    }
    println(result)

//    do {
//    } while (true)

    //3、循环的终止
    import scala.util.control.Breaks
    val looper = new Breaks
    var count = 0
    looper.breakable{
      while(count <= 100){
        count += 1
        println(count)
        if(count == 10){
          looper.break
        }
      }
    }

    val whileLooper1 = new Breaks
    val whileLooper2 = new Breaks

//    whileLooper1.breakable{
//      while(true){
//        count += 1;
//        if(count == 10){
//          whileLooper1.break()
//        }
//        whileLooper2.breakable{
//          while (true){
//            if(count == 20){
//              whileLooper2.break
//            }
//          }
//        }
//
//      }
//    }

    //4、for循环
    for(i <- 1 to 3; j <- 1 to 3; m <- 1 to 3){
      print(i + "----" + j)
      println()
    }

    //想输出10 9 8 ....1
    for(i <- Range(10, 0, -1)){
      println(i)
    }

    //输出1~9
    for(i <- 1 until 10){
      println(i)
    }

    //实现1~10的输出，只输出偶数
    for(i <- 1 to 10 if i % 2 == 0){
      println(i)
    }

    //我遍历的时候，我想把遍历的所有结果，保存到一个集合中输出。
    val forResult = for(i <- 1 to 10) yield i;
    println(forResult)

    //在for循环中，添加变量表达式
    for(i <- 1 to 10; j = 10 - i; m = j * i){
      println("j:" + j)
      println("m:" + m)
    }

    //使用花括号作为for循环条件包裹
    for{
      i <- 1 to 3
      m = i * 2
    }
    println(m)


    //for循环打印实心矩形
    for(i <- 1 to 10; j <- 1 to 10){
      print("*")
      if(j == 10){
        println()
      }
    }


    //找出1~100的所有素数
    var flag = true
    for(i <- 2 to 100; m <- 2 until i){
      if(i % m == 0){
        flag = false
      }
      if(m == i - 1){
        if(flag){
          println(i)
        }
        flag = true
      }
    }

//    println(for(i <- 2 to 100; m <- 2 until i; if i % m != 0 && m == i - 1) yield i)
    //
    //    println(for(i <- 1 to 100 if i % 2 != 0) yield i)
  }
}
