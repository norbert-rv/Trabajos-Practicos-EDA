package trabajoPractico3;

/**
 *
 * @author norberto
 */
public class Tarea {
    private int tiempo;
    private float precio;
    
    private Tarea(int tiempo, float precio) {
        this.tiempo = tiempo;
        this.precio = precio;
    }
    
    public Tarea crearTarea(int tiempo, float precio) {
        return new Tarea(tiempo, precio);
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
