package studentManagementSystemm;

//import example_program.RoundPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import static java.awt.Font.ITALIC;
import static javax.swing.SwingConstants.CENTER;


public class MainPanel extends JFrame implements ActionListener {


    JLabel dashboardtext, dashBoardpic, sectionText, studentText, gradeText, sectionCount, studentCount, honorCount;

    JPanel dashboardtextPanel, sectionPanel, studentPanel, gradePanel, view;


    JLabel SectionDp, StudentDp, GradeDp;

    private int arcWidth;
    private int arcHeight;

    DefaultTableModel preview;

    JTable list;



    MainPanel(){
        super("Student Management System");
        //setExtendedState(JFrame.NORMAL);
        Font plain = new Font("Calibre", Font.PLAIN, 15);
        Font bold = new Font("Calibre", Font.BOLD|ITALIC, 20);
        LineBorder border =  new LineBorder(Color.BLACK, 3);


        /*ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bg.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1000,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLable = new JLabel(imageIcon2);
        //imageLable.setBounds(300,0,50,50);
        add(imageLable);*/



        JMenuBar menuBar= new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("Calibre", Font.BOLD, 15));

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setFont(new Font("Calibre", Font.BOLD, 15));
        Exit.addActionListener(this::Exit);

        JMenuItem loginPage = new JMenuItem("Login");
        loginPage.setFont(new Font("Calibre", Font.BOLD, 15));
        loginPage.addActionListener(this:: BacktoLoginPage);

        JMenu Section = new JMenu("Section");
        Section.setFont(new Font("Calibre", Font.BOLD, 15));

        JMenuItem createSection = new JMenuItem("Add Section");
        createSection.setFont(new Font("Calibre", Font.BOLD, 15));
        createSection.addActionListener(this:: addSection);
        Section.add(createSection);

        JMenu student = new JMenu("Student");
        student.setFont(new Font("Calibre", Font.BOLD, 15));

        JMenuItem addstudents = new JMenuItem("Add Student");
        addstudents.setFont(new Font("Calibre", Font.BOLD, 15));
        addstudents.addActionListener(this:: addstudent);

        JMenuItem studentList = new JMenuItem("Student List");
        studentList.setFont(new Font("Calibre", Font.BOLD, 15));
        studentList.addActionListener(this:: studentlist);
        student.add(studentList);
        student.add(addstudents);

        JMenu grade = new JMenu("Grade");
        grade.setFont(new Font("Calibre", Font.BOLD, 15));

        JMenuItem addgrades = new JMenuItem("Add Grade");
        addgrades.setFont(new Font("Calibre", Font.BOLD, 15));
        addgrades.addActionListener(this:: addgrade);
        grade.add(addgrades);



        menu.add(Exit);
        menu.add(loginPage);

        menuBar.add(menu);
        menuBar.add(grade);
        menuBar.add(student);
        menuBar.add(Section);
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));


        ImageIcon dash = new ImageIcon(getClass().getResource("icon/dashboard.png"));
        Image dashboard = dash.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon dashboardicon = new ImageIcon(dashboard);
        dashBoardpic = new JLabel(dashboardicon);
        dashBoardpic.setBounds(300,0,50,50);

        dashboardtext = new JLabel("DASHBOARD");
        dashboardtext.setFont(new Font("Calibre", Font.BOLD, 40));
        dashboardtext.setBounds(350,5,350,45);


        dashboardtextPanel = new JPanel();
        dashboardtextPanel.setBounds(20,10,945,50);
        dashboardtextPanel.setBackground(new Color(239, 150, 163, 213));
        //dashboardbuttonPanel.setBackground(Color.GREEN);
        dashboardtextPanel.add(dashboardtext);
        dashboardtextPanel.add(dashBoardpic);
        dashboardtextPanel.setLayout(null);
        add(dashboardtextPanel);


        sectionPanel = new RoundPanel(20,20);
        sectionPanel.setBounds(20,120,250,100);
        sectionPanel.setBackground(new Color(236, 71, 71, 255));
        sectionPanel.setLayout(null);
        add(sectionPanel);

        studentPanel = new RoundPanel(20,20);
        studentPanel.setBounds(20,240,250,100);
        studentPanel.setBackground(new Color(236, 129, 71, 255));
        studentPanel.setLayout(null);
        add(studentPanel);

        gradePanel = new RoundPanel(20,20);
        gradePanel.setBounds(20,360,250,100);
        gradePanel.setBackground(new Color(236, 71, 165, 255));
        gradePanel.setLayout(null);
        add(gradePanel);




        preview = new DefaultTableModel();
        preview.addColumn("Section");
        preview.addColumn("Name");
        preview.addColumn("LastName");

        list = new JTable(preview);
        list.setFont(plain);
        list.setRowHeight(25);

        JScrollPane scrollpane = new JScrollPane(list);
        //scrollpane.setViewportView(list);
        scrollpane.setFont(plain);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        //centerRenderer.setFont(new Font("Arial", Font.BOLD, 14));
        centerRenderer.setHorizontalAlignment(CENTER);
        list.setDefaultRenderer(Object.class, centerRenderer);

        view = new RoundPanel(20,20);
        view.setBounds(665,120,300,340);
        view.setBorder(border);
        view.setLayout(new BorderLayout());
        view.add(scrollpane, BorderLayout.CENTER);
        add(view);


        ImageIcon SectionPic = new ImageIcon(getClass().getResource("icon/section.png"));
        Image section = SectionPic.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT);
        ImageIcon Sectionp = new ImageIcon(section);
        SectionDp = new JLabel(Sectionp);
        SectionDp.setBounds(160,10,80,80);
        sectionPanel.add(SectionDp);

        ImageIcon StudentPic = new ImageIcon(getClass().getResource("icon/student1.png"));
        Image student1 = StudentPic.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT);
        ImageIcon Student = new ImageIcon(student1);
        StudentDp = new JLabel(Student);
        StudentDp.setBounds(160,10,80,80);
        studentPanel.add(StudentDp);

        ImageIcon GradePic = new ImageIcon(getClass().getResource("icon/grade.png"));
        Image grade1 = GradePic.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT);
        ImageIcon Grade = new ImageIcon(grade1);
        GradeDp = new JLabel(Grade);
        GradeDp.setBounds(160,10,80,80);
        gradePanel.add(GradeDp);

        sectionText = new JLabel("SECTION");
        sectionText.setBounds(10,-20,100,100);
        sectionText.setFont(bold);
        sectionText.setForeground(Color.WHITE);
        sectionPanel.add(sectionText);

        sectionCount = new JLabel("5");
        sectionCount.setBounds(10,30,100,100);
        sectionCount.setFont(new Font("Calibre", Font.PLAIN, 20));
        sectionCount.setForeground(Color.WHITE);
        sectionPanel.add(sectionCount);


        studentText = new JLabel("STUDENT");
        studentText.setBounds(10,-20,100,100);
        studentText.setFont(bold);
        studentText.setForeground(Color.WHITE);
        studentPanel.add(studentText);

        studentCount = new JLabel("243");
        studentCount.setBounds(10,30,100,100);
        studentCount.setFont(new Font("Calibre", Font.PLAIN, 20));
        studentCount.setForeground(Color.WHITE);
        studentPanel.add(studentCount);

        gradeText = new JLabel("GRADE");
        gradeText.setBounds(10,-20,100,100);
        gradeText.setFont(bold);
        gradeText.setForeground(Color.WHITE);
        gradePanel.add(gradeText);

        honorCount = new JLabel("12 Honor Student");
        honorCount.setBounds(10,30,170,100);
        honorCount.setFont(new Font("Calibre", Font.PLAIN, 20));
        honorCount.setForeground(Color.WHITE);
        gradePanel.add(honorCount);





      //  setSize(100,1000);
        //setResizable(false);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainPanel();
    }

    public void RoundPanel(int arcWidth, int arcHeight) { //make the edge corner Round // Para ni siya sa rounded Panel
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        //setOpaque(false);
    }


    public void paintComponents(Graphics g) { // Components to make a edge of panel round
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
        super.paintComponents(g);
    }


    public void addSection(ActionEvent e){
        setVisible(true);
        new Section();
    }


    public void addgrade(ActionEvent e){
        setVisible(false);
        new grade();
    }
    public void addstudent(ActionEvent e){
        setVisible(false);
        new Student();
    }

    public void studentlist(ActionEvent e){
        setVisible(false);
        new studentlist();
    }

    public void BacktoLoginPage(ActionEvent e){
        setVisible(false);
        new login();
    }


    public MainPanel Exit(ActionEvent e){
        int dlt = JOptionPane.showConfirmDialog(this,"Are You sure you want to exit?","Exit", JOptionPane.YES_NO_OPTION);
        if(dlt == 0){
            System.exit(0);
        }

        return null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
