/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotavirtual.backend.tienda;

import javax.swing.ImageIcon;

/**
 *
 * @author MarioX27
 */
public class Comida {
    private String nombre;
    private ImageIcon icono;
    private int precio;
    //Efecto de la comida en las peticiones de la mascota
    private int solicitud;

    public Comida(String nombre, ImageIcon icono, int precio, int solicitud) {
        this.nombre = nombre;
        this.icono = icono;
        this.precio = precio;
        this.solicitud = solicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public int getPrecio() {
        return precio;
    }

    public int getSolicitud() {
        return solicitud;
    }
    
//    	public int comparar(Comida other) {
//		return this.nombre.compareTo(other.nombre);
//    
//        }
//    
    
    
}
