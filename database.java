package studentManagementSystemm;

import java.sql.*;

public class database {


    public PreparedStatement statement;
    Connection conn;

    Statement stmt;

    database(){

        try{

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "rogelio");
            stmt = conn.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
