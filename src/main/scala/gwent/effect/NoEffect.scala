package gwent.effect
import gwent.cards.ICard
import gwent.board.{Board, Zone}

/** Clase que representa al efecto vacio, es decir, un efecto que no hace nada.
 *
 * Extiende de IEffect
 */

class NoEffect extends IEffect {

  /** Metodo que define la accion que tendra el efecto sobre una carta de combate cuerpo a cuerpo
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {}

  /** Metodo que define la accion que tendra el efecto sobre una carta de combate a distancia
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectRanged(section: Int, card: ICard, board: Board): Unit = {}

  /** Metodo que define la accion que tendra el efecto sobre una carta de asedio
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {}

  /** Metodo que define la accion que tendra el efecto sobre una carta de clima
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {}

  override def equals(other: Any): Boolean = other match {
    case that: NoEffect => true
    case _ => false
  }

  override def toString: String = "Effect(No Effect)"
}
