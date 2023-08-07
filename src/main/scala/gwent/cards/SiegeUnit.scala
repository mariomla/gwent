package gwent.cards

import gwent.cards.UnitCard
import gwent.board.{Board, Zone}
import gwent.effect.IEffect
import gwent.effect.NoEffect

class SiegeUnit(private val name: String, private val effect: IEffect, private val strength: Int)
                extends UnitCard(name, effect, strength) {

  def this(name: String, strength: Int) = this(name, new NoEffect, strength)

  override def playCardHumanPlayer(board: Board): Unit = {
    board.siegeZonePlayerOne.cards = board.siegeZonePlayerOne.cards :+ this
  }

  override def playCardComputerPlayer(board: Board): Unit = {
    board.siegeZonePlayerTwo.cards = board.siegeZonePlayerTwo.cards :+ this
  }

  override def applyEffect(board: Board, section: Int, effect: IEffect): Unit = {
    effect.applyEffectSiege(section, this, board)
  }

  override def toString = s"SiegeUnit($name, $effect, $strength)"

  private def canEqual(other: Any): Boolean = other.isInstanceOf[SiegeUnit]

  override def equals(other: Any): Boolean = other match
    case that: SiegeUnit =>
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