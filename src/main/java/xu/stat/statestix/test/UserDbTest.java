package xu.stat.statestix.test;

import org.junit.Test;
import xu.stat.statestix.data.User;
import xu.stat.statestix.database.UserDB;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserDbTest {

    private String username = "Garry";
    private String email = "Zion@gmail.com";
    private String firstName = "Joshua";
    private String lastName = "GGGGG";
    private String password = "1234";

    User user = new User(username, email, firstName, lastName, password);

//
//    @Test //passed! ✅
//    public void toStringTest() {
//        String toStringExpected = "username: swaswa email: swaswa@gmail.com\nfirstName: Joshua lastName: Salcedo\nRating: 0.00%";
//        String toStringResult = user.toString();
//        assertEquals(toStringExpected, toStringResult);
//        assertEquals("2022-12-0002", user.getUserID());
//        System.out.println(user.getUserID());
//    }
//
//
//    @Test//passed! ✅
//    public void relativePathTest(){
//         String directory = System.getProperty("user.dir");
//         String jdbcURL = String.format("jdbc:sqlite:/%s\\db\\statestixdb.db", directory);
//         System.out.println(jdbcURL);
//         assertEquals("jdbc:sqlite:/F:\\IMPORTANT\\STATESTIX_Final\\Statestix\\db\\statestixdb.db", jdbcURL);
//    }
//
//    @Test//passed! ✅
//    public void dbConnectionTest() throws SQLException {
//        UserDataBase userDataBase = new UserDataBase();
//        assertThat(userDataBase.getConnection(), instanceOf(Connection.class));
//    }

    @Test//passed! ✅
    public void countNumberOfRecordsTest() {

        assertEquals(1, UserDB.countData("users"));
    }

    @Test//passed!
    public void addUsersTest() {
        System.out.println(user);
        assertTrue(UserDB.addUser(user));
    }

    @Test//passed!
    public void doesItExistsTest() {
        assertTrue(UserDB.doesItExists(user));
    }

    @Test
    public void updateUserDetailsTest(){
        assertTrue(UserDB.updateUserDetails("users", "email", "juantaklob@gmail.com", "2022-12-0001"));
    }

    @Test
    public void updateRatingTest() {
        //assertFalse(userDB.updateRating(50, "12321"));
        assertTrue(UserDB.updateRating(50, "2022-12-0001"));
    }

    @Test
    public void authenticationTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
        assertTrue(UserDB.authenticateLogIn("juantaklob@gmail.com", "1234"));
    }

    @Test
    public void testRetrieveData() {
        System.out.printf("Result: 2022-12-0001\nExpected: %s", UserDB.retrieveData("juantaklob@gmail.com", "id"));
        assertEquals("2022-12-0001", UserDB.retrieveData("juantaklob@gmail.com", "id"));
    }
}
