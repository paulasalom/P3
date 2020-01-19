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
    private  Square[][] copy = null;
    
    //one way of placing it k=cte
    public boolean piece1(int fila, int columna, Square[][] casillas) {//X
        System.out.println("estoy colocando la pieza 1");
        copy = null;
        initCopy(casillas);
        try {
            if (isTaken(fila, columna, copy)) {
                return false;
            } else {
                copy[fila][columna].value = 1;
            }
            fila++;
            for (int i = columna - 1; i <= columna + 1; i++) {
                if (isTaken(fila, i, copy)) {
                    return false;
                } else {
                    copy[fila][i].value = 1;
                }
            }
            fila++;
            if (isTaken(fila, columna, copy)) {
                return false;
            } else {
                copy[fila][columna].value = 1;
            }
        } catch (IndexOutOfBoundsException error) {
            System.out.println("error en 1");
            return false;
        }
        endCopy(casillas);
        return true;
    }
    //two ways of placing k=1/2
    public boolean piece2(int fila, int columna,Square[][] casillas,int k){//I
        System.out.println("estoy colocando la pieza 2");
        copy = null;
        initCopy(casillas);
        try{
        if(k==1){//posicion vertical
            for(int i=fila;i<fila+5;i++){
                if(isTaken(i,columna,copy)){
                return false;
                }else copy[i][columna].value=2;
            }
        }
        if(k==2){//posicion horizontal
            for(int j=columna;j<columna+5;j++){
                if(isTaken(fila,j,copy)){
                return false;
                }else copy[fila][j].value=2;
            }
        }
        }catch (IndexOutOfBoundsException error){
            System.out.println("error en 2");
            return false;
        }
        endCopy(casillas);
        return true;
    }
    
    //four ways of placeing it k=1/2/3/4
    public boolean piece3(int fila, int columna,Square[][] casillas,int k){//V
        copy = null;
        initCopy(casillas);
        try{
            if(k == 1){
                for(int i = fila; i < fila + 3; i++){
                    if(isTaken(i, columna, copy)){
                        return false;
                    }else copy[i][columna].value = 3;
                }
                for(int i = columna + 1; i < columna + 3; i++){
                    if(isTaken(fila, i, copy)){
                        return false;
                    }else copy[fila][i].value = 3;
                }
            }
            if(k == 2){
                for(int i = columna; i < columna + 3; i++){
                    if(isTaken(fila, i, copy)){
                        return false;
                    }else copy[fila][i].value = 3;
                }
                for(int i = fila + 1; i < fila + 3; i++){
                    if(isTaken(i, columna + 2, copy)){
                        return false;
                    }else copy[i][columna + 2].value = 3;
                }
            } 
            if(k == 3){
                for(int i = columna; i < columna + 3; i++){
                    if(isTaken(fila , i, copy)){
                        return false;
                    }else copy[fila][i].value = 3;
                }
                for(int i = fila-2; i < fila  ; i++){
                    if(isTaken(i, columna + 2, copy)){
                        return false;
                    }else copy[i][columna + 2].value = 3;
                }
                
            }
            if(k == 4){
                for(int i = fila; i < fila + 3; i++){
                    if(isTaken(i, columna, copy)){
                        return false;
                    }else copy[i][columna].value = 3;
                }
                for(int i = columna + 1; i < columna + 3; i++){
                    if(isTaken(fila + 2, i, copy)){
                        return false;
                    }else copy[fila + 2][i].value = 3;
                }
            } 
        }catch(IndexOutOfBoundsException error){
            System.out.println("error 3");
            return false;
        }
        endCopy(casillas);
        return true;
    }
    public boolean piece4(int fila, int columna,Square[][] casillas,int k){//U
        copy = null;
        initCopy(casillas);
        try{
            if(k == 1){
                for(int i = 0; i < 3; i++){
                    if(i != 1){
                        if(isTaken(fila, columna + i, copy)){
                            return false;
                        }else copy[fila][columna + i].value = 4;
                        if(isTaken(fila + 1, columna + i, copy)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 4;
                    }
                    if(isTaken(fila + 2, columna + i, copy)){
                        return false;
                    }else copy[fila + 2][columna + i].value = 4;
                    
                }
            }
            if(k == 2){
                for(int i = columna; i < columna+3; i++){
                    if(isTaken(fila, i, copy)){
                        return false;
                    }else copy[fila][i].value = 4;
                }
                if(isTaken(fila+1, columna, copy))return false;
                else copy[fila + 1][columna].value = 4; 
                for(int i = columna; i < columna+3; i++){
                    if(isTaken(fila+2, i, copy)){
                        return false;
                    }else copy[fila+2][i].value = 4;
                } 
                
            } 
            if(k == 3){
                for(int i = fila; i < fila+3; i++){
                    if(isTaken(i, columna, copy))return false;
                    else copy[i][columna].value = 4;
                }
                if(isTaken(fila, columna+1, copy))return false;
                    else copy[fila][columna+1].value = 4;
                for(int i = fila; i < fila+3; i++){
                    if(isTaken(i, columna+2, copy))return false;
                    else copy[i][columna+2].value = 4;
                }
            }
            if(k == 4){
                for(int i = columna; i < columna+3; i++){
                    if(isTaken(fila, i, copy))return false;
                    else copy[fila][i].value = 4;
                }
                if(isTaken(fila+1, columna+2, copy))return false;
                    else copy[fila+1][columna+2].value = 4;
                for(int i = columna; i < columna+3; i++){
                    if(isTaken(fila+2, i, copy))return false;
                    else copy[fila+2][i].value = 4;
               
                }
            }    
        }catch(IndexOutOfBoundsException error){
            return false;
        }
        endCopy(casillas);
        return true;
    }
    public boolean piece5(int fila, int columna,Square[][] casillas,int k){//W
        copy = null;
        initCopy(casillas);
        try{
            if(k == 1){
                for(int i = 0; i < 3; i++){
                    if(i == 0){
                        if(isTaken(fila, columna + i, copy)){
                            return false;
                        }else copy[fila][columna + i].value = 5;
                    }
                    if(i != 2){
                        if(isTaken(fila + 1, columna + i, copy)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 5;
                    }
                        
                    if (i != 0){
                        if(isTaken(fila + 2, columna + i, copy)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 5;
                    }
                }
            }
            if(k == 2){
                if(isTaken(fila, columna, copy))return false;
                else copy[fila][columna].value = 5;
                for(int i =columna-1 ; i < columna+1; i++){
                    if(isTaken(fila+1, i, copy))return false;
                    else copy[fila+1][i].value = 5;
                }
                for(int i =columna-2 ; i < columna; i++){
                    if(isTaken(fila+2, i, copy))return false;
                    else copy[fila+2][i].value = 5;
                }
            } 
            if(k == 3){
                for(int i = 0; i < 3; i++){
                    if(i != 2){
                        if(isTaken(fila, columna + i, copy)){
                            return false;
                        }else copy[fila][columna + i].value = 5;
                    }
                    if(i != 0){
                        if(isTaken(fila + 1, columna + i, copy)){
                            return false;
                        }else copy[fila + 1][columna + i].value = 5;
                    }
                        
                    if (i == 2){
                        if(isTaken(fila + 2, columna + i, copy)){
                            return false;
                        }else copy[fila + 2][columna + i].value = 5;
                    }
                }
            }
            if(k == 4){
                for(int i =columna ; i < columna+2; i++){
                    if(isTaken(fila, i, copy))return false;
                    else copy[fila][i].value = 5;
                }
                for(int i =columna-1 ; i < columna+1; i++){
                    if(isTaken(fila+1, i, copy))return false;
                    else copy[fila+1][i].value = 5;
                }
                if(isTaken(fila+2, columna-1, copy))return false;
                else copy[fila+2][columna-1].value = 5;
                
                
            }
        }catch(IndexOutOfBoundsException error){
            return false;
        }
        endCopy(casillas);
        return true;
    }
    public boolean piece6(int fila, int columna,Square[][] casillas,int k){//T
        copy = null;
        initCopy(casillas);
        try{
            if(k == 1){
                for(int i = columna; i < columna+3; i++){
                    if(isTaken(fila, i, copy))return false;
                    else copy[fila][i].value = 6;
                }
                for(int i = fila+1; i < fila+3; i++){
                    if(isTaken(i, columna+1, copy))return false;
                    else copy[i][columna+1].value = 6;
                }
            }
            if(k == 2){
                for(int i = fila; i < fila+3; i++){
                    if(isTaken(i, columna, copy))return false;
                    else copy[i][columna].value = 6;
                }
                for(int i = columna+1; i < columna+3; i++){
                    if(isTaken(fila+1, i, copy))return false;
                    else copy[fila+1][i].value = 6;
               
                }
            } 
            if(k == 3){
                for(int i = fila; i < fila+2; i++){
                    if(isTaken(i, columna, copy))return false;
                    else copy[i][columna].value = 6;
               
                }
                for(int i = columna-1; i < columna+2; i++){
                    if(isTaken(fila+2, i, copy))return false;
                    else copy[fila+2][i].value = 6;
                }
            }
            if(k == 4){
                for(int i = columna; i < columna+2; i++){
                    if(isTaken(fila, i, copy))return false;
                    else copy[fila][i].value = 6;
               
                }
                for(int i = fila-1; i < fila+2; i++){
                    if(isTaken(i, columna+2, copy))return false;
                    else copy[i][columna+2].value = 6;
                }
                
            }
        }catch(IndexOutOfBoundsException error){
            return false;
        }
        endCopy(casillas); 
        return true;
    }
    public boolean piece7(int fila, int columna,Square[][] casillas,int k){//Z
        copy = null;
        initCopy(casillas);
        try{
            if(k == 1){
                if(isTaken(fila, columna, copy))return false;
                    else copy[fila][columna].value = 7;
                for(int i = fila; i < fila+3; i++){
                    if(isTaken(i, columna+1, copy))return false;
                    else copy[i][columna+1].value = 7;
                }
                if(isTaken(fila+2, columna+2, copy))return false;
                    else copy[fila+2][columna+2].value = 7;
            }
            if(k == 2){
                if(isTaken(fila, columna, copy))return false;
                    else copy[fila][columna].value = 7;
                for(int i = fila-2; i < fila+1; i++){
                    if(isTaken(i, columna+1, copy))return false;
                    else copy[i][columna+1].value = 7;
                }
                if(isTaken(fila-2, columna+2, copy))return false;
                    else copy[fila-2][columna+2].value = 7;
            } 
            if(k == 3){
                if(isTaken(fila, columna, copy))return false;
                    else copy[fila][columna].value = 7;
                for(int i = columna-2; i < columna+1; i++){
                    if(isTaken(fila+1, i, copy))return false;
                    else copy[fila+1][i].value = 7;
                }
                if(isTaken(fila+2, columna-2, copy))return false;
                    else copy[fila+2][columna-2].value = 7;
            }
            if(k == 4){
                if(isTaken(fila, columna, copy))return false;
                    else copy[fila][columna].value = 7;
                for(int i = columna; i < columna+3; i++){
                    if(isTaken(fila+1, i, copy))return false;
                    else copy[fila+1][i].value = 7;
                }
                if(isTaken(fila+2, columna+2, copy))return false;
                    else copy[fila+2][columna+2].value = 7;
            }
        }catch(IndexOutOfBoundsException error){
            return false;
        }
        endCopy(casillas); 
        return true;
    }
    //eight ways of placing it k=1/2/3/4/5/6/7/8
    public boolean piece8(int fila, int columna,Square[][] casillas,int k){//N
        copy = null;
        initCopy(casillas);
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
                for(int i = columna; i < columna+3; i++){
                    if(isTaken(fila, i, copy))return false;
                    else copy[fila][i].value = 8;
                }
                for(int i = columna+2; i < columna+4; i++){
                    if(isTaken(fila-1, i, copy))return false;
                    else copy[fila-1][i].value = 8;
                }
            } 
            if(k == 3){
                for(int i = columna; i < columna+2; i++){
                    if(isTaken(fila, i, copy))return false;
                    else copy[fila][i].value = 8;
                }
                for(int i = columna+1; i < columna+4; i++){
                    if(isTaken(fila-1, i, copy))return false;
                    else copy[fila-1][i].value = 8;
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
                for(int i = fila; i < fila+2; i++){
                    if(isTaken(i, columna, copy))return false;
                    else copy[i][columna].value = 8;
                }
                for(int i = fila+1; i < fila+4; i++){
                    if(isTaken(i, columna-1, copy))return false;
                    else copy[i][columna-1].value = 8;
                }
            }
            if(k == 6){
                for(int i = fila; i < fila+3; i++){
                    if(isTaken(i, columna, copy))return false;
                    else copy[i][columna].value = 8;
                }
                for(int i = fila+2; i < fila+4; i++){
                    if(isTaken(i, columna-1, copy))return false;
                    else copy[i][columna-1].value = 8;
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
                for(int i = columna; i < columna+3; i++){
                    if(isTaken(fila, i, copy))return false;
                    else copy[fila][i].value = 8;
                }
                for(int i = columna+2; i < columna+4; i++){
                    if(isTaken(fila+1, i, copy))return false;
                    else copy[fila+1][i].value = 8;
                }
            }
        }catch(IndexOutOfBoundsException error){
            return false;
        }
        endCopy(casillas);
        return true;
    }
    public boolean piece9(int fila, int columna,Square[][] casillas,int k){//L
        copy = null;
        initCopy(casillas);
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
                for(int i = fila; i < fila+4; i++){
                    if(isTaken(i, columna, copy))return false;
                    else copy[i][columna].value = 9;
                }
                    if(isTaken(fila+3, columna-1, copy))return false;
                    else copy[fila+3][columna-1].value = 9;
                
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
                for(int i = columna; i < columna+4; i++){
                    if(isTaken(fila, i, copy))return false;
                    else copy[fila][i].value = 9;
                }
                    if(isTaken(fila-1, columna+3, copy))return false;
                    else copy[fila-1][columna+3].value = 9;
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
        }catch(IndexOutOfBoundsException error){
            return false;
        }
        endCopy(casillas);
        return true;
    }
    public boolean piece10(int fila, int columna,Square[][] casillas,int k){//Y
        copy = null;
        initCopy(casillas);
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
                for(int i = columna; i < columna+4; i++){
                    if(isTaken(fila, i, copy))return false;
                    else copy[fila][i].value = 10;
                }
                    if(isTaken(fila-1, columna+2, copy))return false;
                    else copy[fila-1][columna+2].value = 10;
            }
            if(k == 4){
                for(int i = fila; i < fila+4; i++){
                    if(isTaken(i, columna, copy))return false;
                    else copy[i][columna].value = 10;
                }
                    if(isTaken(fila+1, columna-1, copy))return false;
                    else copy[fila+1][columna-1].value = 10;
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
                for(int i = columna; i < columna+4; i++){
                    if(isTaken(fila, i, copy))return false;
                    else copy[fila][i].value = 10;
                }
                    if(isTaken(fila-1, columna+1, copy))return false;
                    else copy[fila-1][columna+1].value = 10;
            }
            if(k == 8){
                for(int i = fila; i < fila+4; i++){
                    if(isTaken(i, columna, copy))return false;
                    else copy[i][columna].value = 10;
                }
                    if(isTaken(fila+2, columna-1, copy))return false;
                    else copy[fila+2][columna-1].value = 10;
            }
        }catch(IndexOutOfBoundsException error){
            return false;
        }
        endCopy(casillas);
        return true;
    }
    public boolean piece11(int fila, int columna,Square[][] casillas,int k){//F
        copy = null;
        initCopy(casillas);
        try{
            if(k==1){
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 11;
                for(int f=fila-1;f<fila+2;f++){
                       if (isTaken(f, columna+1, copy)) return false;
                       else copy[f][columna+1].value = 11;
                }
                if (isTaken(fila-1, columna+2, copy)) return false;
                else copy[fila-1][columna+2].value = 11;
                
            }
            if(k==2){
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 11;
                for(int f=fila;f<fila+3;f++){
                       if (isTaken(f, columna+1, copy)) return false;
                       else copy[f][columna+1].value = 11;
                }
                if (isTaken(fila+1, columna+2, copy)) return false;
                else copy[fila+1][columna+2].value = 11;
            }
            if(k==3){
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 11;
                for(int f=fila-2;f<fila+1;f++){
                       if (isTaken(f, columna+1, copy)) return false;
                       else copy[f][columna+1].value = 11;
                }
                if (isTaken(fila-1, columna+2, copy)) return false;
                else copy[fila-1][columna+2].value = 11;
            }
            if(k==4){
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 11;
                for(int f=fila-1;f<fila+2;f++){
                       if (isTaken(f, columna+1, copy)) return false;
                       else copy[f][columna+1].value = 11;
                }
                if (isTaken(fila+1, columna+2, copy)) return false;
                else copy[fila+1][columna+2].value = 11;
            }
            if(k==5){
                for(int c=columna;c<columna+3;c++){
                       if (isTaken(fila, c, copy)) return false;
                       else copy[fila][c].value = 11;
                }
                if (isTaken(fila-1, columna+2, copy)) return false;
                else copy[fila-1][columna+2].value = 11;
                if (isTaken(fila+1, columna+1, copy)) return false;
                else copy[fila+1][columna+1].value = 11;
            }
            if(k==6){
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 11;
                for(int c=columna;c<columna+3;c++){
                       if (isTaken(fila+1, c, copy)) return false;
                       else copy[fila+1][c].value = 11;
                }
                if (isTaken(fila+2, columna+1, copy)) return false;
                else copy[fila+2][columna+1].value = 11;
            }
            if(k==7){
                for(int c=columna;c<columna+3;c++){
                       if (isTaken(fila, c, copy)) return false;
                       else copy[fila][c].value = 11;
                }
                if (isTaken(fila+1, columna, copy)) return false;
                else copy[fila+1][columna].value = 11;
                if (isTaken(fila-1, columna+1, copy)) return false;
                else copy[fila-1][columna+1].value = 11;
            }
            if(k==8){
                for(int c=columna;c<columna+3;c++){
                       if (isTaken(fila, c, copy)) return false;
                       else copy[fila][c].value = 11;
                }
                if (isTaken(fila+1, columna+2, copy)) return false;
                else copy[fila+1][columna+2].value = 11;
                if (isTaken(fila-1, columna+1, copy)) return false;
                else copy[fila-1][columna+1].value = 11;
            }
        }catch(IndexOutOfBoundsException error){
            return false;
        }
        endCopy(casillas);
        return true;
    }
    public boolean piece12(int fila, int columna,Square[][] casillas,int k){//P 
        copy = null;
        initCopy(casillas);
        try{
            if(k==1){
                for(int f=fila;f<fila+2;f++){
                    for(int c=columna;c<columna+2;c++){
                       if (isTaken(f, c, copy)) return false;
                       else copy[f][c].value = 12;
                    }
                }
                fila+=2;
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 12;
            }
            if(k==2){
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 12;
                for(int f=fila+1;f<fila+3;f++){
                    for(int c=columna;c<columna+2;c++){
                       if (isTaken(f, c, copy)) return false;
                       else copy[f][c].value = 12;
                    }
                }
            }
            if(k==3){
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 12;
                for(int f=fila-1;f<fila+1;f++){
                    for(int c=columna+1;c<columna+3;c++){
                       if (isTaken(f, c, copy)) return false;
                       else copy[f][c].value = 12;
                    }
                }
            }
            if(k==4){
                for(int f=fila;f<fila+2;f++){
                    for(int c=columna;c<columna+2;c++){
                       if (isTaken(f, c, copy)) return false;
                       else copy[f][c].value = 12;
                    }
                }
                columna+=2;
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 12;
            }
            if(k==5){
                for(int f=fila;f<fila+2;f++){
                    for(int c=columna;c<columna+2;c++){
                       if (isTaken(f, c, copy)) return false;
                       else copy[f][c].value = 12;
                    }
                }
                fila+=2;
                columna+=1;
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 12;
            }
            if(k==6){
                for(int f=fila;f<fila+2;f++){
                    for(int c=columna;c<columna+2;c++){
                       if (isTaken(f, c, copy)) return false;
                       else copy[f][c].value = 12;
                    }
                }
                columna+=2;
                fila+=1;
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 12;
            }
            if(k==7){
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 12;
                for(int f=fila+1;f<fila+3;f++){
                    for(int c=columna-1;c<columna+1;c++){
                       if (isTaken(f, c, copy)) return false;
                       else copy[f][c].value = 12;
                    }
                }
                
            }
            if(k==8){
                if (isTaken(fila, columna, copy)) return false;
                else copy[fila][columna].value = 12;
                for(int f=fila;f<fila+2;f++){
                    for(int c=columna+1;c<columna+3;c++){
                       if (isTaken(f, c, copy)) return false;
                       else copy[f][c].value = 12;
                    }
                }
                
            }
        }catch(IndexOutOfBoundsException error){
            return false;
        }
        endCopy(casillas); 
        return true;
    }

    public boolean isTaken(int i, int j, Square[][] casillas){
        if(casillas[i][j].value==-1) return false;
        return true;
    }
    private void initCopy(Square[][] casillas){
        copy = new Square[Pentomino.filas][Pentomino.columnas];
        for (int f = 0; f < Pentomino.filas; f++) {
            int x = 0;
            int y = f * 40;
            for (int c = 0; c < Pentomino.columnas; c++) {
                copy[f][c] = new Square(x, y,casillas[f][c].value);
                x = x + 40;
            }
        }
    }

    private void endCopy(Square[][] casillas) {
        for (int f = 0; f < Pentomino.filas; f++) {
            for (int c = 0; c < Pentomino.columnas; c++) {
              casillas[f][c].value=copy[f][c].value;  
            }
        }
    }
}
