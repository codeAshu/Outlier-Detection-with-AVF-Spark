/**
 * Created by ashu on 11/16/14.
 */
import org.scalatest.FunSuite
import org.scalatest.FlatSpec

class outSuit extends FunSuite {

  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }

  test("Invoking head on an empty Set should produce NoSuchElementException") {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }

}
