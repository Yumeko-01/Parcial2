/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial.pkg2;

import parcial.pkg2.IHeap;

import java.util.ArrayList;

public class Pizzeria {

    public final static String RECIBIR_PEDIDO = "RECIBIR";
    public final static String ATENDER_PEDIDO = "ATENDER";
    public final static String DESPACHAR_PEDIDO = "DESPACHAR";

    private IHeap<Pedido> pedidosRecibidos;
    private IHeap<Pedido> colaDespachos;

    public Pizzeria() {
        pedidosRecibidos = new IHeap<>(true); // Max-Heap para los pedidos
        colaDespachos = new IHeap<>(false); // Min-Heap para despachos
    }

    public void agregarPedido(String nombreAutor, double precio, int cercania) {
        Pedido nuevoPedido = new Pedido(nombreAutor, precio, cercania);
        pedidosRecibidos.add(nuevoPedido);
    }

    public Pedido atenderPedido() {
        Pedido pedidoAtendido = pedidosRecibidos.poll();
        if (pedidoAtendido != null) {
            colaDespachos.add(pedidoAtendido);
        }
        return pedidoAtendido;
    }

    public Pedido despacharPedido() {
        return colaDespachos.poll();
    }

    public ArrayList<Pedido> pedidosRecibidosList() {
        return new ArrayList<>(pedidosRecibidos.toList());
    }

    public ArrayList<Pedido> colaDespachosList() {
        return new ArrayList<>(colaDespachos.toList());
    }
}
