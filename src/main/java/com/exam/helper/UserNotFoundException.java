package com.exam.helper;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        System.out.println("User with this username is NOT FOUND in DataBase");
    }
    public UserNotFoundException(String msg){
        super(msg);
    }
}
