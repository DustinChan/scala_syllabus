package opera


object InterableSyllabus {
  def main(args: Array[String]): Unit = {
    val arr1 = new Array[Int](10)
//    int[] arr1 = new int[10];
    val arr2 = Array(1, 2, 3)
//    arr2(2) = 10
//    println(arr2.mkString(" "))
    // int[] arr2 = {1, 2, 3}
    // int[] arr2 = new int[]{1, 2, 3}
    val arr3 = arr2 :+ 99
    println(arr3.mkString(" "))
    println(arr2.mkString(" "))
    println(arr1.mkString(" "))
  }
}
