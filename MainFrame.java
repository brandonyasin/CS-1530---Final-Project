
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JLabel lbWelcome;
    JLabel textLabel;

    public void initialize() {

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        textLabel = new JLabel("Welcome to CodeCraft Academy! To get started, please select a role.", JLabel.CENTER);
        textLabel.setFont(mainFont);
        formPanel.add(textLabel);

        /************************** Welcome Label ************************/
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        /***************************** Buttons Pannel *******************/
        JButton studentButton = new JButton("Student");
        studentButton.setFont(mainFont);
        studentButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You've selected the student role!");
            }

        });

        JButton educatorButton = new JButton("Educator");
        educatorButton.setFont(mainFont);
        educatorButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You've selected the educator role!");
            }

        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(studentButton);
        buttonsPanel.add(educatorButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(13, 70, 135));
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(lbWelcome, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Welcome to CodeCraft Academy!");
        setSize(450, 450);
        setMinimumSize(new DimensionUIResource(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}
