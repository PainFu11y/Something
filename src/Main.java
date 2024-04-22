import model.User;
import service.FileService;
import service.UserService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] data = FileService.read("base.txt");
        Scanner sc = new Scanner(System.in);
        boolean isActive = true;
        while (isActive){
            System.out.println("0.Print all users");
            System.out.println("1.Create a new user");
            System.out.println("2.Enter with login and password");
            System.out.println("3.Find user with login");
            System.out.println("4.Go out");
            String choice = sc.next();
            switch (choice){
                case "0":
                    data = FileService.read("base.txt");
                    System.out.println(Arrays.toString(data)); break;
                case "1":UserService.create(); break;
                case "2":UserService.enter(); break;
                case "3":UserService.find();break;
                case "4":isActive=false;
                    System.out.println("See you next time user"); break;
                default:
                    System.out.println("!!! Incorrect input !!!");
            }
        }

    }
}