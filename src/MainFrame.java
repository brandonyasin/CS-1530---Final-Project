
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JLabel textLabel;
    JLabel helloLabel; // label for printing hello + name
    JTextField tfName; // text field for name
    JLabel lbChallenge; // label for coding challenge
    Educator educator; // educator object to call the educator methods on
    Student student; // student object to call the student methods on
    ArrayList<CodingChallenge> challenges;

    public void initialize() {

        /**************************** Fetching Stored Challenges *********************/
        challenges = fetchCodingChallenges();
        // everytime the program is launched, challenges are read in from the file.

        /**************************** Welcome Pannel *********************/
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        textLabel = new JLabel(
                "Welcome to CodeCraft Academy! To get started, please enter your name and select a role.",
                JLabel.CENTER);
        textLabel.setFont(mainFont);

        /****************** Hello Label: Allows User to enter name *******************/
        JLabel lbName = new JLabel("First Name");
        lbName.setFont(mainFont);
        tfName = new JTextField();
        tfName.setFont(mainFont);

        formPanel.add(textLabel);
        formPanel.add(lbName);
        formPanel.add(tfName);

        helloLabel = new JLabel();
        helloLabel.setFont(mainFont);

        /************************* Coding Challenge Label *****************/
        lbChallenge = new JLabel();
        lbChallenge.setFont(mainFont);

        /***************************** Buttons Pannel *******************/
        JButton studentButton = new JButton("Student");
        studentButton.setFont(mainFont);
        studentButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("You've selected the student role!");
                /******************* Student Logic **********************/
                String name = tfName.getText();
                student = new Student(name);
                helloLabel.setText("Hello " + name + ", you've selected the student role!");
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to view your Coding Challenge?",
                        "View Challenges",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (ans == JOptionPane.YES_OPTION) {
                    student.progress.add(new CodingChallenge("Temp Challenge 1"));
                    lbChallenge.setText("Coding challenge: " + student.progress.get(0).codingChallenge);
                }
            }

        });

        JButton educatorButton = new JButton("Educator");
        educatorButton.setFont(mainFont);
        educatorButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                /******************* Educator Logic **********************/

                String name = tfName.getText();
                educator = new Educator(name, challenges);
                helloLabel.setText("Hello " + name + ", you've selected the educator role!");
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to add a Coding Challenge?",
                        "Create Challenge",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (ans == JOptionPane.YES_OPTION) { // might want to change this to yes or no buttons to click on
                    String text = JOptionPane.showInputDialog("Please write a coding challenge: ");
                    // we can use challenge to initialize a CodingChallenge object
                    CodingChallenge challenge = new CodingChallenge(text);
                    try {
                        writeCodingChallenge(text);
                    } catch (Exception ex) {
                        // ??
                    }
                    educator.addChallenge(challenge);
                    lbChallenge.setText("Coding challenge: " + text);
                }

            }

        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(studentButton);
        buttonsPanel.add(educatorButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(formPanel.getBackground());
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(helloLabel, BorderLayout.CENTER);
        mainPanel.add(lbChallenge);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Welcome to CodeCraft Academy!");
        setSize(1000, 300);
        setMinimumSize(new DimensionUIResource(100, 100));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static boolean writeCodingChallenge(String challenge) throws IOException {
        FileWriter fw = new FileWriter("Challenges.txt", true); // append is true so that we dont overwrite coding
                                                                // challenges
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(challenge + "\n");
        bw.close();
        return true;
    }

    public static ArrayList<CodingChallenge> fetchCodingChallenges() {
        ArrayList<CodingChallenge> challs = new ArrayList<CodingChallenge>();
        try {
            File myFile = new File("Challenges.txt");
            Scanner fileScan = new Scanner(myFile);
            while (fileScan.hasNextLine()) {
                String challenge = fileScan.nextLine();
                CodingChallenge newChall = new CodingChallenge(challenge);
                challs.add(newChall);

            }
            fileScan.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return challs;

    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}
