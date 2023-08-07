package gwent.effect

import gwent.board.{Board, Zone}
import gwent.cards.ICard

// Efecto Vacio

trait IEffect {
  def applyEffectMelee(section: Int, card: ICard, board: Board): Unit
  def applyEffectRanged(section: Int, card: ICard, board: Board): Unit
  def applyEffectSiege(section: Int, card: ICard, board: Board): Unit
  def applyEffectWeather(section: Int, card: ICard, board: Board): Unit
}
