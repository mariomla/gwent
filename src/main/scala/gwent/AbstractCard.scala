package gwent

abstract class AbstractCard(private val name: String, private val effect: String) extends ICard{
  override def getName: String = this.name

  override def getEffect: String = this.effect

  //override def playCardComputerPlayer(board: Board): Unit

  //override def playCardHumanPlayer(board: Board): Unit
  // FAltan los setters
}
