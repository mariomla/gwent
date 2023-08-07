package gwent.states

class State {
  protected var gameController: GameController = null

  def setGameController(aGameController: GameController): Unit = {
    this.gameController = aGameController
  }

  protected def changeState(state: State): Unit = {
    if (gameController != null) {
      gameController.setState(state)
    }
  }

  private def error() = throw new AssertionError("Wrong State")

  def playerOnePlayCard(): Unit = error()

  def playerTwoPlayCard(): Unit = error()

  def playerOnePass(): Unit = error()

  def playerTwoPass(): Unit = error()

  def playerLose(): Unit = error()


  def isPlayerOneTurn: Boolean = false

  def isPlayerTwoTurn: Boolean = false

  def isPlayerOneInfiniteTurn: Boolean = false

  def isPlayerTwoInfiniteTurn: Boolean = false
}

