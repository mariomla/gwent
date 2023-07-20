package gwent.states

class Player2Turn() extends State(){
    override def player2PlayCard(): Unit = this.changeState(new Player1Turn())

    override def player2Pass(): Unit = this.changeState(new Player1InfiniteTurn())

    override def isPlayer2Turn(): Boolean = true
}

