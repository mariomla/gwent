package gwent

trait ICard {
  def getName: String

  def getEffect: String
  
  //setters

  def playCardHumanPlayer(board: Board): Unit
  
  def playCardComputerPlayer(board: Board): Unit
  
  def handleEffect(board: Board, section: Int): Unit
}
