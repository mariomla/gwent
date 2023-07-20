package gwent.states

class Player1InfiniteTurn() extends State(){
  override def player1Pass(): Unit = {
    gameController.endRound()
    this.changeState(new Player1Turn())
  }

  override def playerLose(): Unit = this.changeState(new(GameEnded))

  override def isPlayer1InfiniteTurn(): Boolean = true
}
