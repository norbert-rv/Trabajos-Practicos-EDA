/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import trabajoPractico4.RedSocial;
import trabajoPractico4.Usuario;

/**
 *
 * @author Norberto
 */
public interface IRedSocial {
    public RedSocial registrar(Usuario usuario);
    public boolean esVacia();
    public boolean esta(Usuario usuario);
    public RedSocial echar(Usuario usuario);
    public Usuario ultimoUsuario();    // retorna NULL si esta vacia
    public int cantidad();
}
