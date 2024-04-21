package studentManagementSystemm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {

    JTextField username, password;
    JPasswordField conPassword;
    JLabel usertext, passtext, conpasstext , profilepic, createAccText, SignupText;
    JPanel panel;

    JButton Create, Back;

    SignUp(){
        super("Sign Up");
        getContentPane().setBackground(Color.white);

        ImageIcon loginProf = new ImageIcon(getClass().getResource("icon/sign-up.png"));
        Image profileTow = loginProf.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTow);
        profilepic = new JLabel(fprofileOne);
        profilepic.setBounds(48,25,150,150);

        SignupText = new JLabel("SIGN UP");
        SignupText.setBounds(45,35,150,35);
        SignupText.setFont(new Font("Calibri", Font.BOLD, 35));
        add(SignupText);

        username = new JTextField();
        username.setBounds(35,100,150,20);
        add(username);

        password = new JTextField();
        password.setBounds(35,150,150,20);
        add(password);

        conPassword = new JPasswordField();
        conPassword.setBounds(35,200,150,20);
        add(conPassword);

        usertext = new JLabel("Username:");
        usertext.setBounds(35,80,150,20);
        add(usertext);

        passtext = new JLabel("Password:");
        passtext.setBounds(35,130,150,20);
        add(passtext);

        conpasstext = new JLabel("Confirm Password:");
        conpasstext.setBounds(35,180,150,20);
        add(conpasstext);

        createAccText = new JLabel("Create Account");
        createAccText.setFont(new Font("Calibri", Font.BOLD, 25));
        createAccText.setBounds(50,200,180,25);
        add(createAccText);

        Create = new JButton("Create");
        Create.setBounds(35,250,75,20);
        add(Create);

        Back = new JButton("Back");
        Back.setBounds(115,250,70,20);
        Back.addActionListener(this::Back);
        add(Back);

        panel = new JPanel();
        panel.setBounds(220,10,250,290);
        panel.setBackground(new Color(200,20,32,24));
        panel.add(profilepic);
        panel.add(createAccText);
        add(panel);
        panel.setLayout(null);

        setSize(500,350);
        setLocation(400,300);
        setLayout(null);
        setVisible(true);
        setResizable(false);

    }

    public void Back(ActionEvent e) {
        setVisible(false);
        new login();
    }
    public static void main(String[] args){
        new SignUp();
    }
}
