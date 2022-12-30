package xu.stat.statestix.database;

import javafx.fxml.Initializable;
import xu.stat.statestix.data.User;
import xu.stat.statestix.util.ENCRYPTION;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserDB implements Initializable {

    private UserDB(){}
    private static final String directory = System.getProperty("user.dir");
    private static final String jdbcURL = String.format("jdbc:sqlite:/%s/src/main/resources/statestixdb.db", directory);
    private static Connection connection = null;

    //returns the connection of the database!
    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(jdbcURL);
        return connection;
    }

    //add user to the database!
    public static boolean addUser(User user) {
        if(!doesItExists(user)){
            try {
                connection = getConnection(); //db connection
                connection.setAutoCommit(false);
                String sql = "INSERT INTO users(id, email, fname, lname, rating, hash) VALUES(?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, user.getUserID());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getFirstName());
                statement.setString(4, user.getLastName());
                statement.setDouble(5, user.getRating());
                statement.setString(6, user.getHash());
                statement.executeUpdate();

                connection.commit();
                return true;
            } catch (SQLException e) {
                try{
                    connection.rollback();
                    System.err.println(e.getMessage());
                }catch (SQLException e1){
                    System.out.println("Problem with rolling back");
                }finally {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                e.printStackTrace();
                return false;
            }
        }else{
            System.out.println("User already exist!");
            return false;
        }

    }

    //count number of data in a database;
    public static int countData(String tableName) {
        int count = 0;
        try {
            connection = getConnection();
            String sql = String.format("SELECT COUNT(*) FROM %s", tableName);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            rs.next();
            count = rs.getInt(1);
            System.out.println("total records: " + count);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    //check if user exists in the database
    public static boolean doesItExists(User user){
        try {
            connection = getConnection();
            String sql = "SELECT COUNT(*) as found FROM users WHERE email LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getEmail());

            ResultSet rs = statement.executeQuery();
            rs.next();
            boolean result = rs.getBoolean(1);
            connection.close();
            return result;

        } catch (SQLException e) {
            System.out.println("Something went wrong checking!");
            throw new RuntimeException(e);
        }
    }

    //update details of the user value to the table
    public static boolean updateUserDetails(String tableName, String field, String newValue, String id) {
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            String sql = String.format("UPDATE %s SET %s = ? WHERE id = ?", tableName, field);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newValue);
            statement.setString(2, id);
            statement.executeUpdate();


            connection.commit();

            System.out.println("Update success!");
            return true;

        } catch (SQLException e) {
            System.out.println("Update Fail!!");
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }


    //updatesRating on the DB
    public static boolean updateRating(double newValue, String id) {
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            String sql = String.format("UPDATE users SET rating = ? WHERE id = ?");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, newValue);
            statement.setString(2, id);
            statement.executeUpdate();

            connection.commit();
            connection.close();
            System.out.println("Rating update success!");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //log in attempt!
    public static boolean authenticateLogIn(String inputEmail, String inputPassword) {
        User user = new User(inputEmail);
        if(doesItExists(user)) {
            try{
                connection = getConnection();
                String originalHash = retrieveData(inputEmail, "hash");

                return ENCRYPTION.checkPass(inputPassword, originalHash);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else{
            System.out.println("user is not registered!");
            return false;
        }

    }

    // retrieve data from the table
    public static String retrieveData(String email, String field) {
        User user = new User(email);
        if(doesItExists(user)){
            try{
                connection = getConnection();
                String sql = String.format("SELECT %s FROM users WHERE email = ?", field);
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, email);
                ResultSet rs = statement.executeQuery();
                while(rs.next()) {
                    return rs.getString(1);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("user does not exists!");
        }
        return null;
    }

    public static ArrayList<User>  retrieveData() {
        String fname = "";
        String lname = "";
        String name = "";
        double rating= 0.0;
        ArrayList<User> user = new ArrayList<>();
            try{
                connection = getConnection();
                String sql = String.format("SELECT fname, lname, rating from users");
                PreparedStatement statement = connection.prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while(rs.next()) {
                    fname  = rs.getString(1);
                    lname = rs.getString(2);
                    rating = rs.getDouble(3);
                    user.add(new User(fname + " " + lname, rating));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
