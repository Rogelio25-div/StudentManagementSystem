package studentManagementSystemm;

import example_program.RoundPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Arrays;

import static javax.swing.SwingConstants.CENTER;

public class studentlist extends JFrame {

    JButton back;
    JPanel list, listPanel;

    Choice studentlist;

    DefaultTableModel students;
    JTable listofstudent;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/students";
    static final String USER = "root";
    static final String PASS = "rogelio";
    
    studentlist() {
        super("Student List");
        getContentPane().setBackground(new Color(71, 20, 200, 24));
        Font bold = new Font("Calibre", Font.BOLD, 20);
        Font plain = new Font("Calibre", Font.PLAIN, 15);
        LineBorder border = new LineBorder(Color.BLACK, 3);

        Connection conn = null;
        Statement stmt = null;
        String sql = null;

        /*try {
            Class.forName("com.mtsql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            sql = "SELECT section FROM student";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int lrn = rs.getInt("lrn");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String section = rs.getString("section");

              //  studentlist.addRow(new Object[]{lrn, name, lastname, age, gender, section});

            }

        } catch (Exception e) {

        }*/


        back = new JButton("Back");
        back.setBounds(20, 10, 90, 30);
        back.addActionListener(this::back);
        back.setFont(bold);
        add(back);

        list = new RoundPanel(20, 20);
        list.setBounds(20, 300, 200, 200);
        list.setBorder(border);
        list.setLayout(null);
        add(list);

        listPanel = new JPanel();
        listPanel.setBounds(500, 80, 700, 600);
        listPanel.setBorder(border);
        add(listPanel);
        //studentPanel.add(icon);
        listPanel.setLayout(new BorderLayout());

        studentlist = new Choice();
        studentlist.setFont(plain);
        studentlist.setBounds(25, 50, 150, 25);
        studentlist.add("Select Section");
        //studentlist.add(sql);
        list.add(studentlist);

        students = new DefaultTableModel();
        //studentlist.setFont(plain);
        students.addColumn("No.");
        students.addColumn("Lrn");
        students.addColumn("Name");
        students.addColumn("Surname");
        students.addColumn("Age");
        students.addColumn("Gender");
        students.addColumn("Section");

        listofstudent = new JTable(students);
        //listofstudent.addMouseListener(this);
        listofstudent.setFont(plain);
        listofstudent.setRowHeight(25);

        TableColumn column1 = listofstudent.getColumnModel().getColumn(0);
        TableColumn column2 = listofstudent.getColumnModel().getColumn(4);
        column1.setPreferredWidth(20); // Set the width of column 1 to 100 pixels
        column2.setPreferredWidth(20);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        //centerRenderer.setFont(new Font("Arial", Font.BOLD, 14));
        centerRenderer.setHorizontalAlignment(CENTER);
        listofstudent.setDefaultRenderer(Object.class, centerRenderer);

        JScrollPane scrollpane = new JScrollPane(listofstudent);
        scrollpane.setViewportView(listofstudent);
        scrollpane.setFont(plain);
        listPanel.add(scrollpane, BorderLayout.CENTER);
        listPanel.setFont(plain);


        setSize(1250, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
    }

    public void back(ActionEvent e){
        setVisible(false);
        new MainPanel();
    }

    public static void main(String[] args) {

    new studentlist();
    }

}
