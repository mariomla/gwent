package gwent

abstract class UnitCard(private val name: String, private val effect: String, private val strength: Int)
  extends AbstractCard(name, effect) {
  
  def getStrength: Int = this.strength

  //override def playCardComputerPlayer(board: Board): Unit

  //override def playCardHumanPlayer(board: Board): Unit
  //play card y sette de streng
}

