package com.exam.helper;

public class UserFoundException extends Exception{
    public UserFoundException(){
        System.out.println("User with this username is FOUND in DataBase !! Try with Different Username");
    }
    public UserFoundException(String msg){
        super(msg);
    }
}
