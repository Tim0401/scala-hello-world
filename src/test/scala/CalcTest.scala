import org.scalatest._
import Matchers._


class CalcTest extends FlatSpec {

  val calc = new Calc

  calc.sum(Seq(1, 2, 3)) should be (6)
  calc.sum(Seq(1, 2, 3)) should be === 6
  calc.hello() should be === "Hello"

  "sum関数" should "整数の配列を取得し、それらを足し合わせた整数を返すことができる" in {
    assert(calc.sum(Seq(1, 2, 3)) === 6)
    assert(calc.sum(Seq(0)) === 0)
    assert(calc.sum(Seq(-1, 1)) === 0)
    assert(calc.sum(Seq()) === 0)
  }
}
