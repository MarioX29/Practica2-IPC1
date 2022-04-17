package com.mascotavirtual.memoria;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author MarioX27
 */
public class Celda extends JLabel {

    //Imagen para la parte trasera de las cartas
    protected ImageIcon cartaAtras = new ImageIcon(getClass().getResource("/Icono/CartaPKM.jpg"));
    //Imagen para las parejas
    protected ImageIcon iPokemon;
    //Constructos con parametro del JLabel
    protected String nombrePokemon="";
    //
  
    protected boolean bloquear= false;
    public Celda(String Nombre) {
        super();
        setName(Nombre);
        setText("");
        //Set de la imagen de atras
        setIcon(cartaAtras);
        setVisible(true); 
    }
    //Settear la imagen para la casilla y asignarle el nombre del pokemon
       public void setnombrePokemon(String pokemon) {
        this.nombrePokemon=pokemon;
     
                if (!pokemon.equals("")) {
                 iPokemon= new ImageIcon(getClass().getResource("/com/"+pokemon+".jpg"));
                 } else {
                 //
                 }
        }
             //Getter 
            public String getnombrePokemon(){
            return nombrePokemon;
            }                
        //
            public void MostrarCartas(){
            setIcon(iPokemon);
             }
          
        //bloquear carta si las dos son iguales
        public void bloquearCarta(boolean bloqueo){
        this.bloquear=bloqueo;
        }

       //Verifica si una carta a sido bloqueada
        public boolean cartaBloqueada(){
        return this.bloquear;     
       }
        
        public void ocultarCarta(){
            if (!bloquear) {
                setIcon(cartaAtras);
            }
        }
             
    } 
    
