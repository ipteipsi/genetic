/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetics.algorithms.functions;

import genetics.Individual;
import genetics.Population;
import genetics.Solver;
import genetics.StopCriterion;
import genetics.algorithms.FunctionReal;
import java.util.ArrayList;
import operators.Operator;
import operators.mutation.MutationGaussian;
import operators.recombinations.CrossoverAX;
import operators.replacements.Truncation;
import operators.selections.SUS;
import utils.Benchmark;
import utils.EventsSolver;
import utils.PopulationUtils;
import utils.exceptions.SolverException;

/**
 *
 * @author Pedro Isidoro
 */
public class FunctionRealFractalDoubleDip extends FunctionReal {

//    public static void main(String[] args) throws SolverException {
//        ArrayList<Operator> operators = new ArrayList<Operator>(4);
//        Solver solver;
//
//        operators.add(new SUS(10));
//        operators.add(new CrossoverAX(0.75));
//        operators.add(new MutationGaussian(0.25));
//        operators.add(new Truncation());
//
//        solver = new Solver(
//                new Population(10, 1, 2, 0,
//                new FunctionRealFractalDoubleDip()),
//                new StopCriterion(-450.0, 1, 2, StopCriterion.TYPE_PROBLEM_MINIMIZATION),
//                operators,
//                new EventsSolver() {
//
//                    @Override
//                    public void EventStartSolver() {
//                         throw new UnsupportedOperationException("Not supported yet.");
//                    }
//
//                    @Override
//                    public void EventIteraction(int iteractionNumber, Population currentPopulation) {
//                        if((iteractionNumber % 1000) == 0) {
//                            FunctionRealFractalDoubleDip x = (FunctionRealFractalDoubleDip)PopulationUtils.getHallOfFame(currentPopulation, 1).getIndividual(0);
//                            System.out.println("X: " + x.getVariavel(0) + "\tY: " + x.getVariavel(1) + "\tW: " + x.fitness());
//                        }
//                    }
//
//                    @Override
//                    public void EventFinishSolver(int totalIteracoes, Population lastPopulation) {
//                         FunctionRealFractalDoubleDip x = (FunctionRealFractalDoubleDip)PopulationUtils.getHallOfFame(lastPopulation, 1).getIndividual(0);
//                         System.out.println("X: " + x.getVariavel(0) + "\tY: " + x.getVariavel(1) + "\tW: " + x.fitness());                        
//                        System.out.println("------");
//                        System.out.println(lastPopulation.toString());
//                    }
//                });
//
//        solver.run();
//    }
    
    public FunctionRealFractalDoubleDip() {
        super(new double[]{-1, -1 }, new double[]{1, 1}, "");
    }

    public FunctionRealFractalDoubleDip(FunctionRealFractalDoubleDip function) {
        super(function);
    }

    @Override
    public double fitness() {
        double[] __variavels = new double[this._beginDomains.length];
        double __fitness;
        
        for (int i = 0; i < this._beginDomains.length; i++) {
            __variavels[i] = this.getVariavel(i);
        }

        __fitness = 0;
        
        for (int i = 0; i < __variavels.length; i++) {
            __fitness += fractal1D(
                    __variavels[i] + twist(__variavels[(i % (__variavels.length-1)) + 1]), 
                    0.0, 
                    1.0);        
        }
        
        return  __fitness;
    }
    
    public double fractal1D(double point, double centre, double scale) {
        double depth = 0.0D;

        double x = (point - centre) / scale;
        if ((x > -0.5D) && (x < 0.5D)) {
            double xs = 4.0D * x * x;
            depth = (-96.0D * xs * xs * xs + 193.0D * xs * xs - 98.0D * xs + 1.0D) * scale;
        }
        return depth;
    }
    
    public double twist(double y) {
        double dx;
        y %= 1.0D;
        double ys = y * y;

        dx = 4.0D * (ys * ys - 2.0D * ys * y + ys);
        return dx;
    }
    
    @Override
    public Individual clone() {
        return new FunctionRealFractalDoubleDip(this);
    }
    
    @Override
    public String getInfo() {
        return "<p>Function Real Fractal Double Dip Best Fitness - -450.0</p>"
                + "<p>Default Stop Criteria: -450.0, 1, 2, 1</p>";
    }
}
