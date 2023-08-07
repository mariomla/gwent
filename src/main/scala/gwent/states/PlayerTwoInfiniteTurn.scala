package gwent.states

class PlayerTwoInfiniteTurn extends State {

  override def playerTwoPass(): Unit = {
    gameController.endRound()
    this.changeState(new PlayerOneTurn)
  }

  override def playerLose(): Unit = this.changeState(new(GameEnded))

  override def isPlayerTwoInfiniteTurn: Boolean = true
}
