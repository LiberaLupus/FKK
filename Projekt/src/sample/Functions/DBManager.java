package sample.Functions;


import sample.Interfaces.DBModes;
import sample.Pattern.DBConnectionSingleton;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBManager implements DBModes{

    public DBConnectionSingleton connection = DBConnectionSingleton.getInstance();

    public DBManager() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    }

    @Override
    public List<String> Select(String SQLQuery){
        try{
            Statement stmt = connection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQLQuery);

            List<String> Liste01 = new ArrayList<String>();
            String name = null;
            while (rs.next()) {
                name = rs.getString("Name");
                Liste01.add(name);
                System.out.println(name);
            }
            rs.close();
            stmt.close();
            return Liste01;
        }catch (Exception ex){
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void Insert(String SQLQuery){
        try{
            Statement stmt = connection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQLQuery);
            rs.close();
            stmt.close();
        }catch (Exception ex){
            System.out.println(ex);

        }
    }

    @Override
    public void Delete(String SQLQuery) {

    }

    @Override
    public void Update(String SQLQuery) {

    }


}
