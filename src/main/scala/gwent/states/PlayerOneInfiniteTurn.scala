package gwent.states

class PlayerOneInfiniteTurn extends State{

  override def playerOnePass(): Unit = {
    gameController.endRound()
    this.changeState(new PlayerOneTurn)
  }

  override def playerOnePlayCard(): Unit = {}

  override def playerLose(): Unit = this.changeState(new(GameEnded))

  override def isPlayerOneInfiniteTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerOneInfiniteTurn => true
    case _ => false
  }

  override def toString: String = "State(PlayerOneInfiniteTurn)"
}
