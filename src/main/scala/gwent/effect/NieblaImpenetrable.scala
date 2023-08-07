package gwent.effect
import gwent.board.{Board, Zone}
import gwent.cards.ICard

class NieblaImpenetrable extends IEffect {
  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectRanged(section: Int, card: ICard, board: Board): Unit = {
    card.setStrength(1)
  }

  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {}

  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {}

  override def equals(other: Any): Boolean = other match {
    case that: NieblaImpenetrable => true
    case _ => false
  }

  override def toString: String = "Effect(NieblaImpenetrable)"
}
