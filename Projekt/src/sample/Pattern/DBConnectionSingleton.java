package sample.Pattern;

        import com.mysql.cj.jdbc.MysqlDataSource;

        import java.sql.Connection;
        import java.sql.SQLException;

public class DBConnectionSingleton extends MysqlDataSource {
    public Connection conn;
    private static DBConnectionSingleton instance = null;

    protected DBConnectionSingleton() throws SQLException {
        this.setUser("root");
        this.setPassword("gibbiX12345");
        this.setServerName("localhost");
        this.conn = this.getConnection();
        DBConnectionSingleton.instance = this;
    }

    public static DBConnectionSingleton getInstance() throws SQLException {
        if(instance == null){
            instance = new DBConnectionSingleton();
        }
        return instance;
    }
}
