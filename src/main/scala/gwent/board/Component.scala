package gwent.board

import gwent.effect.IEffect

/** Trait que representa a Component, es usado para establecer el patron Composite          
 */
trait Component {

  /** Metodo para aplicar un efecto sobre las cartas.
   * 
   * @param board tablero donde se aplica el efecto
   * @param section seccion del jugador que aplica el efecto
   * @param effect efecto que se aplica
   */
  def applyEffect(board: Board, section: Int, effect: IEffect): Unit
}
