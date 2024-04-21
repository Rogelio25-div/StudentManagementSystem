package studentManagementSystemm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener , MouseListener {

    JTextField username;
    JPasswordField password;
    JButton login,exit;
    JLabel usernameText, passwordText, loginText, greetingText, greetingText1, SignUp;
    JLabel profilepic;

    JPanel panel;
    login(){


    super("LOGIN");
    getContentPane().setBackground(Color.white);

    LineBorder border = new LineBorder(Color.BLACK, 3);
    Font myFont = new Font("Calibri", Font.BOLD, 35);

    loginText = new JLabel("LOGIN");
    loginText.setBounds(350,35,150,35);
    loginText.setFont(myFont);
    add(loginText);

    greetingText = new JLabel("STUDENT");
    greetingText.setBounds(85,200,150,30);
    greetingText.setFont(new Font("Calibri", Font.BOLD, 20));

    greetingText1 = new JLabel("MANAGEMENT SYSTEM");
    greetingText1.setBounds(25,230,200,30);
    greetingText1.setFont(new Font("Calibri", Font.BOLD, 20));

    /*SignUp = new JLabel("<html><u>Sign Up</u><html>");
    SignUp.setForeground(Color.BLUE);
    SignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    SignUp.setBounds(375,275,150,35);
    SignUp.addMouseListener(this);
    add(SignUp);*/

    username = new JTextField();
    username.setBounds(300,100,195,25);
    username.setFont(new Font("Calibri", Font.BOLD, 16));
    username.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) { // when enter key is press it will move to next textfield
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
    });
    add(username);

    password = new JPasswordField();
    password.setFont(new Font("Calibri", Font.BOLD, 16));
    password.setBounds(300,150,195,25);
    password.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) { // when enter key is press it will move to next textfield
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                password.requestFocus();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
    });
    add(password);

    usernameText = new JLabel("Username:");
    usernameText.setBounds(300,80,150,25);
    usernameText.setFont(new Font("Calibri", Font.BOLD, 18));
    add(usernameText);

    passwordText = new JLabel("Password:");
    passwordText.setBounds(300,130,150,20);
    passwordText.setFont(new Font("Calibri", Font.BOLD, 18));
    add(passwordText);

    login = new JButton("Login");
    login.setFont(new Font("Calibri", Font.BOLD, 18));
    login.setBounds(355,190,80,30);
    login.addActionListener(this::login);
    login.addKeyListener(new KeyListener() {

        @Override
        public void keyPressed(KeyEvent e) {
            String user = username.getText();
            String pass = password.getText();
            if(e.getKeyCode() == KeyEvent.VK_ENTER ){
                if(user.equals("admin") && pass.equals("admin")){
                    login.requestFocus();
                    setVisible(false);
                    new MainPanel();
                }

            }

        }
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
    });
    add(login);

    exit = new JButton("Sign Up");
    exit.setLayout(new BorderLayout());
    exit.setFont(new Font("Calibri", Font.BOLD, 18));
    exit.setBounds(345,230,100,30);
    exit.addActionListener(this::SignUp);
    add(exit);

    ImageIcon loginProf = new ImageIcon(getClass().getResource("icon/school.png"));
    Image profileTow = loginProf.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
    ImageIcon fprofileOne = new ImageIcon(profileTow);
    profilepic = new JLabel(fprofileOne);
    profilepic.setBounds(48,25,150,150);

    panel = new JPanel();
    panel.setBounds(10,10,250,290);
    panel.setBackground(new Color(200,20,32,24));
    panel.setLayout(null);
    add(panel);
    panel.add(profilepic);
    panel.add(greetingText);
    panel.add(greetingText1);

    setSize(550,350);
    setLocation(400,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setVisible(true);
    setResizable(false);
    }

    public static void main(String[] args){
        new login();
    }

    /*public JButton Exit(ActionEvent e){

        int dlt = JOptionPane.showConfirmDialog(this,"Are You sure you want to exit?","Exit", JOptionPane.YES_NO_OPTION);
        if(dlt == 0){
            System.exit(0);
        }else{
            return login;
        }


        return null;
    }*/

    public void SignUp(ActionEvent e){
        setVisible(false);
        new SignUp();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void login(ActionEvent e) {
        String user = username.getText();
        String pass = password.getText();

        if(user.equals("admin") && pass.equals("admin")){
            setVisible(false);
            new MainPanel();
           // JOptionPane.showMessageDialog(null, "Welcome");
        }else if(user.isEmpty() && pass.isEmpty()){
            JOptionPane.showMessageDialog(null, "PLEASE FILL OUT THE USERNAME AND PASS FIELD");
        }else if(user != "admin" || pass != "admin"){
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Inputs");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setVisible(false);
        new SignUp();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        String user = username.getText();
        String pass = password.getText();
        if(e.getKeyCode() == KeyEvent.VK_ENTER && user.equals("admin") && pass.equals("admin")){
            new MainPanel();
            setVisible(false);
        }


    }


    public void keyReleased(KeyEvent e) {

    }

    public class keyEvent implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
