/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import trabajoPractico5.Pila;

/**
 *
 * @author Norberto
 * @param <Item>
 */
public interface IPila<Item> {
    public Pila<Item> push(Item i);
    public Pila<Item> pop();
    public Item top();
    public Item fondo();
}
