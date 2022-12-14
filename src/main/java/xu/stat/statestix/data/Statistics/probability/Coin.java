package xu.stat.statestix.data.Statistics.probability;

import java.util.HashMap;
import java.util.Map;

public class Coin {

    private Coin(){}
    public static HashMap<Integer, String> map = new HashMap<>();

    static{
        map.put(0, "tails");
        map.put(1, "heads");
    }

}
