package u04lab.polyglot.a01a
import Logics.*
import u04lab.code.List
import u04lab.code.List.*
import u04lab.polyglot.Pair
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:

  val failuresLimit = 5
  var hit: List[Pair[Int, Int]] = Nil()
  val boatRow: Int = Random().nextInt(size)
  val boatLeftCol: Int = Random().nextInt(size - boat + 1)
  var failures = 0

  def hit(row: Int, col: Int): Result =
      if (row == boatRow && col >= boatLeftCol && col < boatLeftCol + boat)
          hit = Cons(Pair(row, col), hit)
          if length(hit) == boat then Result.WON else Result.HIT
      else
          failures += 1
          if failures == failuresLimit then Result.LOST else Result.MISS
