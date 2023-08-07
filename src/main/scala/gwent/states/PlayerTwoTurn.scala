package gwent.states

class PlayerTwoTurn extends State {
  override def playerTwoPlayCard(): Unit = this.changeState(new PlayerOneTurn)

  override def playerTwoPass(): Unit = this.changeState(new PlayerOneInfiniteTurn)
  
  override def isPlayerTwoTurn: Boolean = true
}
