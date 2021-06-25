package model;

import java.security.MessageDigest;
import java.math.BigInteger;

public class LoginLogic {
    public boolean execute(User user, String inputPass) {
        String hashedInputPass = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] result = digest.digest(inputPass.getBytes());
            hashedInputPass = String.format("%040x", new BigInteger(1, result));

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user.getHashedPass().equals(hashedInputPass)) {
            return true;
        } else {
            return false;
        }
    }

}
