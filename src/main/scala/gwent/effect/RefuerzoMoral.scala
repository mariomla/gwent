package gwent.effect

import gwent.board.{Zone, Board}
import gwent.cards.ICard

/** Clase que representa al efecto de Refuerzo Moral
 *
 * Esta definida por el nombre de la carta que tiene este efecto y por las veces que se aplicado este efecto sobre
 * una zona
 * 
 * @param cardName Nombre de la carta que posee este efecto
 * @param cardsEffectApplied Numero de veces que se ha aplicado este efecto sobre una zona. Inicialmente solo es 0.
 *                           Es usado para la aplicacion del efecto.
 *                           
 * @constructor Crea un efecto de Refuerzo Moral con el cardName especificado, cardEffectApplied parte siempre en 0
 *              por defecto.
 * 
 * Extiende de IEffect
 */

class RefuerzoMoral(cardName: String, var cardsEffectApplied: Int) extends IEffect {
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
    this.cardsEffectApplied = this.cardsEffectApplied + 1
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
