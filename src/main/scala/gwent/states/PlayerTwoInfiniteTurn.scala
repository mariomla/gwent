package gwent.states

/** Clase que representa al estado de la partida en el cual es el turno "infinito" del jugador 2. En este turno el 
 * jugador 2 puede jugar las cartas que quiera hasta que decida pasar.
 *
 * Extiende de State
 */

class PlayerTwoInfiniteTurn extends State {

  override def playerTwoPass(): Unit = {
    this.changeState(new PlayerOneTurn)
    gameController.endRound()
  }

  override def playerTwoPlayCard(): Unit = {}
  

  override def isPlayerTwoInfiniteTurn: Boolean = true

  override def equals(other: Any): Boolean = other match {
    case that: PlayerTwoInfiniteTurn => true
    case _ => false
  }
  

  override def toString: String = "State(PlayerTwoInfiniteTurn)"
}
