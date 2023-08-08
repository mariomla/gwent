package gwent.effect
import gwent.board.{Board, Zone}
import gwent.cards.ICard

/** Clase que representa al efecto de Cielo Despejado
 *
 * Extiende de IEffect
 */

class CieloDespejado extends IEffect {
  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectRanged(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {
    board.weatherZone.setZone(new Array[ICard](0))
  }

  override def equals(other: Any): Boolean = other match {
    case that: CieloDespejado => true
    case _ => false
  }

  override def toString: String = "Effect(CieloDespejado)"
}
