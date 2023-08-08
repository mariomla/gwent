package gwent.board

import gwent.effect.IEffect

/** Trait que representa a Component, es usado para establecer el patron Composite          
 */
trait Component {
  def applyEffect(board: Board, section: Int, effect: IEffect): Unit
}
