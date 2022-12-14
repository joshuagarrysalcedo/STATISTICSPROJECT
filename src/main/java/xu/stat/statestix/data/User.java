package xu.stat.statestix.data;

import xu.stat.statestix.util.ENCRYPTION;

import java.time.LocalDate;

public class User {
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private double rating;
    private String userID;

    private String password;

    private String hash;



    public User(String userName, String email, String firstName, String lastName, String password) {
        this.userName = userName;
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
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        int users = DATA_BASE.countData("users") + 1;


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
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rating=" + rating +
                ", userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
