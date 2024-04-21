package studentManagementSystemm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import static javax.swing.SwingConstants.CENTER;

public class Student extends JFrame implements ActionListener, MouseListener {

    JLabel icon, nametext, lastnametext, agetext, gendertext, sectiontext, lrntext;

    JPanel studentPanel, listPanel;

    JButton back, add, delete, update, clear;
    JTextField name, lastname, age, section, gender, address, lrn;

    JTable listofstudent;
    DefaultTableModel studentlist;

    Choice genderlist, sectionlist;

    //String DB = "jdbc:mysql://Localhost:3306/connector";
    //String DB_USER = "root";
    //String UB_PASSWORD = "rogelio";

    Connection connection;
    PreparedStatement statement;
    int rowCount = 0;


    Student(){
        super("Add Students");
        getContentPane().setBackground(new Color(200, 20, 95,24));

        LineBorder border =  new LineBorder(Color.BLACK, 3);
        Font plain = new Font("Calibre", Font.PLAIN, 15);
        Font bold = new Font("Calibre", Font.BOLD, 20);

        ImageIcon SectionPic = new ImageIcon(getClass().getResource("icon/student.png"));
        Image section = SectionPic.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon Sectionp = new ImageIcon(section);
        icon = new JLabel(Sectionp);
        icon.setBounds(95,10,100,100);


        studentPanel = new JPanel();
        studentPanel.setBounds(20,80,300,600);
        studentPanel.setBorder(border);
        add(studentPanel);
        studentPanel.add(icon);
        studentPanel.setLayout(null);

        listPanel = new JPanel();
        listPanel.setBounds(500,80,700,600);
        listPanel.setBorder(border);
        add(listPanel);
        //studentPanel.add(icon);
        listPanel.setLayout(new BorderLayout());

        lrn = new JTextField();
        lrn.setBounds(120, 150,150,25);
        lrn.setFont(plain);
        studentPanel.add(lrn);

        name = new JTextField();
        name.setBounds(120, 200,150,25);
        name.setFont(plain);
        studentPanel.add(name);

        lastname = new JTextField();
        lastname.setBounds(120, 250,150,25);
        lastname.setFont(plain);
        studentPanel.add(lastname);

        age = new JTextField();
        age.setBounds(120, 300,150,25);
        age.setFont(plain);
        studentPanel.add(age);

        lrntext = new JLabel("Lrn:");
        lrntext.setBounds(20,137,100,50);
        lrntext.setFont(bold);
        studentPanel.add(lrntext);

        nametext = new JLabel("Name:");
        nametext.setBounds(20,187,100,50);
        nametext.setFont(bold);
        studentPanel.add(nametext);

        lastnametext = new JLabel("Lastname:");
        lastnametext.setBounds(20,237,100,50);
        lastnametext.setFont(bold);
        studentPanel.add(lastnametext);

        agetext = new JLabel("Age:");
        agetext.setBounds(20,287,100,50);
        agetext.setFont(bold);
        studentPanel.add(agetext);

        gendertext = new JLabel("Gender:");
        gendertext.setBounds(20,337,100,50);
        gendertext.setFont(bold);
        studentPanel.add(gendertext);

        sectiontext = new JLabel("Section:");
        sectiontext.setBounds(20,387,100,50);
        sectiontext.setFont(bold);
        studentPanel.add(sectiontext);

        genderlist = new Choice();
        genderlist.setFont(plain);
        genderlist.setBounds(120,350,150,25);
        genderlist.add("");
        genderlist.add("Male");
        genderlist.add("Female");
        studentPanel.add(genderlist);

        sectionlist = new Choice();
        sectionlist.setFont(plain);
        sectionlist.setBounds(120,400,150,25);
        sectionlist.add("");
        sectionlist.add("testing 01");
        sectionlist.add("testing 02");
        studentPanel.add(sectionlist);

        back = new JButton("Back");
        back.setBounds(20,10,90,30);
        back.addActionListener(this::back);
        back.setFont(bold);
        add(back);

        add = new JButton("Add");
        add.setBounds(40,500,105,30);
        add.addActionListener(this::add);
        add.setFont(bold);
        studentPanel.add(add);

        delete = new JButton("Delete");
        delete.setBounds(40,550,105,30);
        add.addActionListener(this);
        delete.setFont(bold);
        studentPanel.add(delete);

        update = new JButton("Update");
        update.setBounds(160,500,105,30);
        //add.addActionListener(this::update);
        update.setFont(bold);
        studentPanel.add(update);

        clear = new JButton("Clear");
        clear.setBounds(160,550,105,30);
        add.addActionListener(this::clear);
        clear.setFont(bold);
        studentPanel.add(clear);



        studentlist = new DefaultTableModel();
        //studentlist.setFont(plain);
        studentlist.addColumn("No.");
        studentlist.addColumn("Lrn");
        studentlist.addColumn("Name");
        studentlist.addColumn("Surname");
        studentlist.addColumn("Age");
        studentlist.addColumn("Gender");
        studentlist.addColumn("Section");

        listofstudent = new JTable(studentlist);
        listofstudent.addMouseListener(this);
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


        setSize(1250,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);

    }

    public int add(ActionEvent e){ // ADD BUTTON

        rowCount++;

        String lrnnum = lrn.getText();
        String Name = name.getText();
        String sur = lastname.getText();
        String Age = age.getText();
        String gendeR = genderlist.getSelectedItem();
        String sectioN = sectionlist.getSelectedItem();
        //String gen =

        if(lrnnum.isEmpty() ||Name.isEmpty() || sur.isEmpty() || Age.isEmpty() || genderlist.getSelectedIndex() == 0 || sectionlist.getSelectedIndex() == 0 ) {
            JOptionPane.showMessageDialog(null,"PLEASE FILL UP THE FORM COMPLETELY");
            return rowCount--;
        }else{
            studentlist.addRow(new Object[]{rowCount, lrnnum,Name,sur,Age,gendeR,sectioN});
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://Localhost:3306/students", "root", "rogelio");
            String sql = "INSERT INTO student (lrn, name, lastname, age, gender,section) VALUES (?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, lrnnum);
            statement.setString(2, Name);
            statement.setString(3, sur);
            statement.setString(4, Age);
            statement.setString(5, gendeR);
            statement.setString(6, sectioN);

            statement.executeUpdate();

            //MsgBox("Added", MsgBoxStyle.Information)
            //JOptionPane.showMessageDialog(null,"Student added!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error adding data to database: " + ex.getMessage());
        }

        lrn.setText("");
        name.setText("");
        lastname.setText("");
        age.setText("");
        genderlist.select("");
        sectionlist.select("");

        return 0;
    }

    public void back(ActionEvent e){
        setVisible(false);
        new MainPanel();
    }



    /*public void update(ActionEvent e){
       /* listofstudent.getSelectedRow();
        lrn.getText();
        name.getText();
        lastname.getText();
        age.getText();
        genderlist.getSelectedItem();
        sectionlist.getSelectedItem();
        String lrnnum = lrn.getText();
        String Name = name.getText();
        String sur = lastname.getText();
        String Age = age.getText();
        String gendeR = genderlist.getSelectedItem();
        String sectioN = sectionlist.getSelectedItem();
        // Assuming this code is within your ActionListener for the update button
        try {
            connection = DriverManager.getConnection("jdbc:mysql://Localhost:3306/students", "root", "rogelio");
            String sql = "UPDATE student SET name=?, lastname=?, age=?, gender=?, section=? WHERE lrn=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, lrnnum);
            statement.setString(2, Name);
            statement.setString(3, sur);
            statement.setString(4,Age);
            statement.setString(5, gendeR);
            statement.setString(6, sectioN);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data updated successfully");
            } else {
                JOptionPane.showMessageDialog(null, "No rows were updated");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error updating data in the database: " + ex.getMessage());
        }

    }*/



   public void delete(ActionEvent event) throws SQLException {
        int selectedRow = listofstudent.getSelectedRow();

        if(selectedRow !=1){
            studentlist.removeRow(listofstudent.convertRowIndexToModel(selectedRow));
        }else if(listofstudent.getRowCount() == 0){
            JOptionPane.showMessageDialog(null,"add student first");
        }else{
            JOptionPane.showMessageDialog(null,"invalid ");
        }

       if(event.getSource() == delete){
           String sqlDelete = "DELETE FROM student where lrn =?, name =?, lastname =?, age=?, gender =?, section =?";
           int dlt = statement.executeUpdate(sqlDelete);

           JOptionPane.showMessageDialog(null,"Deleted");
       }

    }




    public static void main(String[] args) {
        new Student();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        DefaultTableModel studentlist = (DefaultTableModel)listofstudent.getModel();
        int SelectedRow = listofstudent.getSelectedRow();

        lrn.setText(studentlist.getValueAt(SelectedRow,1).toString());
        name.setText(studentlist.getValueAt(SelectedRow,2).toString());
        lastname.setText(studentlist.getValueAt(SelectedRow,3).toString());
        age.setText(studentlist.getValueAt(SelectedRow,4).toString());
        genderlist.select(studentlist.getValueAt(SelectedRow,5).toString());
        sectionlist.select(studentlist.getValueAt(SelectedRow,6).toString());

        if(e.getSource() == clear){
            lrn.setText("");
            name.setText("");
            lastname.setText("");
            age.setText("");
            genderlist.select("");
            sectionlist.select("");
        }

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
    public void clear(ActionEvent e){

        if(e.getSource() == clear){
            lrn.setText("");
            name.setText("");
            lastname.setText("");
            age.setText("");
            genderlist.select("");
            sectionlist.select("");
        }
        
    }

}
