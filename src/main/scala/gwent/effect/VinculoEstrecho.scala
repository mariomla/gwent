package gwent.effect
import gwent.board.{Board, Zone}
import gwent.cards.ICard
import gwent.player.AbstractPlayer

/** Clase que representa al efecto de Vinculo Estrecho
 *
 * Esta definida por el nombre de la carta que tiene este efecto.
 *
 * @param cardName Nombre de la carta que posee este efecto
 *
 * @constructor Crea un efecto de Vinculo Estrecho con el cardName especificado.
 *
 * Extiende de IEffect
 */

class VinculoEstrecho(val cardName: String) extends IEffect {

  def timesThisCardInZone(zone: Zone): Int = {
    var ret: Int = 0
    for (card <- zone.cards){
      if (card.getName == cardName){
        ret += 1
      }
    }
    ret
  }
   

  def vinculoEstrechoEffect(zone: Zone, card: ICard): Unit = {
    val cond: Boolean = timesThisCardInZone(zone) > 1 // Si es mayor que 1, entonces esta carta esta mas de una vez en la fila
    if (cardName == card.getName && cond) {
      card.setStrength(card.getStrength * 2)
    }
  }

  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1){zone = board.meleeZonePlayerOne}
    else {zone = board.meleeZonePlayerTwo}
    vinculoEstrechoEffect(zone, card)
  }

  override def applyEffectRanged(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1) {zone = board.rangedZonePlayerOne}
    else {zone = board.rangedZonePlayerTwo}
    vinculoEstrechoEffect(zone, card)
  }

  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1) {zone = board.siegeZonePlayerOne}
    else {zone = board.siegeZonePlayerTwo}
    vinculoEstrechoEffect(zone, card)
  }

  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {}

  private def canEqual(other: Any): Boolean = other.isInstanceOf[VinculoEstrecho]

  override def equals(other: Any): Boolean = other match
    case that: VinculoEstrecho =>
      that.canEqual(this) &&
        cardName == that.cardName
    case _ => false

  override def hashCode(): Int =
    val state = Seq(cardName)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)


  override def toString = s"VinculoEstrecho($cardName)"
}
