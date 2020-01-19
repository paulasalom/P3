/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author paula
 */
public class Board extends JPanel{
    
    private int filas, columnas;
    private final int tamanio = 40;//tamaño en altura y ancho de la casilla
    public  final Square[][] casillas;
    private Pieces piece = new Pieces();
    private final int dimensionY;
    private final int dimensionX;

    
    
    /**
     * Método que crea un array bidimensional de casillas.
     * @param fil
     * @param col
     */
    public Board(int fil, int col) {
        this.filas=fil;
        this.columnas=col;
        dimensionY = tamanio*filas;//dimensión del tablero
        dimensionX = tamanio*columnas;
        casillas = new Square[filas][columnas];
        for (int fila = 0; fila < filas; fila++) {
            int x = 0;
            int y = fila * tamanio;
            for (int columna = 0; columna < columnas; columna++) {
                casillas[fila][columna] = new Square(x, y,-1);
                x = x + tamanio;
            }
        }
        backtracking();
    }
    public Board() {
        casillas = new Square[filas][columnas];
        dimensionY = tamanio*filas;//dimensión del tablero
        dimensionX = tamanio*columnas;
    }


    /**
     * Devuelve las dimensiones del panel del tablero (dimensión x dimensión).
     *
     * @return Dimension
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(dimensionX-15, dimensionY-15);
    }

    /**
     * Método que pinta las casillas del tablero, con sus corresponendientes
     * piezas de colores diferentes, en el panel. En función del número que 
     * encuentra en cada casilla, pinta un cuadrado del color asociado a ese 
     * número.Finalmente pinta los bordes de las casillas en negro.
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        
        for(int fila=0;fila<filas;fila++){
            for(int columna=0;columna<columnas;columna++){
                g.setColor(Color.WHITE);
                if(casillas[fila][columna].value==1)g.setColor(Color.CYAN);
                if(casillas[fila][columna].value==2)g.setColor(Color.RED);
                if(casillas[fila][columna].value==3)g.setColor(Color.BLUE);
                if(casillas[fila][columna].value==4)g.setColor(Color.GREEN);
                if(casillas[fila][columna].value==5)g.setColor(Color.MAGENTA);
                if(casillas[fila][columna].value==6)g.setColor(Color.ORANGE);
                if(casillas[fila][columna].value==7)g.setColor(Color.PINK);
                if(casillas[fila][columna].value==8)g.setColor(Color.YELLOW);
                if(casillas[fila][columna].value==9)g.setColor(Color.GRAY);
                if(casillas[fila][columna].value==10)g.setColor(new Color(200, 19, 98, 70));
                if(casillas[fila][columna].value==11)g.setColor(new Color(100, 19, 30, 70));
                if(casillas[fila][columna].value==12)g.setColor(new Color(49, 37, 150,150));
                g.fillRect((int) casillas[fila][columna].getX(), 
                    (int) casillas[fila][columna].getY(), tamanio, tamanio);
                
            }
        }
        
        g.setColor(Color.BLACK);
        for (int fila = 0; fila < filas; fila++) {   
            g.drawLine(0, (int) casillas[fila][0].getY(),
                    dimensionX, (int) casillas[fila][0].getY()); 
        }
        g.drawLine( 0, (int) casillas[filas - 1][0].getY() + tamanio,
                dimensionX, (int) casillas[filas - 1][0].getY() + tamanio);

        for (int columna = 0; columna < columnas; columna++) {
            g.drawLine((int) casillas[0][columna].getX(), 0,
                    (int) casillas[0][columna].getX(), dimensionY);
        }
        g.drawLine((int) casillas[0][columnas - 1].getX() + tamanio, 0,
                (int) casillas[0][columnas - 1].getX() + tamanio, dimensionY);

    }
    
    /**
     *Método que comprueba que las filas y columnas introducidas como parámetro
     * pertenezcan a uno de los tableros posibles.
     * En caso de que pertenezca devuelve true, en caso contrario false.
     * 
     * @param filas
     * @param columnas
     * @return boolean
     */
    public boolean esTablero(Object filas, Object columnas) {
        if(filas.equals("6") && columnas.equals("10")){
            return true; 
        }
        if(filas.equals("5") && columnas.equals("12")){
            return true;
        }
        if(filas.equals("4") && columnas.equals("15")){
            return true;
        }
        if(filas.equals("3") && columnas.equals("20")){
            return true;
        }
        return false;
    }
    
    public void bloqueo(int fila, int columna){
        casillas[fila][columna].setValue(0);
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
    
    public void print(){
        for(int fila=0;fila<filas;fila++){
            for(int columna=0;columna<columnas;columna++){
                System.out.print(casillas[fila][columna].value+" || ");
            }
            System.out.println("\n");
        }
    }

    private void backtracking() {
    /*mientas(la posición del array<=12(número máximo de piecas que se pueden colocar))
        si(casillas[fila][columna]>-1) pasar a siguiente casilla
        si_no
            si(colocarPiezaN(N,fila,columna==true)
                si(posicion array=12) añadir al array y añadir la solucion al array soluciones
                si_no añadir al array y coger otra pieza
    DE QUE MANERA SE PUEDEN ORDENAR 63 NÚMEROS DIFERENTES-->BACKTRACKING CONTRASEÑA   
        */
    }
    
    private boolean colocarPiezaN(int N, int fila, int columna){
        boolean r=false;
        if(N==1)r=piece.piece1(fila,columna, casillas);
        
        if(N==2)r=piece.piece2(fila,columna, casillas,1);
        if(N==3)r=piece.piece2(fila,columna, casillas,2);
        
        if(N==4)r=piece.piece3(fila,columna, casillas,1);
        if(N==5)r=piece.piece3(fila,columna, casillas,2);
        if(N==6)r=piece.piece3(fila,columna, casillas,3);
        if(N==7)r=piece.piece3(fila,columna, casillas,4);
        
        if(N==8)r=piece.piece4(fila,columna, casillas,1);
        if(N==9)r=piece.piece4(fila,columna, casillas,2);
        if(N==10)r=piece.piece4(fila,columna, casillas,3);
        if(N==11)r=piece.piece4(fila,columna, casillas,4);
        
        if(N==12)r=piece.piece5(fila,columna, casillas,1);
        if(N==13)r=piece.piece5(fila,columna, casillas,2);
        if(N==14)r=piece.piece5(fila,columna, casillas,3);
        if(N==15)r=piece.piece5(fila,columna, casillas,4);
        
        if(N==16)r=piece.piece6(fila,columna, casillas,1);
        if(N==17)r=piece.piece6(fila,columna, casillas,2);
        if(N==18)r=piece.piece6(fila,columna, casillas,3);
        if(N==19)r=piece.piece6(fila,columna, casillas,4);
        
        if(N==20)r=piece.piece7(fila,columna, casillas,1);
        if(N==21)r=piece.piece7(fila,columna, casillas,2);
        if(N==22)r=piece.piece7(fila,columna, casillas,3);
        if(N==23)r=piece.piece7(fila,columna, casillas,4);
        
        if(N==24)r=piece.piece8(fila,columna, casillas,1);
        if(N==25)r=piece.piece8(fila,columna, casillas,2);
        if(N==26)r=piece.piece8(fila,columna, casillas,3);
        if(N==27)r=piece.piece8(fila,columna, casillas,4);
        if(N==28)r=piece.piece8(fila,columna, casillas,5);
        if(N==29)r=piece.piece8(fila,columna, casillas,6);
        if(N==30)r=piece.piece8(fila,columna, casillas,7);
        if(N==31)r=piece.piece8(fila,columna, casillas,8);
        
        if(N==32)r=piece.piece9(fila,columna, casillas,1);
        if(N==33)r=piece.piece9(fila,columna, casillas,2);
        if(N==34)r=piece.piece9(fila,columna, casillas,3);
        if(N==35)r=piece.piece9(fila,columna, casillas,4);
        if(N==36)r=piece.piece9(fila,columna, casillas,5);
        if(N==37)r=piece.piece9(fila,columna, casillas,6);
        if(N==38)r=piece.piece9(fila,columna, casillas,7);
        if(N==39)r=piece.piece9(fila,columna, casillas,8);
        
        if(N==40)r=piece.piece10(fila,columna, casillas,1);
        if(N==41)r=piece.piece10(fila,columna, casillas,2);
        if(N==42)r=piece.piece10(fila,columna, casillas,3);
        if(N==43)r=piece.piece10(fila,columna, casillas,4);
        if(N==44)r=piece.piece10(fila,columna, casillas,5);
        if(N==45)r=piece.piece10(fila,columna, casillas,6);
        if(N==46)r=piece.piece10(fila,columna, casillas,7);
        if(N==47)r=piece.piece10(fila,columna, casillas,8);
        
        if(N==48)r=piece.piece11(fila,columna, casillas,1);
        if(N==49)r=piece.piece11(fila,columna, casillas,2);
        if(N==50)r=piece.piece11(fila,columna, casillas,3);
        if(N==51)r=piece.piece11(fila,columna, casillas,4);
        if(N==52)r=piece.piece11(fila,columna, casillas,5);
        if(N==53)r=piece.piece11(fila,columna, casillas,6);
        if(N==54)r=piece.piece11(fila,columna, casillas,7);
        if(N==55)r=piece.piece11(fila,columna, casillas,8);
        
        if(N==56)r=piece.piece12(fila,columna, casillas,1);
        if(N==57)r=piece.piece12(fila,columna, casillas,2);
        if(N==58)r=piece.piece12(fila,columna, casillas,3);
        if(N==59)r=piece.piece12(fila,columna, casillas,4);
        if(N==60)r=piece.piece12(fila,columna, casillas,5);
        if(N==61)r=piece.piece12(fila,columna, casillas,6);
        if(N==62)r=piece.piece12(fila,columna, casillas,7);
        if(N==63)r=piece.piece12(fila,columna, casillas,8);
        
        return r;
    }
}
