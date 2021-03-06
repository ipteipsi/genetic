package utils;

import genetics.Individual;
import java.util.Comparator;

/**
 *
 * @author Chorinca-Notebook
 */
public class ComparatorIndividual implements Comparator<Individual> {

    @Override
    public int compare(Individual o1, Individual o2) {
        int fitnessO1 = o1.fitness();
        int fitnessO2 = o2.fitness();
        
        if(fitnessO1 < fitnessO2)
            return 1;
        else if(fitnessO1 >  fitnessO2)
            return -1;
        else {
            if(o1.toString().equals(o2.toString()))
                return 0;
            else
                return 1;
        }  
    }
    
}
