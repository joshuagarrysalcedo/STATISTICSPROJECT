package xu.stat.statestix.data;

public class StatTracker {
    int totalScore;
    int totalAttempt;

    public StatTracker(int totalScore, int totalAttempt) {
        this.totalScore = totalScore;
        this.totalAttempt = totalAttempt;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalAttempt() {
        return totalAttempt;
    }

    public void setTotalAttempt(int totalAttempt) {
        this.totalAttempt = totalAttempt;
    }
}
