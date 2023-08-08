package gwent.observer

/** Trait usado para el patron observer.
 */

trait ISubject {

  /** Metodo para agregar observadores al observado
   * 
   * @param observer observador nuevo que se agregara
   */
  def registerObserver(observer: Observer): Unit

  /** Metodo para notificar a los observadores.
   * 
   * @param response respuesta que se desaa notificar
   */
  def notifyObserver(response: Any): Unit
}
