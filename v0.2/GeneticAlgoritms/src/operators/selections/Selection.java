/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operators.selections;

import operators.Genetic;

/**
 * Class pai que todos os operadoes de selecção vão herdar
 * @author Chorinca-Notebook
 */
public abstract class Selection extends Genetic {
    
    static final int DIMENDIONS_NEW_POPULATION_DEFAULT = 10;
    protected int _dimensionsNewPopulation;
    
}
