package knapsack;

import java.util.List;
/**
 * Solving by dynamical programming
 *
 * @author tadaki
 */
public class DynamicalProgramming extends AbstractKnapsackSolver {

    protected Knapsack[][] q;

    public DynamicalProgramming(List<Item> items, int maxWeight) {
        super(items, maxWeight);
        q = new Knapsack[items.size() + 1][maxWeight + 1];
        for (int i = 0; i < items.size() + 1; i++) {
            for (int j = 0; j < maxWeight + 1; j++) {
                q[i][j] = null;
            }
        }
    }

    public DynamicalProgramming() {
        super();
    }

    @Override
    public void setProblem(List<Item> items, int maxWeight) {
        super.setProblem(items, maxWeight);
        q = new Knapsack[items.size() + 1][maxWeight + 1];
        for (int i = 0; i < items.size() + 1; i++) {
            for (int j = 0; j < maxWeight + 1; j++) {
                q[i][j] = null;
            }
        }

    }

    @Override
    protected Knapsack solveSub(int i, int w) throws CloneNotSupportedException {

        




        
    }

}
