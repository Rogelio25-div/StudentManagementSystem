package studentManagementSystemm;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static javax.swing.SwingConstants.CENTER;

public class Section extends JFrame implements ActionListener {

    JTextField sectionField;
    JLabel sectionName,SectionDp, listofSection, YrLVL;
    JButton Add, Back, Remove;
    JPanel List;

    DefaultTableModel sectionList;

    JTable Section_yrlvl;

    Choice yrLVL;

    Section(){
        super("Add Section");
        getContentPane().setBackground(new Color(200,20, 32,24));
        Font myfont = new Font("Calibri", Font.BOLD, 15);


        ImageIcon SectionPic = new ImageIcon(getClass().getResource("icon/section.png"));
        Image section = SectionPic.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon Sectionp = new ImageIcon(section);
        SectionDp = new JLabel(Sectionp);
        SectionDp.setBounds(50,10,100,100);
        add(SectionDp);

        listofSection = new JLabel("Section / Yr Lvl");
        listofSection.setBounds(305,20,150,20);
        listofSection.setFont(new Font("Calibri", Font.BOLD, 20));
        add(listofSection);


        sectionName = new JLabel("Section Name:");
        sectionName.setBounds(25,130,150,20);
        sectionName.setFont(new Font("Calibre", Font.BOLD, 15));
        add(sectionName);

        Add = new JButton("Add");
        Add.setBounds(25, 230,60,20);
        Add.addActionListener(this::add);
        add(Add);

        Back = new JButton("Back");
        Back.setBounds(108,230,65,20);
        Back.addActionListener(this::back);
        add(Back);

        Remove = new JButton("Remove");
        Remove.setBounds(335,230,80,20);
        Remove.addActionListener(this::remove);
        add(Remove);

        sectionField = new JTextField();
        sectionField.setBounds(25,150,150,25);
        sectionField.setFont(new Font("Calibri", Font.PLAIN, 16));

        add(sectionField);

        YrLVL = new JLabel("Yr LVL:");
        YrLVL.setBounds(25,195,100,20);
        YrLVL.setFont(new Font("Calibre", Font.BOLD, 15));
        add(YrLVL);

        yrLVL = new Choice();
        yrLVL.setFont(new Font("Calibre", Font.BOLD, 15));
        yrLVL.setBounds(125,190,50,50);
        yrLVL.add("");
        yrLVL.add("7");
        yrLVL.add("8");
        yrLVL.add("9");
        yrLVL.add("10");
        yrLVL.add("11");
        yrLVL.add("12");
        add(yrLVL);

        sectionList = new DefaultTableModel();
        sectionList.addColumn("section");
        sectionList.addColumn("Yr LvL");

        // Initialize the table with the model
        Section_yrlvl = new JTable(sectionList);
        Section_yrlvl.setFont(myfont);
        Section_yrlvl.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(Section_yrlvl);
        scrollPane.setFont(myfont);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        //centerRenderer.setFont(new Font("Arial", Font.BOLD, 14));
        centerRenderer.setHorizontalAlignment(CENTER);
        Section_yrlvl.setDefaultRenderer(Object.class, centerRenderer);

        List = new JPanel();
        List.setBounds(300,50,150,150);
        List.setLayout(new BorderLayout());
        List.add(scrollPane, BorderLayout.CENTER);
        add(List);


        setSize(500,300);
        setLocation(400,300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setFocusable(true);

    }

    public void add(ActionEvent e){
        String section = sectionField.getText();
        String yr = yrLVL.getSelectedItem();

        if(section.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Add Section Name!");
            return;
        }else if(yr.equals("")){
            JOptionPane.showMessageDialog(null,"Please Select Year Level!!");
            return;
        }else{
            sectionList.addRow(new Object[]{section, yr});
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://Localhost:3306/students", "root", "rogelio");
            String sql = "INSERT INTO section (sectionName, yearLevel) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, section);
            statement.setString(2, yr);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Section Added!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error adding data to database: " + ex.getMessage());
        }






        sectionField.setText("");
        yrLVL.select(0);
    }

    public void back(ActionEvent e){
        setVisible(false);
    }

    public void remove(ActionEvent e){
        int selectedRow = Section_yrlvl.getSelectedRow();


        if(selectedRow != -1){
            sectionList.removeRow(Section_yrlvl.convertRowIndexToModel(selectedRow));
        }
    }


    public static void main(String[] args){
        new Section();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
