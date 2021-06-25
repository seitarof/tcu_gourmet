package model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Scanner;
import java.math.BigInteger;

public class User implements Serializable {
    private String name;
    private int userID;
    private String hashedPass;
    private boolean admin = false;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setHashedPass() {
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] result = digest.digest(pass.getBytes());
            this.hashedPass = String.format("%040x", new BigInteger(1, result));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getHashedPass() {
        return this.hashedPass;

    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean idAdmin() {
        return this.admin;
    }
}
