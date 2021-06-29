package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

public class User implements Serializable {
    private String name;
    private int userID;
    private String email;
    private String hashedPass;
    private boolean admin;

    public User() {
    }

    public User(String name, int userID, String email, String hashedPass, boolean admin) {
        this.name = name;
        this.userID = userID;
        this.email = email;
        this.hashedPass = hashedPass;
        this.admin = admin;
    }

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

    public void setEmail(String email) {
        this.email = email;

    }

    public String getEmail() {
        return this.email;
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

    public String setHashedPass(String pass) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] result = digest.digest(pass.getBytes());
            this.hashedPass = String.format("%040x", new BigInteger(1, result));
            return this.hashedPass;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getHashedPass() {
        return this.hashedPass;

    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        return this.admin;
    }
}
