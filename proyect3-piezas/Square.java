package proyect3;


/*
 * CLASE Casilla
 */
public class Square implements Cloneable{

    private boolean ocupada;
    int x, y, value;
    
    /**
     * Una casilla se identifica por su posición en el eje X=x
     * y en el eje Y=y, y puede estar ocupada o no.
     * 
     * @param x
     * @param y 
     */
    public Square(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        ocupada = true;
    }
    
    /**
     * pone la casilla en estado vacio --> ocupado=false
     */
    public void setLiberada() {
        ocupada = false;

    }
    
    /**
     * Devuelve true si la casilla está ocupada. Devuelve false si la casilla está
     * libre.
     *
     * @return ocupada
     */
    boolean estado() {
        return ocupada;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
