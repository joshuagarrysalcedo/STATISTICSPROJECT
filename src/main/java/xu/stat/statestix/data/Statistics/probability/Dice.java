package xu.stat.statestix.data.Statistics.probability;

import java.util.HashMap;

public class Dice {

    private Dice(){}
    public static HashMap<String, Integer> map = new HashMap<>();

    static{
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
    }
}
