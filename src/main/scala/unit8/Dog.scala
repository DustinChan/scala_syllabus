package unit8

import scala.beans.BeanProperty

class Dog {
  @BeanProperty var leg:Int = _

  def shout(msg: String) = {
    println(msg)
  }
}
