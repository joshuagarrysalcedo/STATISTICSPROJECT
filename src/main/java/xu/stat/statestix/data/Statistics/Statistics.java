package xu.stat.statestix.data.Statistics;

import xu.stat.statestix.data.Question;

public abstract class Statistics {
    private String subject;
    private String description;

    public Statistics() {
    }

    public Statistics(String subject, String description) {
        this.subject = subject;
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
