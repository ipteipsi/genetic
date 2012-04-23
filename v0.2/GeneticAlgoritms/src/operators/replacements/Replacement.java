/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operators.replacements;

import genetics.Population;
import operators.Operator;

/**
 * Class pai que todos os operadoes de replacement vão herdar
 * @author Chorinca-Notebook
 */
public abstract class Replacement extends Operator {
 
    static final int DIMENDIONS_NEW_POPULATION_DEFAULT = 10;
    protected int dimensionsNewPopulation;
    
    public abstract Population execute(Population parents, Population sons);

}
