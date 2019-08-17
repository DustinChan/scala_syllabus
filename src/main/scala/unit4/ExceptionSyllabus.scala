package unit4


object ExceptionSyllabus {
  def divider(x: Int, y:Int) = {
    if(y == 0) throw new RuntimeException("0不能作为除数")
    else
      x / y
  }

  def main(args: Array[String]): Unit = {
      try {
        divider(10, 0)
      } catch {
        case ex:RuntimeException => println("我成功捕获到了异常:" + ex.getMessage)
      } finally {}
  }
}
