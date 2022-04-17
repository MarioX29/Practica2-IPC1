/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotavirtual;

import com.mascotavirtual.backend.Pokemon;

/**
 *
 * @author MarioX27
 */
public class Jugador {
    private String nombre;
    private Pokemon[] pokemons;
    private int oro;

    public Jugador(String nombre, Pokemon[] pokemons, int oro) {
        this.nombre = nombre;
        this.pokemons = pokemons;
        this.oro = oro;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public int getOro() {
        return oro;
    }
    
    public void oroinvertido(int cantidad) {
		oro += cantidad;
	}

}
