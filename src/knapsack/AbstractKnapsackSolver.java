package knapsack;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Abstract solver for kanpsack problem
 *
 * @author tadaki
 */
public abstract class AbstractKnapsackSolver {

    protected List<Item> items;//List of items
    protected int maxWeight;//Capacity
    protected Knapsack knapsack;//Final state of the knapsack
    protected boolean debug = true;
    protected int count;
    protected final String nl = System.getProperty("line.separator");

    /**
     * Constructor
     *
     * @param items List of items
     * @param maxWeight capacity
     */
    public AbstractKnapsackSolver(List<Item> items, int maxWeight) {
        this.items = items;
        this.maxWeight = maxWeight;
        count = 0;
    }

    public AbstractKnapsackSolver() {
    }

    /**
     * Start solving
     *
     * @return knapsack
     * @throws CloneNotSupportedException
     */
    public Knapsack solve() throws CloneNotSupportedException {
        return solveSub(0, maxWeight);
    }

    /**
     * Sub part of solving
     *
     * @param i trying i-th item
     * @param w remaining capacity
     * @return knapsack
     * @throws CloneNotSupportedException
     */
    abstract protected Knapsack solveSub(int i, int w)
            throws CloneNotSupportedException;

    //********** getters and setters *****

    public Knapsack getKnapsack() {
        return knapsack;
    }

    public int getCount() {
        return count;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public void setProblem(List<Item> items, int maxWeight) {
        this.items = items;
        this.maxWeight = maxWeight;
    }

    public void testRun(PrintStream out) 
            throws IOException, CloneNotSupportedException {
        String m = this.getClass().getSimpleName();
        Knapsack kn = solve();
        StringBuilder sb = new StringBuilder();
        sb.append(m).append(":");
        sb.append(kn.toString()).append(nl);
        sb.append("number of update ").append(getCount());
        out.println(sb.toString());
    }

}
