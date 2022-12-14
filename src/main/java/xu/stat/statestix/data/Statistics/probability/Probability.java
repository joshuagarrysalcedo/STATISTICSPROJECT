package xu.stat.statestix.data.Statistics.probability;

import xu.stat.statestix.data.Statistics.Statistics;

public abstract class Probability extends Statistics {
    private int numberOfObjects;
    private OBJECT object;
    private int numberOfEvents;
    private int condition;
    private double probability;

    public Probability() {
        setSubject("Probability");
        setDescription("A probability is a number that reflects the chance or likelihood that a particular event will occur. ");
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
