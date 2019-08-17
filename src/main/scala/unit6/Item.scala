package unit6

abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, item: Item*) extends Item

/**
    Bundle("从出门一条狗到装备全发光修炼之路系列", 10.0,
            Article("如何快速捡起地上的装备", 50)
            Bundle("从入门到放弃系列", 12，
              Article("Java从入门到放弃", 1),
              Article("Python从入门到放弃", 2)

  50 + 1 + 2 - 10 - 12 = 31
  */
