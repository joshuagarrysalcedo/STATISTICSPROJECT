package xu.stat.statestix.data;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class RatingList {
    private SimpleStringProperty name;
    private SimpleDoubleProperty rating;

    public RatingList(String name, double rating) {
        this.name = new SimpleStringProperty(name);
        this.rating = new SimpleDoubleProperty(rating);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public double getRating() {
        return rating.get();
    }

    public SimpleDoubleProperty ratingProperty() {
        return rating;
    }
}
