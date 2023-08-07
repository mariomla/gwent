package gwent.effect
import gwent.board.{Board, Zone}
import gwent.cards.ICard
import gwent.player.AbstractPlayer

class VinculoEstrecho(var card: ICard) extends IEffect {
  // Cuando se cree unca carta con este efecto hay que indicar la carta la cual tiene este efecto

  def setPlayer(aPlayer: AbstractPlayer): Unit = {
    this.player = aPlayer
  }

  override def applyToBoard(aBoard: Board): Unit = {
    if (this.player == 1) {
      this.applyToZone()
    }
  }

  override def applyToZone(aZone: Zone): Unit = ???

  override def applyToCard(aCard: ICard): Unit = ???
}
