package gwent.states

/** Clase que representa al estado de la partida en el cual es el turno "infinito" del jugador 1. En este turno el 
 * jugador 1 puede jugar las cartas que quiera hasta que decida pasar.
 *
 * Extiende de State
 */

class PlayerOneInfiniteTurn extends State{

  override def playerOnePass(): Unit = {
    this.changeState(new PlayerOneTurn)
    gameController.endRound()
  }

  override def playerOnePlayCard(): Unit = {}
  

  override def isPlayerOneInfiniteTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerOneInfiniteTurn => true
    case _ => false
  }

  override def toString: String = "State(PlayerOneInfiniteTurn)"
}
