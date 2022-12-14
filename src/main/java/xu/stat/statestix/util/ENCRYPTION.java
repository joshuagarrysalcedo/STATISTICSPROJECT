package xu.stat.statestix.util;

import org.mindrot.jbcrypt.BCrypt;

public class ENCRYPTION {
    private ENCRYPTION() {
    }

    public  static String hashPassword(String plainTextPassWord) {
        return BCrypt.hashpw(plainTextPassWord, BCrypt.gensalt());
    }

    public static boolean checkPass(String inputPassword, String hashedPassword) {
        if(BCrypt.checkpw(inputPassword, hashedPassword)) {
            System.out.println("Password correct!");
            return true;
        }else{
            System.out.println("Password incorrect!");
            return false;
        }
    }
}
