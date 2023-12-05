import java.util.ArrayList;

public class Educator{
    String username; // Educator's username
    String password; // Educator's password
    ArrayList<Student> roster; // Educator's roster (List of Students)
    ArrayList<CodingChallenge> challenges; // Educator's challenges (List of CodingChallenges)

    public Educator(String name){
        username = name;
        password = "password"; // We don't need anything fancy for login details so password will just be this by default

        // These lists will stay empty by default so we can keep better track of everything we add in
        roster = new ArrayList<Student>();
        challenges = new ArrayList<CodingChallenge>();
    }

    public Educator(String name, ArrayList<CodingChallenge> challenges){
        this(name);
        this.challenges = challenges;
    }

    // Adds a Student to the Educator's roster
    public void addStudent(Student s){
        roster.add(s);
    }

    // Adds a CodingChallenge to the Educator's list of challenges
    public void addChallenge(CodingChallenge c){
        // I am assuming that we will create the challenges ahead of time. If not, this can just be changed to accept no arguments.
        challenges.add(c);
    }

    // This is supposed to let the Educator edit the Challenge that they pass in as an argument (???)
    public void editChallenge(CodingChallenge c){
        
    }

    // Since we don't have any code relating to Progress, these methods don't exist

    // Returns the Progress of a given Student
    // public Progress viewGrades(Student s){

    // }

    // Resets the Progress of a given Student
    // public void resetStudentProgress(Student s){

    // }
}