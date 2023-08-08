package gwent.states

/** Clase que representa al estado de una partida terminada.
 *
 * Extiende de State
 */

class GameEnded extends State {

  /** Metodo que determina si el juego ya finalizo
   *
   * @return devuelve true si el juego ya finalizo y false en el caso contrario
   */
  override def isTheGameEnded: Boolean = true
}
