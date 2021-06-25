package model;

import java.util.Scanner;

public class User {
    private String name;
    private int userID;
    private String hashedPass;
    private boolean admin = false;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    public int getUserID(){
        return this.userID;
    }
    public void setHashedPass(){
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        
    }


    
}
