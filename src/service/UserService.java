package service;

import model.User;

import java.util.Objects;
import java.util.Scanner;

public class UserService {
    public User[] convert(String [] data) throws Exception {
        User[] user = new User[data.length];
        for (int i = 0; i < data.length; i++) {
            user[i] = new User(data[i]);
        }
        return user;
    }

    public static User create() throws Exception {
        Scanner sc = new Scanner(System.in);
        String login,password;
        boolean firstEnter = true;
        do {
            if(!firstEnter) System.out.println("!!! Error !!!\nYour login is invalid");
            System.out.println("Enter the login (login can't start with number and must be longer than 3 characters!!!)");
            login = sc.next();
            firstEnter = false;
        }while (login.length() < 8 || Character.isDigit(login.charAt(0)));
        firstEnter = true;
        do {
            if(!firstEnter) System.out.println("!!! Error !!!\nYour password is invalid");
            System.out.println("Enter the password (password must be longer than 8 characters) ");
            password = sc.next();
            firstEnter = false;
        }while (password.length() < 8);
        return new User(login+":"+password+"\n");
    }

    public static void enter() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the login");
        String enteredLogin = sc.next();
        System.out.println("Enter the password");
        String enteredPassword = sc.next();
        String[] base = FileService.read("base.txt");
        for (String s : base) {
            String [] split = s.split(":");
            String login = split[0];
            String password = split[1];

            if (Objects.equals(login, enteredLogin) && Objects.equals(password, enteredPassword)){
                System.out.println("---------------------\nWelcome user " + login+"\n---------------------");
                return;
            }
        }
        System.out.println("User not found :/");
    }

    public static void find() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the login");
        String enteredLogin = sc.next();
        String[] base = FileService.read("base.txt");
        boolean isFind = false;
        for (String s: base) {
            String [] split = s.split(":");
            String login = split[0];
            if(login.toUpperCase().contains(enteredLogin.toUpperCase())){
                System.out.println(s);
                isFind = true;
            }
        }
        if(!isFind) System.out.println("User not found :/");
    }
}
