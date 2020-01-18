/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect3;

import javax.swing.JFrame;


/**
 *
 * @author paula
 */
public class Pentomino extends JFrame{
    
    private Board board;
    private int filas,columnas;

    public Pentomino(Object n, Object m) {
        super("PENTONIMO");
        setnXm(n, m);
        initComponents();
    }
    /**
     * Componentes gráficas de la ventana
     */
    private void initComponents() {
        
        board = new Board(filas,columnas);
        add(board);
        setSize(board.getPreferredSize());
        pack();
        setResizable(false);
    }
     public void setnXm(Object filas, Object columnas) {
        if(filas.equals("6") && columnas.equals("10")){
            this.filas=6;
            this.columnas=10;
        }
        if(filas.equals("5") && columnas.equals("12")){
            this.filas=5;
            this.columnas=12;
        }
        if(filas.equals("4") && columnas.equals("15")){
            this.filas=4;
            this.columnas=15;
        }
        if(filas.equals("3") && columnas.equals("20")){
            this.filas=3;
            this.columnas=20;
        }
    }
    
}
