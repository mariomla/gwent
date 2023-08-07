package gwent.board

import gwent.cards.ICard
import gwent.effect.IEffect
import jdk.internal.jmod.JmodFile.Section

// Solo puede haber un Board

class Board(private[gwent] var meleeZonePlayerOne: Zone, private[gwent] var rangedZonePlayerOne: Zone,
            private[gwent] var siegeZonePlayerOne: Zone, private[gwent] var meleeZonePlayerTwo: Zone,
            private[gwent] var rangedZonePlayerTwo: Zone, private[gwent] var siegeZonePlayerTwo: Zone,
            private[gwent] var weatherZone: Zone){
  def this() = this(new Zone(), new Zone(), new Zone(), new Zone(), new Zone(), new Zone(), new Zone())

  def getMeleeZonePlayerOne: Zone = this.meleeZonePlayerOne

  def getRangedZonePlayerOne: Zone = this.rangedZonePlayerOne

  def getSiegeZonePlayerOne: Zone = this.siegeZonePlayerOne

  def getMeleeZonePlayerTwo: Zone = this.meleeZonePlayerTwo

  def getRangedZonePlayerTwo: Zone = this.rangedZonePlayerTwo

  def getSiegeZonePlayerTwo: Zone = this.siegeZonePlayerTwo

  def getWeatherZone: Zone = this.weatherZone

  def setWeatherZone(card: ICard): Unit = {
    this.weatherZone.cards = Array(card)
  }
  
  //def applyEffect(effect: IEffect): Unit = {}

  //removeWeatherCard
  
  /*
  def setStrengthZone(zone: List[ICard], strength: Int): Unit = {
    zone.head match {
      case z: UnitCard => {
                           val restoZone: List[ICard] = zone.tail
                           zone.head.asInstanceOf[UnitCard].setStrength(strength)
                           this.setStrengthZone(restoZone, strength)}

      case _ =>
    }
  
  }


  def refuerzoMoral(): Unit = {
  }

  def vinculoEstrecho() : Unit = {}

  def escarchaMordiente(section: Int): Unit = {
    section match {
      case 1 => setStrengthZone(meleeZonePlayerOne, 1)
      case 2 => setStrengthZone(meleeZonePlayerTwo, 1)
      case _ => println("Seccion no valida")
    }
  }

  def nieblaImpenetrable(section: Int): Unit = {
    section match {
      case 1 => setStrengthZone(rangedZonePlayerOne, 1)
      case 2 => setStrengthZone(rangedZonePlayerTwo, 1)
      case _ => println("Seccion no valida")
    }
  }

  def lluviaTorrencial(section: Int): Unit = {
    section match {
      case 1 => setStrengthZone(siegeZonePlayerOne, 1)
      case 2 => setStrengthZone(siegeZonePlayerTwo, 1)
      case _ => println("Seccion no valida")
    }
  }

  def climaDespejado(): Unit = {setWeatherZone(null)}
  */

  //setters?
}
