package GeneticV01;

import java.util.ArrayList;

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
public class Cromossoma {
    /**
     * ArrayList de genes que será a definição de um cromossoma
     */
    private ArrayList<Gene> Cromo;

    /**
     * Método que permite retirar um gene em especifico do array de genes que
     * define o cromossoma. Retorna null em caso do arrraylist estar vazio ou
     * em caso de o index especificado ser maior que o número de genes no arraylist
     * @param index (int) - Index do gene a ser retirado 
     * @return (Gene) - Gene do index definido
     */
    public Gene getGene(int index) {
        if((getCromo().isEmpty()) || ((index+1) > getCromo().size())) return null;
        else return getCromo().get(index);
    }
    
    /**
     * Método que permite fazer a definição de um determinado gene especifico do cromossoma
     * @param index (int) - Index a ser utlizado no arraylist
     * @param gene (Gene) - Gene a ser adicionado ao arraylist
     */
    public void setGene(int index, Gene gene) {
        getCromo().add(index, gene);
    }

    /**
     * Método que retorna o arraylist de genes do cromossoma
     * @return Cromo (ArrayList<Gene>) - ArrayList de genes que especifica o cromossoma
     */
    public ArrayList<Gene> getCromo() {
        return Cromo;
    }

    /**
     * Método que permite fazer a definição de uma nova ArrayList para o cromossoma
     * @param Cromo (ArrayList<Gene>) - ArrayList de genes a ser especificado para o cromossoma
     */
    public void setCromo(ArrayList<Gene> Cromo) {
        this.Cromo = Cromo;
    }
}
