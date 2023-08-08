package gwent.effect

import gwent.board.{Board, Zone}
import gwent.cards.ICard

/** Trait para definir a los efectos y establecer sus metodos y comportamiento       
 */

trait IEffect {
  def applyEffectMelee(section: Int, card: ICard, board: Board): Unit
  def applyEffectRanged(section: Int, card: ICard, board: Board): Unit
  def applyEffectSiege(section: Int, card: ICard, board: Board): Unit
  def applyEffectWeather(section: Int, card: ICard, board: Board): Unit
}
