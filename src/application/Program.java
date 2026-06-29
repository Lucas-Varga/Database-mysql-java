package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    static void main() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        /*recuperar dados do banco
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;



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

        } */

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
            /*
            //inserindo dados na tabela
            st = conn.prepareStatement(
                    "INSERT INTO seller"
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                            + "VALUES "
                            + "(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Carl Purple");
            st.setString(2, "carl@email.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);
            */

            // Inserindo mais de um dado na tabela
            st = conn.prepareStatement(
                    "insert into department (Name) values ('d2'),('D2')",
                    Statement.RETURN_GENERATED_KEYS);

            int rowAffected = st.executeUpdate();

            if (rowAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.println("No rown affected!");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } /*catch (ParseException e) {
            e.printStackTrace();
        } */ finally {
            DB.closeStatemant(st);
            DB.closeConnection();
        }

    }
}
