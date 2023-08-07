package gwent.effect
import gwent.board.{Board, Zone}
import gwent.cards.ICard

class NieblaImpenetrable extends IEffect {

  override def applyToBoard(aBoard: Board): Unit = {
    this.applyToZone(aBoard.rangedZonePlayerOne)
    this.applyToZone(aBoard.rangedZonePlayerTwo)
  }

  override def applyToZone(aZone: Zone): Unit = {
    for (card <- aZone.cards) {
      this.applyToCard(card)
    }
  }

  override def applyToCard(aCard: ICard): Unit = {
    aCard.setStrength(1)
  }

  override def equals(other: Any): Boolean = other match {
    case that: NieblaImpenetrable => true
    case _ => false
  }

  override def toString: String = "Effect(NieblaImpenetrable)"
}
