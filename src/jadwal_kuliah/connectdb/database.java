package jadwal_kuliah.connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    private static Connection connect;
    public static Connection tryConnect()
    {
        if(connect == null)
        {
            try {
                String url  ="jdbc:mysql://localhost/db_jadwal_kuliah";
                String user = "root";
                String pass = "";

                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connect = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                //Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("WARNING: Can not create connection!");
            }
        }
        return connect;

    }
}
