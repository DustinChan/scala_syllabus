package unit8

object ClassSyllabus {
  def main(args: Array[String]): Unit = {
    //简单类
    val dog = new Dog()
    dog.shout("wangwangwang~~")
    dog leg_= 10
    dog.setLeg(4)
    println(dog.leg)

    //构造器
    val cc = new ClassConstructor("Nick", 20)
    //单例模式
    val cacheBean = CacheBean()
    println(cacheBean)

    //嵌套类
    val network1 = new Network
    val nick = network1.join("Nick")//network1.Member
    val alice = network1.join("Alice")//network1.Member

    nick.contacts += alice
    alice.contacts += nick

    val network2 = new Network
    val jone = network2.join("Jone")//network2.Member

    nick.contacts += jone
  }
}
