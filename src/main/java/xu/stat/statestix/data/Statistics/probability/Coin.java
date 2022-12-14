package xu.stat.statestix.data.Statistics.probability;

import java.util.HashMap;
import java.util.Map;

public class Coin {

    private Coin(){}
    public static HashMap<String, Integer> event = new HashMap<>();

    public static HashMap<Integer, String> map = new HashMap<>();

    static{
        map.put(0, "Heads");
        map.put(1, "Tails");
        event.put("Heads", 0);
        event.put("Tails", 0);
    }

}
