package gwent.states

/** Clase que representa al estado de la partida en el cual es el turno del jugador 1.
 *
 * Extiende de State
 */

class PlayerOneTurn extends State {

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador uno juega una carta
   */
  override def playerOnePlayCard(): Unit = this.changeState(new PlayerTwoTurn)

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador uno pasa de turno.
   */
  override def playerOnePass(): Unit = this.changeState(new PlayerTwoInfiniteTurn)

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador uno pierde la partida
   */
  override def playerLose(): Unit = {this.changeState(new GameEnded)}

  /** Metodo que determina si es el turno del jugador uno
   *
   * @return Devuelve true si es el turno del jugador 1 y false en el caso contrario.
   */
  override def isPlayerOneTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerOneTurn => true
    case _ => false
  }

  override def toString: String = "State(PlayerOneTurn)"
}
