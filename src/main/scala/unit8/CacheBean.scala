package unit8

class CacheBean private() {

}

object CacheBean{
  var instance: CacheBean = _
  def apply(): CacheBean = {
    if(instance == null){
      instance = new CacheBean
    }
    instance
  }
}
