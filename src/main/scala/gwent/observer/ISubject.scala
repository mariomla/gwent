package gwent.observer

/** Trait usado para el patron observer.
 */

trait ISubject {
  def registerObserver(observer: Observer): Unit

  def notifyObserver(response: Any): Unit
}
