package gwent

import jdk.internal.jmod.JmodFile.Section

// Solo puede haber un Board

class Board(private[gwent] var meleeZonePlayerOne: List[ICard], private[gwent] var rangedZonePlayerOne: List[ICard],
            private[gwent] var siegeZonePlayerOne: List[ICard], private[gwent] var meleeZonePlayerTwo: List[ICard],
            private[gwent] var rangedZonePlayerTwo: List[ICard], private[gwent] var siegeZonePlayerTwo: List[ICard],
            private[gwent] var weatherZone: ICard){
  def this() = this(Nil, Nil, Nil, Nil, Nil, Nil, null) // Se crea un tablero totalmente vacio

  def getMeleeZonePlayerOne: List[ICard] = this.meleeZonePlayerOne

  def getRangedZonePlayerOne: List[ICard] = this.rangedZonePlayerOne

  def getSiegeZonePlayerOne: List[ICard] = this.siegeZonePlayerOne

  def getMeleeZonePlayerTwo: List[ICard] = this.meleeZonePlayerTwo

  def getRangedZonePlayerTwo: List[ICard] = this.rangedZonePlayerTwo

  def getSiegeZonePlayerTwo: List[ICard] = this.siegeZonePlayerTwo

  def getWeatherZone: ICard = this.weatherZone

  def setWeatherZone(card: ICard): Unit = {
    this.weatherZone = card
  }

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

  //setters?
}
