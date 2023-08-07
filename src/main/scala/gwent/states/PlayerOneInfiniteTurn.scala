package gwent.states

class PlayerOneInfiniteTurn extends State{

  override def playerOnePass(): Unit = {
    gameController.endRound()
    this.changeState(new PlayerOneTurn)
  }

  override def playerLose(): Unit = this.changeState(new(GameEnded))

  override def isPlayerOneInfiniteTurn: Boolean = true
}
