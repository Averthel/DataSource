package pl.ave.datasource.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

    public static void insert(String username, String comment)  throws SQLException {
        try(Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();){
            String query = String.format("INSERT INTO comments(username, tresc) VALUES ('%s', '%s')", username, comment);
            stmt.executeUpdate(query);
        }
    }

    public static void delete(String username) throws SQLException{
        String selectQuery = String.format("SELECT tresc FROM comments WHERE username='%s'", username);
        try(Connection conn = ConnectionProvider.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(selectQuery);){
            if(resultSet.next()){
                String deleteQuery = String.format("DELETE FROM comments WHERE username='%s'", username);
                stmt.executeUpdate(deleteQuery);
            }
        }
    }
}
