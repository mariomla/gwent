package gwent.effect
import gwent.cards.ICard
import gwent.board.{Board, Zone}

class NoEffect extends IEffect {

  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectRanged(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {}

  override def equals(other: Any): Boolean = other match {
    case that: NoEffect => true
    case _ => false
  }

  override def toString: String = "Effect(No Effect)"
}
