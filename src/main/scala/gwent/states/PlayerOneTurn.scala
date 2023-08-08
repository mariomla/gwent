package gwent.states

/** Clase que representa al estado de la partida en el cual es el turno del jugador 1.
 *
 * Extiende de State
 */

class PlayerOneTurn extends State {
  override def playerOnePlayCard(): Unit = this.changeState(new PlayerTwoTurn)

  override def playerOnePass(): Unit = this.changeState(new PlayerTwoInfiniteTurn)

  override def playerLose(): Unit = {this.changeState(new GameEnded)}

  override def isPlayerOneTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerOneTurn => true
    case _ => false
  }

  override def toString: String = "State(PlayerOneTurn)"
}
