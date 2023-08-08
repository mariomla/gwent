package gwent.states

/** Clase que se usara para representar los estados de una partida, es la clase padre de los posibles estados.
 */

class State {
  /** La variable gameController representa el controlador del juego que manejara el flujo de la partida.
   */
  protected var gameController: GameController = null

  /** Metodo para establecer el controlador de la partida
   * 
   * @param aGameController controlador de la partida
   */
  def setGameController(aGameController: GameController): Unit = {
    this.gameController = aGameController
  }

  /** Metodo para cambiar el estado de la partida
   * 
   * @param state metodo al cual se desea cambiar
   */
  protected def changeState(state: State): Unit = {
    if (gameController != null) {
      gameController.setState(state)
    }
  }

  /** Error para cuando se desea realizar una transicion de estado invalida
   * 
   * @return un assertion error con el mensaje correspondiente
   */
  private def error() = throw new AssertionError("Wrong State")

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador uno juega una carta
   */
  def playerOnePlayCard(): Unit = error()

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador dos juega una carta
   */
  def playerTwoPlayCard(): Unit = error()

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador uno pasa de turno.
   */
  def playerOnePass(): Unit = error()

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador dos pasa de turno.
   */
  def playerTwoPass(): Unit = error()

  /** Metodo que realiza la transicion de estado correspondiente cuando un jugador pierde la partida
   */
  def playerLose(): Unit = error()

  /** Metodo que determina si es el turno del jugador uno
   *
   * @return Devuelve true si es el turno del jugador 1 y false en el caso contrario.
   */
  def isPlayerOneTurn: Boolean = false

  /** Metodo que determina si es el turno del jugador dos
   *
   * @return Devuelve true si es el turno del jugador 2 y false en el caso contrario.
   */
  def isPlayerTwoTurn: Boolean = false

  /** Metodo que determina si es el turno "infinito "del jugador uno
   *
   * @return Devuelve true si es el turno "infinito" del jugador 1 y false en el caso contrario.
   */
  def isPlayerOneInfiniteTurn: Boolean = false

  /** Metodo que determina si es el turno "infinito "del jugador dos
   *
   * @return Devuelve true si es el turno "infinito" del jugador 2 y false en el caso contrario.
   */
  def isPlayerTwoInfiniteTurn: Boolean = false
  
  /** Metodo que determina si el juego ya finalizo
   *
   * @return devuelve true si el juego ya finalizo y false en el caso contrario
   */
  def isTheGameEnded: Boolean = false
}

