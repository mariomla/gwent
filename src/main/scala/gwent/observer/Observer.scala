package gwent.observer

/** Trait usado para el patron Observer, representa a los objetos que observan.
 */
trait Observer {

  /** Metodo para actualizar al observador sobre el estado del observado.
   *
   * @param observed Objeto al cual se esta observando
   */
  def update(observed: ISubject): Unit
}
