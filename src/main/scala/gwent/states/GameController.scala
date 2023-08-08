package gwent.states

import gwent.board.{Board, Zone}
import gwent.cards.ICard
import gwent.observer.{Observer, ISubject}
import gwent.player.{ComputerPlayer, HumanPlayer}
import gwent.states.{GameEnded, PlayerOneInfiniteTurn, PlayerOneTurn, PlayerTwoInfiniteTurn, PlayerTwoTurn}

/** Clase del controlador del juego.
 *
 * Extiende de Observer, pues estara observando a los player.
 */

class GameController extends Observer{
  /** El controlador posee las variables state, que representa el estado de la partida; board, que
   * representa el tablero donde se juega; player1, que representa al jugador 1 el cual es humano y player2, que
   * representa al jugador 2 el cual es una computadora.
   *
   */
  private var state: State = new PlayerOneTurn()
  private var board: Board = new Board()
  private var player1: HumanPlayer = null
  private var player2: ComputerPlayer = null
  state.setGameController(this)

  def getState: State = {this.state}
  def getPlayer1: HumanPlayer = {this.player1}

  def getPlayer2: ComputerPlayer = {this.player2}

  def getBoard: Board = {this.board}

  /** Metodo para crear un Jugador Humano
   *
   * @param name nombre del jugador
   * @param cardDeck mazo de cartas del jugador
   */
  def createHumanPlayer(name: String, cardDeck: List[ICard]): Unit = {
    player1 = HumanPlayer(name, cardDeck)
    player1.registerObserver(this)
  }

  /** Metodo para crear un Jugador Computador
   *
   * @param name     nombre del jugador
   * @param cardDeck mazo de cartas del jugador
   */
  def createComputerPlayer(name: String, cardDeck: List[ICard]): Unit = {
    player2 = ComputerPlayer(name, cardDeck)
    player2.registerObserver(this)
  }

  /** Metodo que aplica todos los pasos necesarios para empezar una partida
   *
   * @param cardsToDraw Cartas que tomara del mazo cada jugador, por defecto es 10.
   */
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

  /** Metodo para cambiar de estado del juego
   *
   * @param aState estado al cual se desea cambiar
   */
  def setState(aState: State): Unit = {
    state = aState
    state.setGameController(this)
  }

  /** Metodo que cuenta cuanta fuerza tienen en total las cartas de una zona.
   *
   * @param zone Zona donde se cuenta la fuerza total
   * @return Devuelve el numero de fuerza total.
   */
  def pointsPerZone(zone: Zone): Int = {
    var points: Int = 0
    for (card <- zone.cards){
      points = points + card.getStrength
    }
    points
  }

  /** Metodo para calcular la fuerza acumulada entre todas las zonas de un jugador.
   *
   * @param section seccion sobre la cual se calculara la fuerza acumulada
   * @return Devuelve la fuerza acumulada entre todas las zonas de un jugador.
   */
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

  /** Metodo que aplica los pasos necesario para tomar cartas al finalizar una ronda
   */
  def takeCards(): Unit = {
    val cardsToTakeOne = 3.min(10 - player1.getCardHand.length)
    val cardsToTakeTwo = 3.min(10 - player2.getCardHand.length)
    for(i <- 0 until cardsToTakeOne){player1.drawCard()}
    for(j <- 0 until cardsToTakeTwo){player2.drawCard()}
  }

  /** Metodo que aplica los pasos necesario para terminar una ronda, determinar quien gano dicha ronda y empezar una
   * ronda nueva
   */
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

  /** Metodo para que el player 1 pueda jugar una carta
   *
   * @param card carta que sera jugada
   */
  def playerOnePlayCard(card: ICard): Unit = {
    player1.playCard(card, board)
    state.playerOnePlayCard()
  }

  /** Metodo para que el player 2 pueda jugar una carta
   *
   * @param card carta que sera jugada
   */
  def playerTwoPlayCard(card: ICard): Unit = {
    player2.playCard(card, board)
    state.playerTwoPlayCard()
  }

  /** Metodo para que el jugador uno pueda pasar de turno
   */
  def playerOnePass(): Unit = {state.playerOnePass()}

  /** Metodo para que el jugador dos pueda pasar de turno
   */
  def playerTwoPass(): Unit = {state.playerTwoPass()}

  /** Metodo que determina si es el turno del jugador uno
   *
   * @return Devuelve true si es el turno del jugador 1 y false en el caso contrario.
   */
  def isPlayerOneTurn: Boolean = state.isPlayerOneTurn

  /** Metodo que determina si es el turno del jugador dos
   *
   * @return Devuelve true si es el turno del jugador 2 y false en el caso contrario.
   */
  def isPlayerTwoTurn: Boolean = state.isPlayerTwoTurn

  /** Metodo que determina si es el turno "infinito "del jugador uno
   *
   * @return Devuelve true si es el turno "infinito" del jugador 1 y false en el caso contrario.
   */
  def isPlayerOneInfiniteTurn: Boolean = state.isPlayerOneInfiniteTurn

  /** Metodo que determina si es el turno "infinito "del jugador dos
   *
   * @return Devuelve true si es el turno "infinito" del jugador 2 y false en el caso contrario.
   */
  def isPlayerTwoInfiniteTurn: Boolean = state.isPlayerTwoInfiniteTurn

  /** Metodo que determina si el juego ya finalizo
   *
   * @return devuelve true si el juego ya finalizo y false en el caso contrario
   */
  def isTheGameEnded: Boolean = state.isTheGameEnded

  /** Metodo que se llama cuando un player pierde la partida.
   */
  def playerLose(): Unit = {
    state.playerLose()
  }

  /** Metodo para actualizar al observador sobre el estado del observado.
   *
   * @param observed Objeto al cual se esta observando
   */
  override def update(observed: ISubject): Unit = {
    println("Player " + observed.toString + " loses. End of the game.")
    playerLose()
  }
}
