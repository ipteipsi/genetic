package GeneticV01;

import java.util.Random;

/* -------------------------------------------------------------------------
 * -------------------------------------------------------------------------
 *  I n s t i t u t o   P o l i t e c n i c o   d e   T o m a r
 *   E s c o l a   S u p e r i o r   d e   T e c n o l o g i a
 *
 * @author Ruben Felix <Ruben.Felix@gmail.com>
 * -------------------------------------------------------------------------
 * Número de Aluno: 13691 
 * E-mail: Ruben.Felix@gmail.com
 * -------------------------------------------------------------------------
 * -------------------------------------------------------------------------
 */
public class Gene <T>{
    
    static final Random random = new Random();
    
    private T value;

    public Gene(T value, int sizeValue) {
        this.value = value;
    
        if(value instanceof Boolean[]){
            Boolean[] arrayBool = new Boolean[sizeValue];
                
            // gerar de forma aleatoria os valores em binario para o array de booleans
            for (int i = 0; i < sizeValue; i++) {
                arrayBool[i] = random.nextBoolean();
            }
            value = (T)arrayBool;
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
