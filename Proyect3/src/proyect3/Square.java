package proyect3;


/*
 * CLASE Casilla
 */
public class Square implements Cloneable{
    
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
