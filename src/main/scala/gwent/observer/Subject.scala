package gwent.observer

import gwent.observer.{Observer, ISubject}
import scala.collection.mutable.ListBuffer

/** Clase abstracta usada para el patron observer. Represnta el objeto observado.
 * 
 * Extiende de ISubject
 */

abstract class Subject extends ISubject {
  /** La variable observers corresponde a una lista con los observadores de Subject
   */
  private val observers: ListBuffer[Observer] = ListBuffer()

  /** Metodo para agregar observadores al observado
   *
   * @param observer observador nuevo que se agregara
   */
  override def registerObserver(observer: Observer): Unit = {
    observers += observer
  }

  /** Metodo para notificar a los observadores.
   *
   * @param response respuesta que se desaa notificar
   */
  override def notifyObserver(response: Any): Unit = {
    for (observer <- observers) {
      observer.update(this)
    }
  }
}
