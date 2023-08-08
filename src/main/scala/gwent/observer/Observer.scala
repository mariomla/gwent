package gwent.observer

/** Trait usado para el patron Observer, representa a los objetos que observan.
 */
trait Observer {
  def update(observed: ISubject): Unit
}
