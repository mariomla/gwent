package gwent.effect
import gwent.board.{Board, Zone}
import gwent.cards.ICard

class CieloDespejado extends IEffect {
  override def applyToBoard(aBoard: Board): Unit = {
    this.applyToZone(aBoard.weatherZone)
  }

  override def applyToZone(aZone: Zone): Unit = {
    aZone.setZone(new Array[ICard](0))
  }

  override def applyToCard(aCard: ICard): Unit = {}
}
