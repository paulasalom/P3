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
    
    int filas, columnas=20;
    private final int tamanio = 40;//tamaño en altura o ancho de la casilla
    private static final Color NEGRO = Color.BLACK;
    public final Square[][] casillas;
    private final int dimensionY;
    private final int dimensionX;

    
    
    /**
     * Método que crea un array bidimensional de casillas.
     */
    public Board(int fil, int col) {
        Pieces piece = new Pieces();
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
        print();
       // piece.piece1(1,1, casillas);
       // print();
       // piece.piece2(3, 4, casillas, 2);
        piece.piece10(1, 1, casillas, 8);
        print();

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
     * imagenes, en el panel. En el caso de que la casilla este ocupada pinta la
     * imágen de una hoja, en el caso que la hormiga se haya comido la hoja
     * pinta una imágen en blanco, después pinta a la hormiga en la posición
     * aleatória. Finalmente pinta los bordes de las casillas en negro
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
                if(casillas[fila][columna].value==3)g.setColor(Color.GREEN);
                if(casillas[fila][columna].value==4)g.setColor(Color.MAGENTA);
                if(casillas[fila][columna].value==5)g.setColor(Color.ORANGE);
                if(casillas[fila][columna].value==6)g.setColor(Color.PINK);
                if(casillas[fila][columna].value==7)g.setColor(Color.YELLOW);
                if(casillas[fila][columna].value==8)g.setColor(Color.BLACK);
                if(casillas[fila][columna].value==9)g.setColor(Color.GRAY);
                if(casillas[fila][columna].value==10)g.setColor(Color.DARK_GRAY);
                g.fillRect((int) casillas[fila][columna].getX(), 
                    (int) casillas[fila][columna].getY(), tamanio, tamanio);
                
            }
        }
        g.setColor(NEGRO);
        for (int fila = 0; fila < filas; fila++) {   
            g.drawLine(0, (int) casillas[fila][0].getY(),
                    1000, (int) casillas[fila][0].getY()); 
        }
        g.drawLine( 0, (int) casillas[filas - 1][0].getY() + tamanio,
                1000, (int) casillas[filas - 1][0].getY() + tamanio);

        for (int columna = 0; columna < columnas; columna++) {
            g.drawLine((int) casillas[0][columna].getX(), 0,
                    (int) casillas[0][columna].getX(), 1000);
        }
        g.drawLine((int) casillas[0][columnas - 1].getX() + tamanio, 0,
                (int) casillas[0][columnas - 1].getX() + tamanio, 1000);

    }
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
        for(int fila = 0;fila < filas; fila++){
            for(int columna=0;columna<columnas;columna++){
                System.out.print(casillas[fila][columna].value+" || ");
            }
            System.out.println("\n");
        }
    }
    
}
