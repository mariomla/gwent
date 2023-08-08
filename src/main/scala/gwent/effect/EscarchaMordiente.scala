package gwent.effect
import gwent.board.{Board, Zone}
import gwent.cards.ICard

/** Clase que representa al efecto de Escarcha Mordiente
 *
 * Extiende de IEffect
 */

class EscarchaMordiente extends IEffect {

  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {
    card.setStrength(1)
  }

  override def applyEffectRanged(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {}

  override def equals(other: Any): Boolean = other match {
    case that: EscarchaMordiente => true
    case _ => false
  }

  override def toString: String = "Effect(EscarchaMordiente)"
}
