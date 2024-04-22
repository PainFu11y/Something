package model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class User {
    private String login;
    private String password;

    public User(String loginAndPassword) throws Exception{
        Files.write(Path.of("base.txt"), loginAndPassword.getBytes(), StandardOpenOption.APPEND);
    }
}
