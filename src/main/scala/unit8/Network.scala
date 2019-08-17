package unit8

import scala.collection.mutable.ArrayBuffer

class Network {
  class Member(name: String){
    //用于存放某个Mem对象的联系人
    val contacts = new ArrayBuffer[Network#Member]()
  }

  //用于存放局域网中的用户
  val members = new ArrayBuffer[Network#Member]()

  def join(name:String) = {
    val m = new Member(name)
    members += m
    m
  }
}
