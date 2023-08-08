package gwent.effect
import gwent.board.{Zone, Board}
import gwent.cards.ICard

/** Clase que representa al efecto de Lluvia Torrencial
 *
 * Extiende de IEffect
 */

class LluviaTorrencial extends IEffect {

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
  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {
    card.setStrength(1)
  }

  /** Metodo que define la accion que tendra el efecto sobre una carta de clima
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {}

  override def equals(other: Any): Boolean = other match {
    case that: LluviaTorrencial => true
    case _ => false
  }

  override def toString: String = "Effect(LluviaTorrencial)"

}
