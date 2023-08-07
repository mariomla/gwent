package gwent.effect
import gwent.board.{Zone, Board}
import gwent.cards.ICard

class LluviaTorrencial extends IEffect {
  
  override def applyToBoard(aBoard: Board): Unit = {
    this.applyToZone(aBoard.siegeZonePlayerOne)
    this.applyToZone(aBoard.siegeZonePlayerTwo)
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
    case that: LluviaTorrencial => true
    case _ => false
  }

  override def toString: String = "Effect(LluviaTorrencial)"

}
