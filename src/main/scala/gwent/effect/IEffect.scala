package gwent.effect

import gwent.board.{Board, Zone}
import gwent.cards.ICard

/** Trait para definir a los efectos y establecer sus metodos y comportamiento       
 */

trait IEffect {

  /** Metodo que define la accion del efecto sobre una carta de combate cuerpo a cuerpo
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card carta a la cual se le aplicara el efecto
   * @param board tablero donde se aplica el efecto
   */
  def applyEffectMelee(section: Int, card: ICard, board: Board): Unit

  /** Metodo que define la accion del efecto sobre una carta de combate a distancia
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card carta a la cual se le aplicara el efecto
   * @param board tablero donde se aplica el efecto
   */
  def applyEffectRanged(section: Int, card: ICard, board: Board): Unit

  /** Metodo que define la accion del efecto sobre una carta de asedio
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  def applyEffectSiege(section: Int, card: ICard, board: Board): Unit

  /** Metodo que define la accion del efecto sobre una carta de clima
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  def applyEffectWeather(section: Int, card: ICard, board: Board): Unit
}
