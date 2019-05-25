object BoolSample extends App {

  import scala.language.higherKinds


  trait Bool {
    type Not <: Bool
    type And[A <: Bool] <: Bool
    type Or[A <: Bool] <: Bool
  }

  trait True extends Bool {
    type Not = False
    type And[A <: Bool] = A
    type Or[A <: Bool] = True
  }

  trait False extends Bool {
    type Not = True
    type And[A <: Bool] = False
    type Or[A <: Bool] = A
  }

  object Bools {
    type ![A <: Bool] = A#Not
    type &&[A <: Bool, B <: Bool] = A#And[B]
    type ||[A <: Bool, B <: Bool] = A#Or[B]
  }

  import Bools._

  trait ToBool[A <: Bool] {
    def apply(): Boolean
  }

  def toBool[A <: Bool](implicit f: ToBool[A]) = f()

  implicit val toTrue = new ToBool[True] {
    def apply() = true
  }

  implicit val toFalse = new ToBool[False] {
    def apply() = false
  }

  println(toBool[True] == true)
  println(toBool[False] == false)

  println(toBool[![True]] == false)
  println(toBool[![False]] == true)
  println(toBool[![![True]]] == true)

  println(toBool[True && True] == true)
  println(toBool[True && False] == false)
  println(toBool[False && True] == false)
  println(toBool[False && False] == false)

  println(toBool[True || True] == true)
  println(toBool[True || False] == true)
  println(toBool[False || True] == true)
  println(toBool[False || False] == false)

}
