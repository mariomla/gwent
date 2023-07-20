package gwent.states

class Player2InfiniteTurn() extends State() {
  override def player1Pass(): Unit = this.changeState(new Player1Turn())

  override def playerLose(): Unit = this.changeState(new(GameEnded))
  
  override def isPlayer2InfiniteTurn(): Boolean = true
}

