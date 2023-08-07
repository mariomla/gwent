package gwent.effect

import gwent.board.{Zone, Board}
import gwent.cards.ICard

class RefuerzoMoral(cardName: String, cardsEffectApplied: Int) extends IEffect {
  // Se supondra que no existen dos cartas de distinto tipo con el mismo nombre
  def this(cardName: String) = this(cardName, 0)

  private def isCardNameInZone(zone: Zone): Boolean = {
    var ret: Boolean = false
    for (card <- zone.cards) {
      ret = ret || (cardName == card.getName)
    }
    ret
  }

  private def isTheLastCard(card: ICard, zone: Zone): Boolean = { // si tiene el mismo nombre que la carta que aplico el efecto y se ha aplicado el efecto a todas menos a una entonces es la ultima carta
    val cardsInZone = zone.cards.length
    if ((card.getName == cardName) && (cardsEffectApplied == cardsInZone - 1)) {true}
    else {false}
  }

  private def refuerzoMoralEffect(zone: Zone, card: ICard): Unit = {
    if (this.isCardNameInZone(zone) && !(this.isTheLastCard(card, zone))) { // si esta la cardName en la zona entonces es la zona donde hay q aplicar el efecto, y si es la ultimo rntonces no hya que aplicar el efectp
      card.setStrength(card.getStrength + 1)
    }
  }

  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1) {zone = board.meleeZonePlayerOne}
    else {zone = board.meleeZonePlayerTwo}
    refuerzoMoralEffect(zone, card)
  }

  override def applyEffectRanged(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1) {zone = board.meleeZonePlayerOne}
    else {zone = board.meleeZonePlayerTwo}
    refuerzoMoralEffect(zone, card)
  }

  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1) {zone = board.meleeZonePlayerOne}
    else {zone = board.meleeZonePlayerTwo}
    refuerzoMoralEffect(zone, card)
  }

  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {}


}
