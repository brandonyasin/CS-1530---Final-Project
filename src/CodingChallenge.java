import java.util.ArrayList;

public class CodingChallenge{
    public String codingChallenge;//the text for the coding challenge
    public ArrayList<String> hints; //hints for solving the challenge
    public String solution; //the solution to check the student's code's output against
    public String date; //due date of the challenge mm-dd-yy

        public CodingChallenge(String challenge){
            this.codingChallenge = challenge;
            hints = new ArrayList<String>();
        }

        public CodingChallenge(String challenge, String solution){
            this.codingChallenge = challenge;
            this.solution = solution;
            hints = new ArrayList<String>();
        }

        public void addHint(String hint){
            this.hints.add(hint);
        }

        public void addSolution(String solution){
            this.solution = solution;
        }

        //format date in mm-dd-yy before passing to this method
        public void setDueDate(String date){
            this.date = date;
        }

        //this method should take in the output from a student
        //coding solution, and check it against the solution of
        //the coding challenge
        public boolean checkSolution(String studentOutput){
            return studentOutput.equals(solution);
        }

}