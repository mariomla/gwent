package gwent.states

class PlayerOneTurn extends State {
  override def playerOnePlayCard(): Unit = this.changeState(new PlayerTwoTurn)

  override def playerOnePass(): Unit = this.changeState(new PlayerTwoInfiniteTurn)

  override def isPlayerOneTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerOneTurn => true
    case _ => false
  }

  override def toString: String = "State(PlayerOneTurn)"
}
