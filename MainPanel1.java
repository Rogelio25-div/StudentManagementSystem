package studentManagementSystemm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel1 extends JFrame implements ActionListener {


    JLabel text;

    MainPanel1(){
        super("Testing");
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        JMenuBar menuBar= new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("Calibre", Font.BOLD, 15));

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setFont(new Font("Calibre", Font.BOLD, 15));
        Exit.addActionListener(this::Exit);

        JMenuItem loginPage = new JMenuItem("coffeShop.Login Page");
        loginPage.setFont(new Font("Calibre", Font.BOLD, 15));
        loginPage.addActionListener(this:: BacktoLoginPage);


        menu.add(Exit);
        menu.add(loginPage);

        text = new JLabel("UG AKO NALANG DIAY??");
        text.setBounds(50,50,200,200);
        text.setFont(new Font("Calibre", Font.BOLD,100));
        add(text);


        //menuBar.add(menu);

        //menuBar.setLayout(new FlowLayout());
        menuBar.add(menu);

















































































      //  setSize(100,1000);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainPanel1();
    }

    public void BacktoLoginPage(ActionEvent e){
        setVisible(false);
        new login();
    }

    public void Exit(ActionEvent e){
        System.exit(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
