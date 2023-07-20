package gwent.states

import gwent.observer.{ISubject, Observer}

class GameController() extends Observer{
  private var state: State = new Player1Turn()
  state.setGameController(this)

  def setState(aState: State): Unit = {
    state = aState
    state.setGameController(this)
  }

  def player1PlayCard(): Unit = state.player1PlayCard()

  def player2PlayCard(): Unit = state.player2PlayCard()

  def player1Pass(): Unit = state.player1Pass()

  def player2Pass(): Unit = state.player2Pass()
  
  def playerLose(): Unit = {
    state.playerLose()
  }

  def isPlayer1Turn(): Boolean = state.isPlayer1Turn()
  def isPlayer2Turn(): Boolean = state.isPlayer2Turn()

  def isPlayer1InfiniteTurn(): Boolean = state.isPlayer1InfiniteTurn()

  def isPlayer2InfiniteTurn(): Boolean = state.isPlayer2InfiniteTurn()
  
  

  override def update(observed: ISubject): Unit = {
    println("Player " + observed.toString + " loses. End of the game.")
    playerLose()
  }
}
