package xu.stat.statestix.data.Statistics.probability;

public enum OBJECT {
    Dice(6),
    Cards(52),
    Coin(2),
    ;
    private int val;

    OBJECT(int i) {
        this.val = i;
    }
    public int getVal(){
     return val;
    }
}
