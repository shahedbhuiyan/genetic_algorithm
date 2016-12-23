import java.util.Arrays;

/**
 * Created by systemdown on 24/12/16.
 */
public class Chromosome {
    private boolean isFitnessChanged = true;
    private int[] genes;
    private int fitness = 0;
    public Chromosome(int length){
        genes = new int[length];
    }

    public Chromosome initializeChromosome(){
        for(int x = 0; x<genes.length; x++){
            if(Math.random() >= 0.5){
                genes[x] = 1;
            } else {
                genes[x] = 0;
            }
        }
        return this;
    }

    public int[] getGenes(){
        isFitnessChanged = true;
        return genes;
    }

    public int getFitness(){
        if(isFitnessChanged){
            fitness = recalculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    public int recalculateFitness(){
        int chromosomeFitness = 0;
        for(int x = 0; x<genes.length; x++){
            if(genes[x] == GeneticAlgorithm.TARGET_CHROMOSOME[x]) chromosomeFitness++;
        }
        return chromosomeFitness;
    }

    public String toString(){
        return Arrays.toString(this.genes);
    }
}
