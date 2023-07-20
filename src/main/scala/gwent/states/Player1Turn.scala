package gwent.states

class Player1Turn() extends State(){
  override def player1PlayCard(): Unit = this.changeState(new Player2Turn())

  override def player1Pass(): Unit = this.changeState(new Player2InfiniteTurn())

  override def isPlayer1Turn(): Boolean = true
}
