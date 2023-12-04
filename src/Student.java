import java.util.ArrayList;

public class Student{
    String username;
    String password;
    ArrayList<CodingChallenge> progress;

    public Student(String name){
        username = name;
        password = "password";
        progress = new ArrayList<CodingChallenge>();
    }
}