package gwent.states

import gwent.board.{Board, Zone}
import gwent.cards.ICard
import gwent.observer.{Observer, ISubject}
import gwent.player.{ComputerPlayer, HumanPlayer}
import gwent.states.{GameEnded, PlayerOneInfiniteTurn, PlayerOneTurn, PlayerTwoInfiniteTurn, PlayerTwoTurn}

/** Clase del controlador del juego. Posee las variables state, que representa el estado de la partida; board, que
 * representa el tablero donde se juega; player1, que representa al jugador 1 el cual es humano y player2, que
 * representa al jugador 2 el cual es una computadora.
 * 
 * Extiende de Observer, pues estara observando a los player.
 */

class GameController extends Observer{
  private var state: State = new PlayerOneTurn()
  private var board: Board = new Board()
  private var player1: HumanPlayer = null
  private var player2: ComputerPlayer = null
  state.setGameController(this)

  def getState: State = {this.state}
  def getPlayer1: HumanPlayer = {this.player1}

  def getPlayer2: ComputerPlayer = {this.player2}

  def getBoard: Board = {this.board}

  def createHumanPlayer(name: String, cardDeck: List[ICard]): Unit = {
    player1 = HumanPlayer(name, cardDeck)
    player1.registerObserver(this)
  }

  def createComputerPlayer(name: String, cardDeck: List[ICard]): Unit = {
    player2 = ComputerPlayer(name, cardDeck)
    player2.registerObserver(this)
  }

  def startGame(cardsToDraw: Int = 10): Unit = {
    if (player1 == null || player2 == null) {println("Primero cree a ambos jugadores")}
    else {
      var i: Int = 0
      player1.shuffleDeck()
      player2.shuffleDeck()
      for (i <- 0 until cardsToDraw) {
        player1.drawCard()
        player2.drawCard()
      }
    }
  }

  def setState(aState: State): Unit = {
    state = aState
    state.setGameController(this)
  }

  def pointsPerZone(zone: Zone): Int = {
    var points: Int = 0
    for (card <- zone.cards){
      points = points + card.getStrength
    }
    points
  }

  def totalPoints(section: Int): Int = {
    var points: Int = 0
    if(section == 1) {
      points = pointsPerZone(board.meleeZonePlayerOne) + pointsPerZone(board.rangedZonePlayerOne) +
               pointsPerZone(board.siegeZonePlayerOne)}
    else {
      points = pointsPerZone(board.meleeZonePlayerTwo) + pointsPerZone(board.rangedZonePlayerTwo) +
               pointsPerZone(board.siegeZonePlayerTwo)
    }
    points
  }

  def takeCards(): Unit = {
    val cardsToTakeOne = 3.min(10 - player1.getCardHand.length)
    val cardsToTakeTwo = 3.min(10 - player2.getCardHand.length)
    for(i <- 0 until cardsToTakeOne){player1.drawCard()}
    for(j <- 0 until cardsToTakeTwo){player2.drawCard()}
  }

  def endRound(): Unit = {
    val pointsPlayerOne = totalPoints(1)
    val pointsPlayerTwo = totalPoints(2)
    if(pointsPlayerOne > pointsPlayerTwo) {
      player2.decrementGemstones()
    } else if (pointsPlayerOne < pointsPlayerTwo) {
      player1.decrementGemstones()
    }
    else {
      player1.decrementGemstones()
      player2.decrementGemstones()
    }
    player1.shuffleDeck()
    player2.shuffleDeck()
    this.takeCards()
  }

  def playerOnePlayCard(card: ICard): Unit = {
    player1.playCard(card, board)
    state.playerOnePlayCard()
  }

  def playerTwoPlayCard(card: ICard): Unit = {
    player2.playCard(card, board)
    state.playerTwoPlayCard()
  }

  def playerOnePass(): Unit = {state.playerOnePass()}

  def playerTwoPass(): Unit = {state.playerTwoPass()}

  def isPlayerOneTurn: Boolean = state.isPlayerOneTurn

  def isPlayerTwoTurn: Boolean = state.isPlayerTwoTurn

  def isPlayerOneInfiniteTurn: Boolean = state.isPlayerOneInfiniteTurn

  def isPlayerTwoInfiniteTurn: Boolean = state.isPlayerTwoInfiniteTurn

  def isTheGameEnded: Boolean = state.isTheGameEnded

  def playerLose(): Unit = {
    state.playerLose()
  }

  override def update(observed: ISubject): Unit = {
    println("Player " + observed.toString + " loses. End of the game.")
    playerLose()
  }
}
