package gwent.states

class State() {
  private var gameController: GameController = null
  def setGameController(aGameController: GameController): Unit = {
    this.gameController= aGameController
  }

  protected def changeState(state: State): Unit = {
    if (gameController != null) {
      gameController.setState(state)
    }
  }

  private def error() = throw new AssertionError("Wrong State")

  def player1PlayCard(): Unit = error()

  def player2PlayCard(): Unit = error()

  def player1Pass(): Unit = error()

  def player2Pass(): Unit = error()
  
  def playerLose(): Unit = error()


  def isPlayer1Turn(): Boolean = false

  def isPlayer2Turn(): Boolean = false

  def isPlayer1InfiniteTurn(): Boolean = false

  def isPlayer2InfiniteTurn(): Boolean = false
}
