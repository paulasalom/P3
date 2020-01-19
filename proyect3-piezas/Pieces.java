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
public class Pieces{
    int selectedPieces[]= new int[12];
    private Square[][] copy = null;
    //one way of placing it k=cte
    /*
            *
          * * *
            *   
    */
    public boolean piece1(int fila, int columna, Square[][] casillas) {//X
   
        System.out.println("estoy colocando la pieza 1");
        initCopy(casillas, Pentomino.filas, Pentomino.columnas);
        
        try {
            if (isTaken(fila, columna, casillas)) {
                return false;
            } else{
                copy[fila][columna].value = 1;
            }
            for (int i = columna - 1; i <= columna + 1; i++) {
                if (isTaken(fila + 1, i, casillas)) {
                    return false;
                } else{
                    copy[fila + 1][i].value = 1;
                }
            }        
            if (isTaken(fila + 2, columna, casillas)) {
                return false;
            } else{
                copy[fila + 2][columna].value = 1;
            }
        
        endCopy(casillas, Pentomino.filas, Pentomino.columnas);    
        } catch (IndexOutOfBoundsException error) {
            return false;
        }
   
        return true;
    }
    //two ways of placing k=1-2
    /*
            K=1      K=2
            *
            *
            *       * * * * *
            *
            *
    */
    public boolean piece2(int fila, int columna, Square[][] casillas,int k){//I
        System.out.println("estoy colocando la pieza 2");
        initCopy(casillas, Pentomino.filas, Pentomino.columnas);
        try{
        if(k == 1){
            for(int i=fila;i<fila+5;i++){
                if(isTaken(i,columna,casillas)){
                return false;
                }else copy[i][columna].value = 2;
            }
        }
        if(k == 2){
            for(int j=columna;j<columna+5;j++){
                if(isTaken(fila,j,casillas)){
                return false;
                }else copy[fila][j].value = 2;
            }
        }
        endCopy(casillas, Pentomino.filas, Pentomino.columnas);
        }catch (IndexOutOfBoundsException error){
            return false;
        }

        return true;
    }
    
    //four ways of placeing it
    /*
            K=1      K=2     K=3     K=4
            * * *   * * *       *   *
            *           *       *   *
            *           *   * * *   * * * 
    */
    public boolean piece3(int fila, int columna, Square[][] casillas, int k){//V
        System.out.println("estoy colocando la pieza V");
        initCopy(casillas, Pentomino.filas, Pentomino.columnas);
        try{
            if(k == 1){
                for(int i = fila; i < fila + 3; i++){
                    if(isTaken(i, columna, casillas)){
                        return false;
                    }else copy[i][columna].value = 3;
                }
                for(int i = columna + 1; i < columna + 3; i++){
                    if(isTaken(fila, i, casillas)){
                        return false;
                    }else copy[fila][i].value = 3;
                }
            }
            if(k == 2){
                for(int i = columna; i < columna + 3; i++){
                    if(isTaken(fila, i, casillas)){
                        return false;
                    }else copy[fila][i].value = 3;
                }
                for(int i = fila + 1; i < fila + 3; i++){
                    if(isTaken(i, columna + 2, casillas)){
                        return false;
                    }else copy[i][columna + 2].value = 3;
                }
            } 
            if(k == 3){
                for(int i = fila; i < fila + 3; i++){
                    if(isTaken(i, columna + 2, casillas)){
                        return false;
                    }else copy[i][columna + 2].value = 3;
                }
                for(int i = columna; i < columna + 2; i++){
                    if(isTaken(fila + 2, i, casillas)){
                        return false;
                    }else copy[fila + 2][i].value = 3;
                }
            }
            if(k == 4){
                for(int i = fila; i < fila + 3; i++){
                    if(isTaken(i, columna, casillas)){
                        return false;
                    }else copy[i][columna].value = 3;
                }
                for(int i = columna + 1; i < columna + 3; i++){
                    if(isTaken(fila + 2, i, casillas)){
                        return false;
                    }else copy[fila + 2][i].value = 3;
                }
            }            
            
        } catch(IndexOutOfBoundsException error){
            return false;
        }
            endCopy(casillas, Pentomino.filas, Pentomino.columnas);
        return true;
    }
    //four ways of placeing it
    /*
            K=1      K=2     K=3     K=4
            *   *   * * *   * * *   * * *
            *   *   *       *   *       *
            * * *   * * *   *   *   * * * 
    */
    public boolean piece4(int fila, int columna, Square[][] casillas, int k){//U
        System.out.println("estoy colocando la pieza U");
        initCopy(casillas, Pentomino.filas, Pentomino.columnas);
        try{
            if(k == 1){
                for(int i = 0; i < 3; i++){
                    if(i != 1){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 4;
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 4;
                    }
                    if(isTaken(fila + 2, columna + i, casillas)){
                        return false;
                    }else copy[fila + 2][columna + i].value = 4;
                    
                }
            }
            if(k == 2){
                for(int i = 0; i < 3; i++){
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila][columna + i].value = 4;
                    
                    if(i == 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 4; 
                    }
                    
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila + 2][columna + i].value = 4;
                }
            } 
            if(k == 3){
                for(int i = 0; i < 3; i++){
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila][columna + i].value = 4;
                    
                    if(i != 1){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 4; 
                        
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 4;
                    }  
                }
            }
            if(k == 4){
                for(int i = 0; i < 3; i++){
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila][columna + i].value = 4;
                    
                    if(i == 2){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 4; 
                    }
                    
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila + 2][columna + i].value = 4;
                }
            }            
            
        } catch(IndexOutOfBoundsException error){
            return false;
        }
            endCopy(casillas, Pentomino.filas, Pentomino.columnas);
        return true;
    }
        //four ways of placeing it
    /*
            K=1      K=2     K=3     K=4
            *           *    * *       * *
            * *       * *      * *   * *  
              * *   * *          *   *        
    */
    public boolean piece5(int fila, int columna, Square[][] casillas, int k){//W
        System.out.println("estoy colocando la pieza W");
        initCopy(casillas, Pentomino.filas, Pentomino.columnas);
        try{
            if(k == 1){
                for(int i = 0; i < 3; i++){
                    if(i == 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 5;
                    }
                    if(i != 2){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 5;
                    }
                        
                    if (i != 0){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 5;
                    }
                }
            }
            if(k == 2){
                for(int i = 0; i < 3; i++){
                    if(i == 2){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 5;
                    }
                    if(i != 0){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 5;
                    }
                        
                    if (i != 2){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 5;
                    }
                }
            } 
            if(k == 3){
                for(int i = 0; i < 3; i++){
                    if(i != 2){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 5;
                    }
                    if(i != 0){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 5;
                    }
                        
                    if (i == 2){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 5;
                    }
                }
            }
            if(k == 4){
                for(int i = 0; i < 3; i++){
                    if(i != 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 5;
                    }
                    if(i != 2){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 5;
                    }
                        
                    if (i == 0){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 5;
                    }
                }
            }            
            
        } catch(IndexOutOfBoundsException error){
            return false;
        }
            endCopy(casillas, Pentomino.filas, Pentomino.columnas);
        return true;
    }
    /*
            K=1      K=2     K=3     K=4
            * * *        *     *    *
              *      * * *     *    * * *  
              *          *   * * *  *      
    */    
    public boolean piece6(int fila, int columna, Square[][] casillas, int k){//T
        System.out.println("estoy colocando la pieza T");
        initCopy(casillas, Pentomino.filas, Pentomino.columnas);
        try{
            if(k == 1){
                for(int i = 0; i < 3; i++){
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila][columna + i].value = 6;
                    
                    if(i == 1){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 6;
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 6;
                    }
                }
            }
            if(k == 2){
                for(int i = 0; i < 3; i++){
                    if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 6;
                    if(i == 2){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 6;
                        
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 6;
                    }
                }
            } 
            if(k == 3){
                for(int i = 0; i < 3; i++){
                    
                    if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                    }else copy[fila + 2][columna + i].value = 6;
                    if(i == 1){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 6;
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 6;
                    }
                }
            }
            if(k == 4){
                for(int i = 0; i < 3; i++){
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 6;
                    
                    if(i == 0){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 6;
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 6;
                    }
                }
            }            
            
        } catch(IndexOutOfBoundsException error){
            return false;
        }
            endCopy(casillas, Pentomino.filas, Pentomino.columnas);
        return true;
    }
    /*
            K=1      K=2     K=3     K=4
            * *          *     * *  *
              *      * * *     *    * * *  
              * *    *       * *        *      
    */   
    public boolean piece7(int fila, int columna, Square[][] casillas, int k){//Z
        System.out.println("estoy colocando la pieza Z");
        initCopy(casillas, Pentomino.filas, Pentomino.columnas);
        try{
            if(k == 1){
                for(int i = 0; i < 3; i++){
                    if(i != 2){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 7;
                    }
                    if(i == 1){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 7;
                    }
                    if(i != 0){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 7;
                    }
                }
            }
            if(k == 2){
                for(int i = 0; i < 3; i++){
                    if(i == 2){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 7;
                    }
                   
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 7;
                    
                    if(i == 0){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 7;
                    }
                }
            } 
            if(k == 3){
                for(int i = 0; i < 3; i++){
                    if(i != 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 7;
                    }
                    if(i == 1){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 7;
                    }
                    if(i != 2){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 7;
                    }
                }
            }
            if(k == 4){
                for(int i = 0; i < 3; i++){
                    if(i == 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 7;
                    }
                    
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 7;
                    
                    if(i == 2){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 7;
                    }
                }
            }            
            
        } catch(IndexOutOfBoundsException error){
            return false;
        }
            endCopy(casillas, Pentomino.filas, Pentomino.columnas);
        return true;
    }
    //eight ways of placing it
    /*
            K=1        K=2       K=3     K=4    K=5    K=6      K=7        K=8
            *         * * *       * *    *        *    * * *    * *         *
            *       * *       * * *      * *    * *        * *    * * *     *
            * *                            *    *                         * *  
              *                            *    *                         *
    */  
    public boolean piece8(int fila, int columna, Square[][] casillas, int k){//N
        System.out.println("estoy colocando la pieza N");
        initCopy(casillas, Pentomino.filas, Pentomino.columnas);
        try{
            if(k == 1){
                for(int i = 0; i < 2; i++){
                    if(i == 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 8;
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 8;
                    }
                    if(isTaken(fila + 2, columna + i, casillas)){
                        return false;
                    }else copy[fila + 2][columna + i].value = 8;
                    
                    if(i == 1){
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 8;
                    }
                }
            }
            if(k == 2){
                for(int i = 0; i < 4; i++){
                    if(i == 2 || i == 3){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 8; 
                    }
                    if(i != 3){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 8;
                    }
                }
            } 
            if(k == 3){
                for(int i = 0; i < 4; i++){
                    if(i != 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 8; 
                    }
                    if(i == 0 || i == 1){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 8;
                    }
                }
            }
            if(k == 4){
                for(int i = 0; i < 2; i++){
                    if(i == 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 8;
                    }
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 8;
                    if(i == 1){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 8;
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 8;
                    }
                }
            }
            if(k == 5){
                for(int i = 0; i < 2; i++){
                    if(i == 1){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 8;
                    }
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 8;
                    if(i == 0){
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 8;
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 8;
                    }
                }
            }
            if(k == 6){
                for(int i = 0; i < 4; i++){
                    if(i != 3){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 8;
                    }
                    if(i == 2 || i == 3){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 8;
                    }
                }
            }
            if(k == 7){
                for(int i = 0; i < 4; i++){
                    if(i == 0 || i == 1){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 8;
                    }
                    if(i != 0){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 8;
                    }
                }
            }
            if(k == 8){
                for(int i = 0; i < 2; i++){
                    if(i == 1){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 8;
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 8;
                    }
                    if(isTaken(fila + 2, columna + i, casillas)){
                        return false;
                    }else copy[fila + 2][columna + i].value = 8;
                    
                    if(i == 0){
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 8;
                    }
                }
            }
            
        } catch(IndexOutOfBoundsException error){
            return false;
        }
            endCopy(casillas, Pentomino.filas, Pentomino.columnas);
        return true;
    }
    /*
            K=1        K=2       K=3     K=4    K=5    K=6        K=7      K=8
            * *      * * * *    *           *    *     * * * *        *   * *
            *              *    * * * *     *    *     *        * * * *     *
            *                               *    *                          *  
            *                             * *    * *                        *
    */     
    public boolean piece9(int fila, int columna, Square[][] casillas, int k){//L
       System.out.println("estoy colocando la pieza L");
        initCopy(casillas, Pentomino.filas, Pentomino.columnas);
        try{
            if(k == 1){
                for(int i = 0; i < 2; i++){  
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila][columna + i].value = 9;

                    if(i == 0){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 9;

                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 9;
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 9;
                    }
                }
            }
            if(k == 2){
                for(int i = 0; i < 4; i++){
                    
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila][columna + i].value = 9; 
                    
                    if(i == 3){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 9;
                    }
                }
            } 
            if(k == 3){
                for(int i = 0; i < 4; i++){
                    if(i == 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 9;     
                    }
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 9;
                }
            }
            if(k == 4){
                for(int i = 0; i < 2; i++){  
                    if(i == 1){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 9;
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 9;

                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 9;
                    }
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 9;
                }
            }
            if(k == 5){
                for(int i = 0; i < 2; i++){  
                    if(i == 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 9;
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 9;

                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 9;
                    }
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 9;
                }
            }
            if(k == 6){
                for(int i = 0; i < 4; i++){
                    
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila][columna + i].value = 9; 
                    
                    if(i == 0){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 9;
                    }
                }
            }
            if(k == 7){
                for(int i = 0; i < 4; i++){
                    if(i == 3){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 9;     
                    }
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 9;
                }
            }
            if(k == 8){
                for(int i = 0; i < 2; i++){  
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila][columna + i].value = 9;

                    if(i == 1){
                      if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                      }else copy[fila + 1][columna + i].value = 9;

                      if(isTaken(fila + 2, columna + i, casillas)){
                        return false;
                      }else copy[fila + 2][columna + i].value = 9;
                      if(isTaken(fila + 3, columna + i, casillas)){
                        return false;
                      }else copy[fila + 3][columna + i].value = 9;
                    }
                }
            }
            
        } catch(IndexOutOfBoundsException error){
            return false;
        }
            endCopy(casillas, Pentomino.filas, Pentomino.columnas);
        return true; 
    }
    /*
            K=1        K=2       K=3     K=4    K=5    K=6        K=7      K=8
            *       * * * *        *       *    *     * * * *     *         *
            *         *        * * * *   * *    * *       *     * * * *     *
            * *                            *    *                         * *  
            *                              *    *                           *
    */ 
    public boolean piece10(int fila, int columna, Square[][] casillas, int k){//Y
       System.out.println("estoy colocando la pieza Y");
        initCopy(casillas, Pentomino.filas, Pentomino.columnas);
        try{
            if(k == 1){
                for(int i = 0; i < 2; i++){  
                    if(isTaken(fila + 2, columna + i, casillas)){
                        return false;
                    }else copy[fila + 2][columna + i].value = 10;

                    if(i == 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 10;
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 10;
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 10;
                    }
                }
            }
            if(k == 2){
                for(int i = 0; i < 4; i++){
                    
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila][columna + i].value = 10; 
                    
                    if(i == 1){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 10;
                    }
                }
            } 
            if(k == 3){
                for(int i = 0; i < 4; i++){
                    if(i == 2){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 10;     
                    }
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 10;
                }
            }
            if(k == 4){
                for(int i = 0; i < 2; i++){  
                    if(i == 1){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 10;
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 10;
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 10;
                    }
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 10;
                        
                }
            }
            if(k == 5){
                for(int i = 0; i < 2; i++){  
                    if(i == 0){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 10;
                        if(isTaken(fila + 2, columna + i, casillas)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 10;
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 10;
                    }
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 10;
                        
                }
            }
            if(k == 6){
                for(int i = 0; i < 4; i++){
                    
                    if(isTaken(fila, columna + i, casillas)){
                        return false;
                    }else copy[fila][columna + i].value = 10; 
                    
                    if(i == 2){
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 10;
                    }
                }
            }
            if(k == 7){
                for(int i = 0; i < 4; i++){
                    if(i == 1){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 10;     
                    }
                    if(isTaken(fila + 1, columna + i, casillas)){
                        return false;
                    }else copy[fila + 1][columna + i].value = 10;
                }
            }
            if(k == 8){
                for(int i = 0; i < 2; i++){  
                    
                        if(isTaken(fila + 2, columna + i, casillas)){
                        return false;
                      }else copy[fila + 2][columna + i].value = 10;
                    if(i == 1){
                        if(isTaken(fila, columna + i, casillas)){
                            return false;
                        }else copy[fila][columna + i].value = 10;
                        if(isTaken(fila + 1, columna + i, casillas)){
                            return false;
                         }else copy[fila + 1][columna + i].value = 10;
                        if(isTaken(fila + 3, columna + i, casillas)){
                            return false;
                        }else copy[fila + 3][columna + i].value = 10;
                    }
                }
            }
            
        } catch(IndexOutOfBoundsException error){
            return false;
        }
            endCopy(casillas, Pentomino.filas, Pentomino.columnas);
        return true;
    }
    /*
            K=1        K=2       K=3     K=4     K=5     K=6       K=7     K=8
            * *      *            *       *       *      * *        *         *
          * *        * * *      * * *     * *   * * *      * *    * *     * * *
            *          *            *   * *     *          *        * *     *
                                                                     
    */ 
    public void piece11(){//F
    }
    /*
           K=1        K=2       K=3      K=4     K=5     K=6       K=7     K=8
          * * *      *           * *     * *     * *     * * *    * *        * 
          * *        * *         * *   * * *     * *       * *    * * *    * *
                     * *           *             *                         * *
                                                                     
    */ 
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
        if(casillas[i][j].value == -1 && i < Pentomino.filas && j < Pentomino.columnas){
            return false;
        }
        return true;
    }
   
    private void initCopy(Square[][] casillas, int filas, int columnas){
        copy = new Square[filas][columnas];
        for (int f = 0; f < filas; f++){
            int x = 0;
            int y = f * 40;
            for (int c = 0; c < columnas; c++){
                copy[f][c] = new Square(x, y, casillas[f][c].value);
                x = x + 40;
            }
        }
    }
    
    private void endCopy(Square[][] casillas, int filas, int columnas){
        for(int f = 0; f < filas; f++){
            for(int c = 0; c < columnas; c++){
                casillas[f][c].value = copy[f][c].value;
            }
        }
    }
    
}
