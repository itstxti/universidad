/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaEatF;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author tgarc
 */
public class Venta implements Serializable {
     
    private Particular particular;
    private Restaurante restaurante;
    private ArrayList<Comida> listaComidaComprada;
    private ArrayList<Integer> listaCantidadCadaComidaComprada;
    private LocalDate fechaCompra;
    private Cliente cliente;

    public Venta(Cliente cliente, Restaurante restaurante, ArrayList<Comida> listaComidaComprada, ArrayList<Integer> listaCantidadCadaComidaComprada, LocalDate fechaCompra) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.listaComidaComprada = listaComidaComprada;
        this.listaCantidadCadaComidaComprada = listaCantidadCadaComidaComprada;
        this.fechaCompra = fechaCompra;
    }   

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public ArrayList<Comida> getListaComidaComprada() {
        return listaComidaComprada;
    }

    public void setListaComidaComprada(ArrayList<Comida> listaComidaComprada) {
        this.listaComidaComprada = listaComidaComprada;
    }

    public ArrayList<Integer> getListaCantidadCadaComidaComprada() {
        return listaCantidadCadaComidaComprada;
    }

    public void setListaCantidadCadaComidaComprada(ArrayList<Integer> listaCantidadCadaComidaComprada) {
        this.listaCantidadCadaComidaComprada = listaCantidadCadaComidaComprada;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta{" + "cliente=" + cliente.getNombre() + ", restaurante=" + restaurante.getNombre() + ", listaComidaComprada=" + listaComidaComprada + ", listaCantidadCadaComidaComprada=" + listaCantidadCadaComidaComprada + ", fechaCompra=" + fechaCompra + '}';
    }
    
}
