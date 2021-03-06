package genetics.algorithms;

import genetics.Chromosome;
import genetics.Gene;
import genetics.Individual;
import genetics.Population;

public class OnesMax extends Individual {

    //*********************************************************************************
    //*****************************Métodos para Reflection*****************************
    //*********************************************************************************
    @Override
    public String getInfo() {
        return new String("Problema do tipo OnesMax. **Descrição do problema e prametros** ");
    }

    @Override
    public boolean setParameters(String parameters) {
        return false;
    }    
    
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
    
    public OnesMax() {
        
    }
    
    public OnesMax(OnesMax newOnesMax){
        super(newOnesMax);
    }
    
    public OnesMax(Individual newIndividual){
        super(newIndividual);
    }
    
    @Override
    public int fitness() {
        int __numberOfOnes = 0;
        for (Chromosome __chromosome : this) {
            for (Gene<Boolean[]> __gene : __chromosome) {
//                System.out.println("" + __gene.getAllele().length);
                for (int __indexAlleloValue = 0; __indexAlleloValue < __gene.getAllele().length; __indexAlleloValue++) {
                    if ( __gene.getAllele()[__indexAlleloValue]) {
                        __numberOfOnes++;
                    }
                }
            }
        }
        return __numberOfOnes;
    }
    
    @Override
    public Boolean[] inicializationAllelo() {
        Boolean[] __allelo = new Boolean[super.getSizeAllelo()];  
        
        // gerar de forma aleatoria os valores em binario para o allelo
        for (int __indexAllelo = 0; __indexAllelo < super.getSizeAllelo(); __indexAllelo++) {
            __allelo[__indexAllelo] = Population.RANDOM_GENERATOR.nextBoolean();
        }
        
        return __allelo;
    }
    
    @Override
    public Individual clone(){
        return new OnesMax(this);
    }
    
//    @Override
//    public int compareTo(Object o) {
//        if(this.fitness() < ((OnesMax)o).fitness()) return -1;
//        else if(this.fitness() == ((OnesMax)o).fitness()) return 0;
//        else return 1;
//    }

}
