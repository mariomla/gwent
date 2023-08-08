package gwent.states

class PlayerTwoTurn extends State {
  override def playerTwoPlayCard(): Unit = this.changeState(new PlayerOneTurn)

  override def playerTwoPass(): Unit = this.changeState(new PlayerOneInfiniteTurn)
  
  
  override def isPlayerTwoTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerTwoTurn => true
    case _ => false
  }

  override def toString: String = "State(PlayerTwoTurn)"
}
