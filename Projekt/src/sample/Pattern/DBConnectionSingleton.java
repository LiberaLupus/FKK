package sample.Pattern;

        import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class DBConnectionSingleton extends MysqlDataSource {
    public Connection conn;
    private static DBConnectionSingleton instance = null;

    protected DBConnectionSingleton() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String connectionCommand = "jdbc:mysql://localhost:3306/KKK?user=root&password=gibbiX12345";
        conn = DriverManager.getConnection(connectionCommand);
        DBConnectionSingleton.instance = this;
    }

    public static DBConnectionSingleton getInstance() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(instance == null){
            instance = new DBConnectionSingleton();
        }
        return instance;
    }
}
