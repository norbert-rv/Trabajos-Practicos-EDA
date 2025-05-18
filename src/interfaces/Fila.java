package interfaces;

/**
 * Interface for ADT Fila
 * @author Norberto
 * @param <Item>
 */
public interface Fila<Item> {
    public boolean esFilaVacia();
    public Item frente();
    public Fila enFila(Item item);
    public Fila deFila();
    public Fila enFilaN(Item item, int cantidad);
    public Fila reenfilar();
    public Fila borrar(Item item);
    public int cantidad();
}
