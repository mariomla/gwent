package gwent.states

class PlayerOneTurn extends State {
  override def playerOnePlayCard(): Unit = this.changeState(new PlayerTwoTurn)

  override def playerOnePass(): Unit = this.changeState(new PlayerTwoInfiniteTurn)

  override def isPlayerOneTurn: Boolean = true
}
