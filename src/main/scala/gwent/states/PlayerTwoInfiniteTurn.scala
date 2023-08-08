package gwent.states

/** Clase que representa al estado de la partida en el cual es el turno "infinito" del jugador 2. En este turno el 
 * jugador 2 puede jugar las cartas que quiera hasta que decida pasar.
 *
 * Extiende de State
 */

class PlayerTwoInfiniteTurn extends State {

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador dos pasa de turno.
   */
  override def playerTwoPass(): Unit = {
    this.changeState(new PlayerOneTurn)
    gameController.endRound()
  }

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador dos pasa de turno.
   */
  override def playerTwoPlayCard(): Unit = {}

  /** Metodo que determina si es el turno "infinito "del jugador dos
   *
   * @return Devuelve true si es el turno "infinito" del jugador 2 y false en el caso contrario.
   */
  override def isPlayerTwoInfiniteTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerTwoInfiniteTurn => true
    case _ => false
  }
  

  override def toString: String = "State(PlayerTwoInfiniteTurn)"
}
