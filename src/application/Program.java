package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    static void main() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        //recuperar dados do banco
        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from seller");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();

        }

    }
}
