package xu.stat.statestix.data.Statistics;

public class Permutation extends Statistics{
    private int num;
    private int num2;

    public Permutation() {
        super();
        setSubject("Permutation");
        setDescription("The term permutation refers to a mathematical calculation of the number of ways a particular set can be arranged. ");
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Permuntation{" +
                "num=" + num +
                ", num2=" + num2 +
                '}';
    }

    public int sum(int num1 , int num2) {
        return num1 + num2;
    }
}
