package gwent.cards

import gwent.cards.UnitCard
import gwent.board.{Board, Zone}
import gwent.effect.IEffect
import gwent.effect.NoEffect

class RangedUnit(private val name: String, private val effect: IEffect, private val strength: Int)
                 extends UnitCard(name, effect, strength) {

  def this(name: String, strength: Int) = this(name, new NoEffect, strength)
  
  override def playCardHumanPlayer(board: Board): Unit = {
    board.rangedZonePlayerOne.cards = board.rangedZonePlayerOne.cards :+ this
  }

  override def playCardComputerPlayer(board: Board): Unit = {
    board.rangedZonePlayerTwo.cards = board.rangedZonePlayerTwo.cards :+ this
  }
 
  override def toString = s"RangedUnit($name, $effect, $strength)"

  private def canEqual(other: Any): Boolean = other.isInstanceOf[RangedUnit]

  override def equals(other: Any): Boolean = other match
    case that: RangedUnit =>
      that.canEqual(this) &&
        name == that.name &&
        effect == that.effect &&
        strength == that.strength
    case _ => false

  override def hashCode(): Int =
    val state = Seq(name, effect, strength)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)

  //playcard
}
