/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect3;

/**
 *
 * @author paula
 */
public class Pieces {
    int selectedPieces[]= new int[12];
    //one way of placing it k=cte
    public boolean piece1(int fila, int columna, Square[][] casillas) {//X
        Square[][] aux = casillas.clone();
        System.out.println("estoy colocando la pieza 1");
        try {
            if (isTaken(fila, columna, casillas)) {
                return false;
            } else {
                casillas[fila][columna].value = 1;
            }
            fila++;
            for (int i = columna - 1; i <= columna + 1; i++) {
                if (isTaken(fila, i, casillas)) {
                    return false;
                } else {
                    casillas[fila][i].value = 1;
                }
            }
            fila++;
            if (isTaken(fila, columna, casillas)) {
                return false;
            } else {
                casillas[fila][columna].value = 1;
            }
        } catch (IndexOutOfBoundsException error) {
            return false;
        }
        casillas=aux;
        return true;
    }
    //two ways of placing k=1/2
    public boolean piece2(int fila, int columna, Square[][] casillas,int k){//I
        System.out.println("estoy colocando la pieza 2");
        Square[][] aux = casillas.clone();
        try{
        if(k==1){
            for(int i=fila;i<fila+5;i++){
                if(isTaken(i,columna,aux)){
                return false;
                }else aux[i][columna].value=2;
            }
        }
        if(k==2){
            for(int j=columna;j<columna+5;j++){
                if(isTaken(fila,j,aux)){
                return false;
                }else aux[fila][j].value=2;
            }
        }
        }catch (IndexOutOfBoundsException error){
            return false;
        }
        casillas=aux;
        return true;
    }
    
    //four ways of placeing it
    public boolean piece3(){//V
        return false;
    }
    public boolean piece4(){//U
        return false;
    }
    public void piece5(){//W
    }
    public void piece6(){//T
    }
    public void piece7(){//Z
    }
    //eight ways of placing it
    public void piece8(){//N
    }
    public void piece9(){//L
    }
    public void piece10(){//Y
    }
    public void piece11(){//F
    }
    public void piece12(){//P   
    }
    
//    public boolean setSelected(int i){
//        if(selectedPieces[i-1]==-1){
//            selectedPieces[i-1]=0;
//            return true;
//        }
//        return false;
//    }
    public boolean isTaken(int i, int j, Square[][] casillas){
        if(casillas[i][j].value==-1||i>=3||j>=20){
            return false;
        }
        return true;
    }
}
