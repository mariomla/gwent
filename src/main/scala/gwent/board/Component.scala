package gwent.board

import gwent.effect.IEffect

trait Component {
  def applyEffect(board: Board, section: Int, effect: IEffect): Unit
}
