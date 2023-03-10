package librerias.estructurasDeDatos.modelos;

import librerias.excepciones.*;

public interface ListaConPIPlus<E> extends ListaConPI<E> {
    
    /** comprueba si el Elemento e esta en una Lista Con PI **/
    boolean contiene(E e);    
    
    /** elimina la primera aparicion del Elemento e en una Lista Con PI 
     *  y devuelve true, o devuelve false si e no esta en la Lista
     */
    boolean eliminarPrimero(E e) throws ElementoNoEncontrado;
    
    /** si el Elemento e esta en una Lista Con PI elimina su ultima 
     *  aparicion y la devuelve como resultado; sino lo advierte 
     *  lanzando la Excepcion ElementoNoEncontrado 
     */
    boolean eliminarUltimo(E e) throws ElementoNoEncontrado;
    
    /** si el Elemento e esta en una Lista Con PI elimina todas sus  
     *  apariciones en ella; sino lo advierte lanzando la Excepcion 
     *  ElementoNoEncontrado 
     */
    boolean eliminarTodos(E e) throws ElementoNoEncontrado;
    
    /** elimina todos los Elementos de una Lista Con PI **/
    void vaciar();
    
    /** concatena una Lista Con PI con otra **/
    void concatenar(ListaConPI<E> otra);

    /** invierte una Lista **/
    void invertir();
    
    /** coloca en PI en e, si no lo encuentra el PI se pone al final**/
    void buscar(E e);
    
    /**devuelve los elementos en forma de lista**/
    String toString();
}