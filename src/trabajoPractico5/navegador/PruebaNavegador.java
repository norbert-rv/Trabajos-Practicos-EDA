/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoPractico5.navegador;

/**
 *
 * @author Norberto
 */
public class PruebaNavegador {
    public static void main(String args[]) {
        Navegador nav = Navegador.iniciarNavegador();
        
        System.out.println(nav.adelante());        // debe mostrar 0
        System.out.println(nav.atras());           // debe mostrar 0
        
        nav.navegar(1);
        nav.navegar(2);
        nav.navegar(3);
        nav.navegar(4);
        
        System.out.println(nav.adelante());     // debe mostrar 4
        nav.atras();
        System.out.println(nav.atras());        // debe mostrar 2
        System.out.println(nav.adelante());     // debe mostrar 3
        
        nav.navegar(567);
        
        System.out.println(nav.adelante());     // debe mostrar 567
        
        System.out.println(nav.atras());        // debe mostrar 3
    }
}
