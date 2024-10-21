/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial.pkg2;

public class Pedido implements Comparable<Pedido> {

    private double precio;
    private String autorPedido;
    private int cercania;

    public Pedido(String autorPedido, double precio, int cercania) {
        this.autorPedido = autorPedido;
        this.precio = precio;
        this.cercania = cercania;
    }

    public double getPrecio() {
        return precio;
    }

    public String getAutorPedido() {
        return autorPedido;
    }

    public int getCercania() {
        return cercania;
    }

    @Override
    public int compareTo(Pedido otro) {
        return Double.compare(this.precio, otro.precio); // Para el max-heap
    }

    @Override
    public String toString() {
        return autorPedido + " ($" + precio + ", " + cercania + " mts)";
    }
}
