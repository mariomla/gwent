package gwent.cards

import gwent.cards.UnitCard
import gwent.board.{Board, Zone}
import gwent.effect.IEffect
import gwent.effect.NoEffect

class MeleeUnit(private val name: String, private val effect: IEffect, private val strength: Int)
                extends UnitCard(name, effect, strength){

  def this(name: String, strength: Int) = this(name, new NoEffect, strength)

  override def playCardHumanPlayer(board: Board): Unit = {
    board.meleeZonePlayerOne.cards = board.meleeZonePlayerOne.cards :+ this
  }

  override def playCardComputerPlayer(board: Board): Unit = {
    board.meleeZonePlayerTwo.cards = board.meleeZonePlayerTwo.cards :+ this
  }

  override def applyEffect(board: Board, section: Int, effect: IEffect): Unit = {
    effect.applyEffectMelee(section, this, board)
  }

  override def toString = s"MeleeUnit($name, $effect, $strength)"

  private def canEqual(other: Any): Boolean = other.isInstanceOf[MeleeUnit]

  override def equals(other: Any): Boolean = other match
    case that: MeleeUnit =>
      that.canEqual(this) &&
        name == that.name &&
        effect == that.effect &&
        strength == that.strength
    case _ => false

  override def hashCode(): Int =
    val state = Seq(name, effect, strength)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)

  //play card
}
