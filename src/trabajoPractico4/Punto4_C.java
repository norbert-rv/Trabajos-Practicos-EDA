/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoPractico4;

/**
 *
 * @author Norberto
 */
public class Punto4_C {
    public static void main(String args[]) {
        Usuario u1 = new Usuario("Norberto", "Rodriguez");
        Usuario u2 = new Usuario("Manuela", "Rodriguez");
        Usuario u3 = new Usuario("Laurita", "Del Castillo");
        Usuario u4 = new Usuario("Tomas", "Cabrera");
        
        RedSocial red1 = RedSocial.crear();
        RedSocial red2 = RedSocial.crear();
        
        red1.registrar(u1);
        red1.registrar(u2);
        red2.registrar(u3);
        red2.registrar(u4);
        
        System.out.println("Es vacia red1: " + red1.esVacia());
        
        System.out.println("Esta el usuario Norberto en red1?: " + red1.esta(u1));
        System.out.println("Esta el usuario Norberto en red2?: " + red2.esta(u1));
        
        RedSocial redUnion = union(red1, red2);
        System.out.println("Cantidad de usuarios en redUnion: " + redUnion.cantidad());
        
        System.out.println(redUnion.ultimoUsuario().getNombre());
        System.out.println(redUnion.echar(u4).ultimoUsuario().getNombre());
        System.out.println(redUnion.echar(u2).ultimoUsuario().getNombre());
        System.out.println(redUnion.echar(u3).ultimoUsuario().getNombre());
        
        System.out.println("Es vacia red1: " + red1.esVacia()); // se vacia despues de llamar a union
        
        System.out.println("Cantidad de usuarios en redUnion: " + redUnion.cantidad());
        System.out.println("Cantidad de usuarios en red1: " + red1.cantidad());
        
    }
    
    private static RedSocial union(RedSocial red1, RedSocial red2) {
        RedSocial redFinal = RedSocial.crear();
        Usuario usuario;

        /* 
            Con ultimoUsuario() accedo al ultimo elemento.
            Tengo que ver como hago para armar la nueva red social sin modificar las
            redes existentes que ingresan como parametros. Tendria que implementar un
            nuevo metodo para copiar una red social y trabajar con la copia.
            Queda bastante desordenado. La primera red se copia invertida y de ahi
            la segunda red se copia invertida.
        */
        
        if (red1 != null && !red1.esVacia()) {        // control de entrada
            do {
                usuario = red1.ultimoUsuario();
                redFinal.registrar(usuario);
                red1.echar(usuario);
            } while (red1.ultimoUsuario() != null);
        }
        
        if (red2 != null && !red2.esVacia()) {
            do {
                usuario = red2.ultimoUsuario();
                redFinal.registrar(usuario);
                red2.echar(usuario);
            } while (red2.ultimoUsuario() != null);    
        }        
        // si las entradas son null devuelve una red social vacia    
        return redFinal;
    }
}
