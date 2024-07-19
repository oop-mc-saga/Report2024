package knapsack;

import java.util.HashSet;
import java.util.Set;

/**
 * Knapsack class
 *
 * @author tadaki
 */
public class Knapsack implements Cloneable, Comparable<Knapsack> {

    private Set<Item> items;//Collected items
    private int value;//Total value
    private int weight;//Total weight

    public Knapsack() {
        items = new HashSet<>();
        value = 0;
        weight = 0;
    }

    /**
     * Add a good
     *
     * @param g
     */
    public void addItem(Item g) {
        if (items.contains(g)) {
            return;
        }
        items.add(g);
        value += g.value();
        weight += g.weight();
    }

    public Set<Item> getItems() {
        return items;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        items.stream().forEachOrdered(g -> {
            sb.append(g.label()).append(" ");
        });
        sb.append("] v=").append(value).append(" w=").append(weight);
        return sb.toString();
    }

    public boolean contains(Item g) {
        return items.contains(g);
    }

    public boolean remove(Item g) {
        if (items.contains(g)) {
            value -= g.value();
            weight -= g.weight();
        }
        return items.remove(g);
    }

    @Override
    public int compareTo(Knapsack o) {
        return this.value-o.value;
    }

    @Override
    /**
     * Cloning this instanse
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Knapsack clone() throws CloneNotSupportedException {
        Knapsack r = (Knapsack) super.clone();
        r.items = new HashSet<>();
        items.stream().forEachOrdered(g -> {
            r.items.add(g);
        });
        r.value = value;
        r.weight = weight;
        return r;
    }

}
