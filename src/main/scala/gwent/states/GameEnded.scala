package gwent.states

/** Clase que representa al estado de una partida terminada.
 *
 * Extiende de State
 */

class GameEnded extends State {
  override def isTheGameEnded: Boolean = true
}
