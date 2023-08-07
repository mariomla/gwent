package gwent.effect

import gwent.board.{Board, Zone}
import gwent.cards.ICard

// Efecto Vacio

trait IEffect {
  def applyToBoard(aBoard: Board): Unit
  def applyToZone(aZone: Zone): Unit
  def applyToCard(aCard: ICard): Unit
}
