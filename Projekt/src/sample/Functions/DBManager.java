package sample.Functions;


import sample.Interfaces.DBModes;
import sample.Pattern.DBConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBManager implements DBModes{

    public DBConnectionSingleton connection = DBConnectionSingleton.getInstance();

    public DBManager() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    }

    @Override
    public List<Integer> Select01(String SQLQuery, String Attribut){
        try{
            Statement stmt = connection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQLQuery);

            List<Integer> Liste01 = new ArrayList<Integer>();
            Integer name = 0;
            while (rs.next()) {
                name = rs.getInt(Attribut);
                Liste01.add(name);
                System.out.println("Select: " + name);
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
    public List<String> Select02(String SQLQuery, String Attribut){
        try{
            Statement stmt = connection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQLQuery);

            List<String> Liste01 = new ArrayList<String>();
            String name = "";
            while (rs.next()) {
                name = rs.getString(Attribut);
                Liste01.add(name);
                System.out.println("Select: " + name);
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
    public void Insert1(String SQLQuery,String Value){
        try{
            PreparedStatement stmt = connection.conn.prepareStatement(SQLQuery);
            stmt.setString(1, Value);
            stmt.execute();
            stmt.close();
        }catch (Exception ex){
            System.out.println(ex);

        }
    }

    @Override
    public void Insert2(String SQLQuery, String Value1, String Value2, Integer Value3) {
        try{
            PreparedStatement stmt = connection.conn.prepareStatement(SQLQuery);
            stmt.setString(1, Value1);
            stmt.setString(2, Value2);
            stmt.setInt(3, Value3);
            stmt.execute();
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
