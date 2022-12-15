package xu.stat.statestix.data;

import org.jetbrains.annotations.NotNull;
import xu.stat.statestix.database.UserDB;
import xu.stat.statestix.util.ENCRYPTION;

import java.time.LocalDate;
import java.util.Comparator;

public class User implements Comparable<User>{

    private String email;
    private String firstName;
    private String lastName;
    private double rating;
    private String userID;

    private String password;

    private String hash;



    public User(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = 0.0;
        this.password = password;
        setHash(this.password);
        setUserID();
    }

    public User(String email) {
        this.email = email;
        this.firstName = null;
        this.lastName = null;
        this.rating = 0.0;
        this.password = null;
    }

    public User(String email, double rating) {
        this.email = email;
        this.firstName = null;
        this.lastName = null;
        this.rating = rating;
        this.password = null;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID() {

        //id format YEAR-MONTH-000n
        String year = Integer.toString(LocalDate.now().getYear());
        String month = Integer.toString(LocalDate.now().getMonthValue());
        int users = UserDB.countData("users") + 1;


        this.userID = String.format("%s-%s-%04d", year, month, users);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getHash() {
        return hash;
    }

    public void setHash(String password) {
        this.hash = ENCRYPTION.hashPassword(password);

    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rating=" + rating +
                ", userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }

    public static Comparator<User> COMPARE_BY_RATING = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return Double.compare(o1.getRating(),o2.getRating());
        }
    };

    @Override
    public int compareTo(@NotNull User o) {
        return Double.compare(this.getRating(), o.getRating());
    }
}
