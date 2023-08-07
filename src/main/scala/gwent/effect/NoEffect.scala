package gwent.effect
import gwent.cards.ICard
import gwent.board.{Board, Zone}

class NoEffect extends IEffect {
  override def applyToBoard(aBoard: Board): Unit = {}
  override def applyToZone(aZone: Zone): Unit = {}
  override def applyToCard(aCard: ICard): Unit = {}

  override def equals(other: Any): Boolean = other match {
    case that: NoEffect => true
    case _ => false
  }

  override def toString: String = "Effect(No Effect)"
}
