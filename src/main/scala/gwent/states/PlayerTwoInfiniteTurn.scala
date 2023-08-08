package gwent.states

class PlayerTwoInfiniteTurn extends State {

  override def playerTwoPass(): Unit = {
    this.changeState(new PlayerOneTurn)
    gameController.endRound()
  }

  override def playerTwoPlayCard(): Unit = {}
  

  override def isPlayerTwoInfiniteTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerTwoInfiniteTurn => true
    case _ => false
  }
  

  override def toString: String = "State(PlayerTwoInfiniteTurn)"
}
