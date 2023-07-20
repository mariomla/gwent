package gwent.states

import gwent.{Board, ICard, UnitCard}
import gwent.observer.{ISubject, Observer}
import gwent.player.{ComputerPlayer, HumanPlayer}

class GameController() extends Observer{
  private var state: State = new Player1Turn()
  private var board: Board = new Board()
  private var player1: HumanPlayer = null
  private var player2: ComputerPlayer = null
  state.setGameController(this)

  def createHumanPlayer(name: String, cardDeck: List[ICard]): Unit = {
    player1 = HumanPlayer(name, cardDeck)
  }

  def createComputerPlayer(name: String, cardDeck: List[ICard]): Unit = {
    player2 = ComputerPlayer(name, cardDeck)
  }

  def startGame(player1: HumanPlayer, player2: ComputerPlayer): Unit = {
    var i: Int = 0
    player1.shuffleDeck()
    player2.shuffleDeck()
    while (i < 10) {
      player1.drawCard()
      player2.drawCard()
    }
  }

  def pointsCalculator(zone: List[ICard]): Int = {
    zone.head match {
      case z: UnitCard => {
        val restoZone: List[ICard] = zone.tail
        this.pointsCalculator(restoZone) + 1
      }
      case _ => 0
    }
  }
  def endRound(): Unit = {
    val pointsPlayerOne: Int = pointsCalculator(board.meleeZonePlayerOne) + pointsCalculator(board.rangedZonePlayerOne) + pointsCalculator(board.siegeZonePlayerOne)
    val pointsPlayerTwo: Int = pointsCalculator(board.meleeZonePlayerTwo) + pointsCalculator(board.rangedZonePlayerTwo) + pointsCalculator(board.siegeZonePlayerTwo)
    if (pointsPlayerOne > pointsPlayerTwo) {
      player2.decrementGemstones()
    } else if (pointsPlayerTwo > pointsPlayerOne) {
      player1.decrementGemstones()
    }else {
      player1.decrementGemstones()
      player2.decrementGemstones()
    }
  }

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
