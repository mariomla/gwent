package gwent.cards

import gwent.board.Board
import gwent.cards.ICard
import gwent.effect.IEffect

/** Clase Abstracta para representar una carta
 *
 * Esta definida por su nombre (name) y el efecto que tiene (effect).
 * @param name El nombre de la carta
 * @param effect El efecto de la carta
 *               
 * Extiende de ICard
 */
abstract class AbstractCard(private val name: String, private var effect: IEffect) extends ICard{
  override def getName: String = this.name

  override def getEffect: IEffect = this.effect

}
