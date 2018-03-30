package sample.Functions;

import com.mysql.cj.api.jdbc.Statement;
import sample.Pattern.DBConnectionSingleton;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DBManager {

    public DBConnectionSingleton connection = DBConnectionSingleton.getInstance();

    public DBManager() throws SQLException {
    }

    public void test() throws SQLException {
        Statement stmt = (Statement) connection.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT ID FROM USERS");
    }
}
