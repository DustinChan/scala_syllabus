package unit5

import scala.collection.mutable


object CollectionSyllabus {
  def main(args: Array[String]): Unit = {
    //2 定长数组
    val arr1 = new Array[Int](10)
    println(arr1.mkString(", "))
    val arr2 = Array(1, 2, 3)
    println(arr2.mkString(", "))
    //赋值及取值
    arr2(1) = 10 //等价于arr2.update(1, 10)
    println(arr2.mkString(", "))
    //追加
    val arr3 = "???" +: arr1
    println(arr3.mkString(", "))

    //变长数组
    import scala.collection.mutable.ArrayBuffer
    // 小括号可以存放初始化的元素内容
    val arrBuffer1 = ArrayBuffer[Int](10, 9, 8)
    println(arrBuffer1)
    //赋值，取值
    arrBuffer1(1) = -1
    println(arrBuffer1)
    println(arrBuffer1(1))
    println(arrBuffer1.apply(2))
    //追加
    arrBuffer1.append(1, 2, 3)
    println(arrBuffer1)

    val arrBuffer2 = arrBuffer1 :+ 99
    println(arrBuffer1)
    println(arrBuffer2)

    //3 定义多维数组
    val arr4 = Array.ofDim[Int](3, 4)
    //赋值 取值
    arr4(1)(2) = 1
    for(x <- arr4){
      println(x.mkString(", "))
    }
    println(arr4(1)(2))
    //追加
    val arr5 = arr4 :+ Array(1, 2, 3)
    for(x <- arr5){
      println(x.mkString(", "))
    }

    // scala与java的互相转换
    val arr6 = ArrayBuffer("1", "2", "3")
    //Scala to Java
    import scala.collection.JavaConversions._
    val javaArr = new ProcessBuilder(arr6)
    javaArr.command().add("10")
    println(javaArr.command())

    //java to scala
    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable.Buffer
    val scalaArr: Buffer[String] = javaArr.command()
    println(scalaArr)

    //3 元组
    //创建
    val tuple1 = (1, 2, 3.0F, "heiheihei", 4)
    //赋值 取值
    println(tuple1._4)
    //tuple的遍历
    for(e <- tuple1.productIterator){
      println(e)
    }

    tuple1.productIterator.foreach(println(_))
    tuple1.productIterator.foreach(i => println("tuple1中的元素：" + i))

    // List
    val list1 = List(1, 2)
    //取值 赋值
    println(list1(1))
    val list1_2 = list1.updated(1, 10)
    println(list1)
    println(list1_2)
    //追加，另一种创建方式
    val list2 = 1 :: 2 :: 3 :: List(6, 7) :: Nil
    println(list2)

    val list3 = scala.collection.mutable.ListBuffer[Int]()
    list3.append(1, 2)
    println(list3)
    list3 update(0, 10)
    println(list3)

    //队列
    val q1 = scala.collection.mutable.Queue[Int](1, 2)
    println(q1)
    val q2 = new mutable.Queue[Int]()
    q2 ++= q1
    println(q2)
    //取值 赋值
    println(q1(1))
    q1(1) = 10
    println(q1)
    //追加元素
    q1 += 20
    q1 ++= List(1, 2, 3)
    println(q1)

    q1.enqueue(99, 98)
    println(q1)

    //删除
    q1.dequeue()
    println(q1)

    //3个常用方法
    println(q1.head)
    println(q1.last)
    println(q1.tail)

    //Map
    val map1 = Map("Alice" -> "Alice", "Bob" -> 21, "Kotlin" -> 20)
    println(map1)
    val map2 = mutable.Map(("Alice", 22), ("Bob", 21))
    println(map2)
    //取值 赋值
    println(map1("Alice"))
    println(map1.updated("Alice", 90))
    println(map1)
    map2("Kotlin") = 50
    println(map2)

    //赋值--追加
    map2 += ("Alice" -> 80)
    map2 += ("AAA" -> 10)
    println(map2)

    //遍历
    for(m <- map2){
      println(m)
    }

    for((k, v) <- map2){
      println(k + ":" + v)
    }

    //Set
    //创建
    val set1 = Set(1, 2, 2, 3)
    println(set1)
    val set2 = mutable.Set(1, 2, 2, 3)
    println(set2)

    //取值
    println(set1(1))
    //追加值
    set2.add(4)
    println(set2)
    set2 += 5
    set2.remove(2)
    set2 -= 1
    println(set2)

    for(s <- set2){
      println(s)
    }

    //集合中的元素与函数之间的映射
    val list11 = List("Alice", "Bob", "Kotlin")
    def f1(x: String): String = {
      x.toUpperCase
    }
     val list11_2 = list11.map(f1)
//     val list11_2 = list11.map(x => x.toUpperCase)
    val list11_3 = list11.map(_.toLowerCase)
    val list11_4 = list11.map(x => x.toUpperCase + x.toLowerCase)
    println(list11_2)
    println(list11_3)
    println(list11_4)

    //化简，折叠，扫描
    val list12 = List(1, 2, 3, 4, 5)
//    val list12_LeftInt = list12.reduceLeft(_ - _)
    val list12_LeftInt = list12.reduceLeft((result, x) => result - x)
    println(list12_LeftInt)
    val list12_RightInt = list12.reduceRight(_ - _)
    println(list12_RightInt)

    //fold
    val list13 = List(1, 9, 2, 8)
    val list13_fold = list13.fold(5)((sum, y) => sum - y)
    println(list13_fold)

    val list13_fold_right = list13.foldRight(100)((sum, y) => sum - y)
    println(list13_fold_right)

    val myFunction = (x: Int) => (y: Int) => x + y
    def myFunctionCurry(x: Int)(y: Int) = {
      x + y
    }
    println(myFunction(10)(20))
//    println(myFunctionCurry(10))

    val sentence = "一首现代诗《笑里藏刀》:哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈刀哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
    val map5 = (mutable.Map[Char, Int]() /: sentence)((m, c) => m + (c -> (m.getOrElse(c, 0) + 1)))
    println(map5)

    val scan = (1 to 10).scanLeft(0)(_ + _)
    println(scan)


    //拉链
    val zip1 = List("15837312345", "137373123456")
    val zip2 = List("孙悟空", "猪八戒")
    val zipResultList = zip1 zip zip2
    println(zipResultList)
    val zipMap = mutable.Map[String, String]()
    for(e <- zipResultList){
      zipMap += e
    }
    println(zipMap)

    //stream
    def numsForm(initNum: BigInt): Stream[BigInt] = {
      initNum #:: numsForm(initNum + 1)
    }

    val numStream = numsForm(0)//numStream -> (0, ?)
    val s1 = numStream.tail//(1, ?) //(1, 2, ?)
    val s2 = s1.tail//1、生成一个排除了首元素的新集合 2、tail方法会触发stream的使用，会在调用.tail方法的stream上新增元素
    println(s1)
    println(s2)
//    println(numStream.tail.tail.tail)

    //view
//    val view = (1L to 10000000L).view.map(x => x).filter(x => x.toString.reverse == x.toString)
//    println(view.mkString(" "))
//    println(view.mkString(" "))

    val result1 = (0 to 10000000).map{case _ => Thread.currentThread.getName}.distinct
    val result2 = (0 to 10000000).par.map{case _ => Thread.currentThread.getName}.distinct
    println(result1)
    println(result2)

  }
}
