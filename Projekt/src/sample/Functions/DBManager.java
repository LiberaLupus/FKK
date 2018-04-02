package sample.Functions;


import sample.Pattern.DBConnectionSingleton;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBManager {

    public DBConnectionSingleton connection = DBConnectionSingleton.getInstance();

    public DBManager() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    }

    public void connectToMysql(){
        try{


            Statement stmt = connection.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select Name from karteien;");

            List<String> Liste01 = new ArrayList<String>();
            String name = null;
            while (rs.next()) {
                name = rs.getString("Name");
                Liste01.add(name);
                System.out.println("DBConnector " + name);
            }

            rs.close();
            stmt.close();

        }catch (Exception ex){
            System.out.println(ex);

        }
    }
}
