package gwent.cards

import gwent.board.Board
import gwent.effect.IEffect

trait ICard {
  def getName: String

  def getEffect: IEffect
  
  def setStrength(newStrength: Int): Unit
  
  //setters

  def playCardHumanPlayer(board: Board): Unit
  
  def playCardComputerPlayer(board: Board): Unit
  
 // def handleEffect(board: Board, section: Int): Unit
}
