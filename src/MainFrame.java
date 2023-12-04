
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JLabel textLabel;
    JLabel helloLabel; // label for printing hello + name
    JTextField tfName; // text field for name

    public void initialize() {

        /**************************** Welcome Pannel *********************/
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        textLabel = new JLabel(
                "Welcome to CodeCraft Academy! To get started, please enter your name and select a role.",
                JLabel.CENTER);
        textLabel.setFont(mainFont);

        /****************** Hello Pannel: Allows User to enter name *******************/
        JLabel lbName = new JLabel("First Name");
        lbName.setFont(mainFont);
        tfName = new JTextField();
        tfName.setFont(mainFont);

        formPanel.add(textLabel);
        formPanel.add(lbName);
        formPanel.add(tfName);

        helloLabel = new JLabel();
        helloLabel.setFont(mainFont);

        /***************************** Buttons Pannel *******************/
        JButton studentButton = new JButton("Student");
        studentButton.setFont(mainFont);
        studentButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You've selected the student role!");
                /******************* Student Logic **********************/
            }

        });

        JButton educatorButton = new JButton("Educator");
        educatorButton.setFont(mainFont);
        educatorButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                /******************* Educator Logic **********************/
                String name = tfName.getText();
                helloLabel.setText("Hello " + name + ", you've selected the educator role!");

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
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Welcome to CodeCraft Academy!");
        setSize(1000, 300);
        setMinimumSize(new DimensionUIResource(100, 100));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}
