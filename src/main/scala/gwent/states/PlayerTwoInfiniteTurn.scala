package gwent.states

class PlayerTwoInfiniteTurn extends State {

  override def playerTwoPass(): Unit = {
    gameController.endRound()
    this.changeState(new PlayerOneTurn)
  }

  override def playerTwoPlayCard(): Unit = {}

  override def playerLose(): Unit = this.changeState(new(GameEnded))

  override def isPlayerTwoInfiniteTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerTwoInfiniteTurn => true
    case _ => false
  }
  

  override def toString: String = "State(PlayerTwoInfiniteTurn)"
}
