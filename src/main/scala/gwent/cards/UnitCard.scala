package gwent.cards

import gwent.cards.AbstractCard
import gwent.effect.IEffect

/** Clase Abstracta para definir las cartas de unidad
 *
 * Las cartas de unidad estan definidas por su nombre (name), su efecto (effect) y su fuerza (strength)
 *
 * @param name El nombre de la carta
 * @param effect El efecto de la carta
 * @param strength La fuerza de la carta
 *             
 * Extiende de AbtractCard             
 */
abstract class UnitCard(private val name: String, private val effect: IEffect, private var strength: Int)
  extends AbstractCard(name, effect) {
  
  def getStrength: Int = this.strength

  def setStrength(newStrength: Int): Unit = {
    this.strength = newStrength
  }
}

