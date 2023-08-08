package gwent.states

class PlayerOneInfiniteTurn extends State{

  override def playerOnePass(): Unit = {
    this.changeState(new PlayerOneTurn)
    gameController.endRound()
  }

  override def playerOnePlayCard(): Unit = {}
  

  override def isPlayerOneInfiniteTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerOneInfiniteTurn => true
    case _ => false
  }

  override def toString: String = "State(PlayerOneInfiniteTurn)"
}
