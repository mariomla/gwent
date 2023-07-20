package gwent.states

class Player1InfiniteTurn() extends State(){
  override def player2Pass(): Unit = this.changeState(new Player1Turn())

  override def playerLose(): Unit = this.changeState(new(GameEnded))

  override def isPlayer1InfiniteTurn(): Boolean = true
}
