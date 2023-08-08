package gwent.effect
import gwent.board.{Board, Zone}
import gwent.cards.ICard

/** Clase que representa al efecto de Cielo Despejado
 *
 * Extiende de IEffect
 */
class CieloDespejado extends IEffect {

  /** Metodo que define la accion que tendra el efecto sobre una carta de combate cuerpo a cuerpo
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {}

  /** Metodo que define la accion que tendra el efecto sobre una carta combate a distancia
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
  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {
    board.weatherZone.setZone(new Array[ICard](0))
  }

  override def equals(other: Any): Boolean = other match {
    case that: CieloDespejado => true
    case _ => false
  }

  override def toString: String = "Effect(CieloDespejado)"
}
