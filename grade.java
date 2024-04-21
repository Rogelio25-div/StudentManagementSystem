package studentManagementSystemm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.awt.SystemColor.scrollbar;

public class grade extends JFrame {


    JPanel data;
    JLabel icon, selectSection,nametext, lastnametext,math, filipino, english, science, quarter, ap, esp;
    Choice whatquater;
    JButton back;
    ScrollPane Scroll;



    grade(){
        super("Add Grade");
        getContentPane().setBackground(new Color(176, 20, 200, 24));

        LineBorder border =  new LineBorder(Color.BLACK, 3);
        Font plain = new Font("Calibre", Font.PLAIN, 15);
        Font bold = new Font("Calibre", Font.BOLD, 20);

        ImageIcon gradePic = new ImageIcon(getClass().getResource("icon/gradep.png"));
        Image grade = gradePic.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon gradep = new ImageIcon(grade);
        icon = new JLabel(gradep);
        icon.setBounds(95,10,100,100);



        back = new JButton("Back");
        back.setBounds(20,10,90,30);
        back.addActionListener(this::back);
        back.setFont(bold);
        add(back);

        data = new JPanel();
        data.setBounds(20,80,300,600);
        //data.setBorder(border);
        data.add(icon);
        data.setLayout(null);
        //add(data);

        selectSection = new JLabel("Select Section:");
        selectSection.setBounds(20,137,150,50);
        selectSection.setFont(bold);
        data.add(selectSection);

        nametext = new JLabel("Name:");
        nametext.setBounds(20,187,100,50);
        nametext.setFont(bold);
        data.add(nametext);

        lastnametext = new JLabel("Lastname:");
        lastnametext.setBounds(20,237,100,50);
        lastnametext.setFont(bold);
        data.add(lastnametext);

        math = new JLabel("Math:");
        math.setBounds(20,287,100,50);
        math.setFont(bold);
        data.add(math);

        english = new JLabel("English:");
        english.setBounds(20,337,100,50);
        english.setFont(bold);
        data.add(english);

        filipino = new JLabel("Filipino:");
        filipino.setBounds(20,387,100,50);
        filipino.setFont(bold);
        data.add(filipino);

        science = new JLabel("Science:");
        science.setBounds(20,437,100,50);
        science.setFont(bold);
        data.add(science);

        ap = new JLabel("AP:");
        ap.setBounds(20,487,100,50);
        ap.setFont(bold);
        data.add(ap);

        esp = new JLabel("Esp:");
        esp.setBounds(20,537,100,50);
        esp.setFont(bold);
        data.add(esp);

        esp = new JLabel("Mapeh:");
        esp.setBounds(20,587,100,50);
        esp.setFont(bold);
        data.add(esp);


        JScrollPane scrollPane = new JScrollPane(data);
        scrollPane.setBounds(20,80,300,600);
        scrollPane.setBorder(null);
        add(scrollPane);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1250,800);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void back(ActionEvent e){
        setVisible(false);
        new MainPanel();
    }



    public static void main(String[] arg){
        new grade();
    }
}
