package xu.stat.statestix.data.Statistics.probability;

import java.util.Random;

public enum Type {
    MEAN("Mean"),
    MEDIAN("Median"),
    MODE("Mode"),
    PROB("Probability"),
    SD("Standard Deviation"),
    VAR("Variance"),
    RANGE("Range");


    private String desc;
     Type(String desc){
        this.desc = desc;
    }

    public String getTopic() {
        return desc;
    }
    private static final Random PRNG = new Random();

    public static Type randomTopic() {
        Type[] types = values();
        return types[PRNG.nextInt(types.length)];
    }
}
