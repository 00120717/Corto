/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Filtro {
    private int id;
    private String nombre;
    private String codigo;
    private int precio;
    private int cantidad;
    private boolean disponibilidad;
    private String tipo;
    
    public Filtro(){}

    public Filtro(int id, String nombre, String codigo, int precio, int cantidad, boolean disponibilidad, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
    }

    public Filtro(String nombre, String codigo, int precio, int cantidad, boolean disponibilidad, String tipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
    }

    public Filtro(String codigo, int precio, int cantidad, boolean disponibilidad, String tipo) {
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
    }

    public Filtro(int precio, int cantidad, boolean disponibilidad,String tipo) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
    }

    public Filtro(int cantidad, boolean disponibilidad, String tipo) {
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
    }

    public Filtro(boolean disponibilidad, String tipo) {
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
