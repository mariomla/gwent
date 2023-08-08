package gwent.effect
import gwent.board.{Zone, Board}
import gwent.cards.ICard

/** Clase que representa al efecto de Lluvia Torrencial
 *
 * Extiende de IEffect
 */

class LluviaTorrencial extends IEffect {

  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectRanged(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {
    card.setStrength(1)
  }

  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {}

  override def equals(other: Any): Boolean = other match {
    case that: LluviaTorrencial => true
    case _ => false
  }

  override def toString: String = "Effect(LluviaTorrencial)"

}
