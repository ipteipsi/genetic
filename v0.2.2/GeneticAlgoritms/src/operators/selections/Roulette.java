package operators.selections;

import genetics.Population;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Ponteiro;
import utils.PopulationUtils;
import utils.exceptions.PonteiroForaDoLimiteException;

/**
 *
 * @author PedroIsi
 */
public class Roulette extends Selection {

    private Population popIn;

    public Population getPopIn() {
        return popIn;
    }
    
    public double getPonteiro() {
        return ponteiro;
    }

    private double ponteiro = 0.0;
    
    public Roulette(){
        this(Selection.DIMENDIONS_NEW_POPULATION_DEFAULT);
    }
    
    //contructor com parametro, dimensão da nova população
    public Roulette(int dimensionsNewPopulation){
        super._dimensionsNewPopulation = dimensionsNewPopulation;
    }
    
    @Override
    public Population execute(Population population) {
        this.popIn=population;
        //criar nova população
        //variavel so de leitura ao ser inicializada 
        final Population newPopulation = 
                new Population(
                    super._dimensionsNewPopulation, 
                    population.getSizeGenome(), 
                    population.getSizeGenotype(),
                    population.getSizeAllelo(),
                    population.getTypePopulation(), 
                    false);
        
        //correr cada individuo da população
        for (int numeroIndividuos = 0; numeroIndividuos < super._dimensionsNewPopulation; numeroIndividuos++) {
            //ponteiro que vai apontar para os individuos, inicialização com ponto aleatorio
            this.ponteiro = Ponteiro.pontoAleatorio(PopulationUtils.getFitnessTotal(population));
            
            try {
                //acrecenta um individou para a nova população
                newPopulation.addIndividual(
                        Ponteiro.devolveIndividuoParaOndeOPonteiroAponta(this.ponteiro, population));
            } catch (PonteiroForaDoLimiteException ex) {
                Logger.getLogger(Roulette.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return newPopulation;
    }
    
    
    public String getInfo(){
        String s = "Método usado para fazer uma selecção de indivíduos a uma população. \n"
                + "Este método tem como parâmetros de entrada o tamanho da nova população,"
                + " isto é, o número de indivíduos a serem seleccionados da população de entrada.";
        return s;
    }
    
    //public set
    
}
