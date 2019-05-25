object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello World")

    val map = Map[Int, Int](1 -> 1, 2 -> 2, 3 -> 3)

    var result = for {
      i1 <- Some(1)
      i2 <- Some(2)
      i3 <- Some(3)
    } yield i1 + i2 + i3

    println(result)

    result = for {
      i1 <- Some(1)
      i2 <- Some(2)
      i3 <- None
    } yield i1 + i2

    println(result)

    result = for {
      i1 <- map get 1
      i2 <- map get 2
      i3 <- map get 3
    } yield i1 + i2 + i3

    println(result)

    result = for {
      i1 <- map get 1
      i2 <- map get 2
      i3 <- map get 4
    } yield i1 + i2 + i3

    println(result)

  }
}

