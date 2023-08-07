package gwent.states

import gwent.board.Board
import gwent.player.{ComputerPlayer, HumanPlayer}
import gwent.states.{PlayerOneTurn, PlayerTwoTurn, PlayerOneInfiniteTurn, PlayerTwoInfiniteTurn, GameEnded}

class GameController {
  private var state: State = new PlayerOneTurn()
  private var board: Board = new Board()
  private var player1: HumanPlayer = null
  private var player2: ComputerPlayer = null
  state.setGameController(this)

  def setState(aState: State): Unit = {
    state = aState
    state.setGameController(this)
  }

  def endRound(): Unit = {}
}
