package unit6

object MatchSyllabus {
  def main(args: Array[String]): Unit = {
    //match 中的 switch用法
    def match1() = {
      var result = 0
      val op: Char = '*'

      op match {
        case '+' => result = 1
        case '-' => result = -1
        case _ => result = 0
      }
      println(result)
    }

    match1()

    //匹配模式——守卫
    def match2() = {
      for (c <- "+-*/123") {
        c match {
          case value if Character.isDigit(c) => println("这是一个数字:" + value)
          case '+' => println("这次字符为+号")
          case '-' => println("这次字符为-号")
          case '*' => println("这次字符为*号")
          case '/' => println("这次字符为/号")
          case _ => println("通配")
        }
      }
    }

    match2()


    //类型匹配
    def match3() = {
      val a = 4
      val obj = if (a == 1) 1
      else if (a == 2) "2"
      else if (a == 3) BigInt(3)
      else if (a == 4) Map("aa" -> 1)
      else if (a == 5) Map(1 -> "aa")
      else if (a == 6) Array(1, 2, 3)
      else if (a == 7) Array("aa", 1)
      else if (a == 8) Array("aa")

      val r1 = obj match {
        case i: Int => i
        case s: String => s
        case bi: BigInt => bi
        case m2: Map[Int, String] => println("这是Map[Int, String]")
        case m1: Map[String, Int] => println("这是Map[String, Int]")
        case a1: Array[Int] => println("Array[Int]")
        case a3: Array[String] => println("Array[String]")
        case a2: Array[Any] => println("Array[Any]")
      }

      println(r1 + "：" + r1.getClass.getName)

    }

    match3()

    //匹配数组
    def match4() = {
      for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0), Array(1, 1, 0), Array(1, 1, 1, 0))) {
        arr match {
          case Array(0) => println("匹配了Array(0)")
          case Array(x, y) => println("匹配了Array(x, y)" + x + "," + y)
          case Array(x, y, z) => println("匹配了Array(x, y, z)" + x + "," + y + "," + z)
          case Array(1, arr@_*) => println("匹配了 Array(1, _*)" + arr.length)
          case _ => println("通配")
        }
      }
    }

    match4()

    //匹配模式中的提取机制
    def match5() = {
      val n = 36.0
      n match {
        case Square(result) => println(s"${n} + ", s" + ${result}")
      }
    }

    match5()

    val (x, y) = (1, 2)
    val (q, r) = BigInt(10) /% 3
    val arr = Array(1, 7, 2, 9)
    val Array(first, second, _*) = arr


    //for循环中的模式匹配
    def match6() = {
      import scala.collection.JavaConverters._
      for ((k, v) <- System.getProperties.asScala if v == "" || v == null) {
        println(k)
      }
    }

    match6()

    def match7() = {
      for (e <- Array(Dollar(1000.0), Currency(1000, "EUR"))) {
        e match {
          case Dollar(v) => println(v)
          case Currency(k, v) => println(k + "," + v)
        }
      }
    }

    match7()

    val amt = Currency(29.95, "EUR")
    val price = amt.copy(value = 19.95)
    println(amt)
    println(price)
    println(amt.copy(unit = "CHF"))

    def match8() = {
      val list = List(1, 2, 3, 4, 5, 6)
      list match {
        case l1 :: l2 :: l3 :: l4 => println(l1 + "," + l2 + "," + l3 + "," + l4)
      }
    }

    match8()

    //嵌套类的匹配
    def match9() = {
      val sale = Bundle("愚人节大甩卖系列", 10,
        Article("《九阴真经》", 40),
        Bundle("从出门一条狗到装备全发光的修炼之路系列", 20,
          Article("《如何快速捡起地上的装备》", 80),
          Article("《名字起得太长躲在树后容易被地方发现》", 30)))

      def price(it: Item): Double = {
        it match {
          case Article(_, p) => p
          case Bundle(_, disc, its@_*) => its.map(price _).sum - disc
        }
      }

      /*
      1、Bundle
          case Bundle sum = 40 + 90 = 130 - 10 = 120
            map(artice, bundle) -> [40， 90]
              case Bundle sum = 110 - 20 = 90
                map(article, article) -> [80, 30]
       */

      println(price(sale))
    }

    match9()

    def match10(): Unit = {
      for (color <- Array(Red, Yellow, Green))
        println(
          color match {
            case Red => "stop"
            case Yellow => "slowly"
            case Green => "go"
          })
    }

    match10()

    //偏函数
    val f: PartialFunction[Char, Int] = {
      case '+' => 1
      case '-' => -1
    }
    println(f('-'))
    println(f.isDefinedAt('0'))
    println(f('+'))

    //额外的讨论
//        val result = List(1, 2, 3, "heiheihei", 5).map{case i: Int => i * 2}
//        println(result)
    //    val result2 = List(1, 2, 3, "heiheihei", 5).collect{case i: Int => i * 2}
    //    println(result2)

    val f1 = new PartialFunction[Any, Int] {
      def apply(any: Any) = any.asInstanceOf[Int] + 1

      def isDefinedAt(any: Any) = if (any.isInstanceOf[Int]) true else false
    }
    val rf1 = List(1, 3, 5, "seven") collect f1
    println(rf1)
    //----------------------------与上述功能一样的------------------------------
    def f2: PartialFunction[Any, Int] = {
      case i: Int => i + 1
    }
    val rf2 = List(1, 3, 5, "seven") collect f2
    println(rf2)


  }
}
