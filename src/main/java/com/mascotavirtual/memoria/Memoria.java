
package com.mascotavirtual.memoria;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author MarioX27
 */
public class Memoria extends JPanel{
  
  
     private String[] nPokemon={"Abra","Aerodactyl","Alakazam","Arbok","Arcanine","Articuno","Beedrill","Bellsprout"};
    protected int nivel=0;
    private int columna=4;
    private int fila=4;
    private int espacios= columna*fila;
    private boolean jugar = false;
    private int parejas=0;
    protected int noParejas=0;
    private int contadorClick=0;
    //variables para el 
    private int pmios=0;
    private int pcontra=0;
    Celda carta1;
    Celda carta2;

    public Memoria() {
        //dimensiones para las casillas en el Jpanel (Ancho,Alto)
     setLayout( new java.awt.GridLayout(fila, columna) );        
        Dimension tamanio= new Dimension( (152*columna),(140*fila)  );        
        setSize(tamanio);
        setPreferredSize(tamanio);
        
       //para formar los espacios de las parejas
       //se multiplican filas*columnas
         int j=0;      
        for (int i = 1; i <=(espacios); i++) {
            Celda celda = new Celda(String.valueOf(i));
              celda.setnombrePokemon(nPokemon[j]);
              j++;

              j=(j>=nPokemon.length) ?  0:j++;
              celda.MostrarCartas();
         celda.addMouseListener(new controlClicks());
              this.add(celda);   
        }
    setVisible(true);
    
   
    }
    
    

     public void inicio(){
       parejas=0;
        jugar =true;
        Component[] componentes = this.getComponents();         
        //limpia banderas
        for( int i=0; i< componentes.length ;i++){
            ((Celda)componentes[i]).bloquearCarta(false);
            ((Celda)componentes[i]).ocultarCarta();
            ((Celda)componentes[i]).setnombrePokemon("");
        }
        //coloca nuevo orden aleatorio de banderas
        for( int i=0; i< componentes.length ;i++){
            int j = (int) (Math.random()*(nPokemon.length));        
            if( !verificarCarta(nPokemon[j]) ){//comprueba que bandera no este asignada mas de 2 veces                
                ((Celda)componentes[i]).setnombrePokemon(nPokemon[j] );
            }else{
                i--;
            }
        }
        
    }
     public int puntajeMio(){
     return pmios;
     }
     public int puntajeContra()
     {
     return pcontra;
     }
    
    
    private boolean verificarCarta( String pokemon){  
        int count=0;
        Component[] componentes = this.getComponents(); 
        for( int i=0; i<componentes.length;i++ ) {
            if( componentes[i] instanceof Celda ) {
                if( ((Celda)componentes[i]).getnombrePokemon().equals( pokemon ) ) {
                    count++;
                }
            }
        }        
        return (count==2)? true:false;   
    }
    
    
    class controlClicks implements MouseListener{        
      
        @Override
        public void mouseClicked(MouseEvent e) {         
            
            if( jugar){
                contadorClick++;
                if( contadorClick==1 ){ 
                    carta1=((Celda) e.getSource());
                    if( !carta1.cartaBloqueada()){
                        carta1.MostrarCartas();
                       System.out.println("carta1: " + carta1.getnombrePokemon() ); 
                    }else{
                      contadorClick=0;   
                    }                
                }else if( contadorClick==2 && !carta1.getName().equals( ((Celda) e.getSource()).getName()) ){
                    carta2=((Celda) e.getSource()); 
                    if( !carta2.cartaBloqueada() ){
                        carta2.MostrarCartas();
                       System.out.println("carta2: " + carta2.getnombrePokemon() );    
                        //
                        //Realizar la comparacion de cada carta
                        voltearCarta voltear = new voltearCarta( carta1, carta2 );
                        voltear.execute();
                    }
                    contadorClick=0;
                }else{ 
                    contadorClick=0; 
                }
            }else{
                System.out.println("Presione el boton Jugar");
            }
            
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
   
        }

        @Override
        public void mouseReleased(MouseEvent e){}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
        
    } 
    class voltearCarta extends SwingWorker<Void, Void>{
        private Celda celda1;
        private Celda celda2;
        
        public voltearCarta(Celda cel1, Celda cel2){
            this.celda1= cel1;
            this.celda2= cel2;
        }
        
        
        
        
        @Override
        protected Void doInBackground() throws Exception {    
            //Hilo para la animacion de la carta
            Thread.sleep( 1000 );                
            if( celda1.getnombrePokemon().equals( celda2.getnombrePokemon() ) ){
                pmios=pmios+1;
                System.out.println(puntajeMio());
                celda1.bloquearCarta(true);
                celda2.bloquearCarta(true);
                System.out.println("imagenes iguales"); 
                 
                parejas++;
                if( parejas == 8 ){//win
                    System.out.println("Ha ganado"+"ganador");  
                    JOptionPane.showMessageDialog(null,"Mensaje con nombre del ganador");
                }
            }            
            else{
                celda1.ocultarCarta();
                celda2.ocultarCarta();
                System.out.println("no son iguales");    
            }
            return null;
        }
    
    }
    

    
}
