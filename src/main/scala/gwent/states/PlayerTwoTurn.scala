package gwent.states

/** Clase que representa al estado de la partida en el cual es el turno del jugador 2.
 *
 * Extiende de State
 */

class PlayerTwoTurn extends State {

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador dos juega una carta
   */
  override def playerTwoPlayCard(): Unit = this.changeState(new PlayerOneTurn)

  /** Metodo que realiza la transicion de estado correspondiente cuando el jugador dos pasa de turno.
   */
  override def playerTwoPass(): Unit = this.changeState(new PlayerOneInfiniteTurn)

  /** Metodo que determina si es el turno del jugador dos
   *
   * @return Devuelve true si es el turno del jugador 2 y false en el caso contrario.
   */
  override def isPlayerTwoTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerTwoTurn => true
    case _ => false
  }

  override def toString: String = "State(PlayerTwoTurn)"
}
