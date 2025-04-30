import java.sql.*;

public class EmployeeInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company"; //  DB name
        String user = "root"; // MySQL username
        String password = "2gowtham8"; //  MySQL password

        String insertQuery = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        // Sample employee data (use 10000.0 instead of 10000 to make them Double)
        Object[][] employees = {
                {101, "Jenny", 25, 10000.0},
                {102, "Jacky", 30, 20000.0},
                {103, "Joe", 20, 40000.0},
                {104, "John", 40, 80000.0},
                {105, "Shameer", 25, 90000.0}
        };

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            for (Object[] emp : employees) {
                pstmt.setInt(1, (Integer) emp[0]);
                pstmt.setString(2, (String) emp[1]);
                pstmt.setInt(3, (Integer) emp[2]);
                pstmt.setDouble(4, ((Number) emp[3]).doubleValue()); // Safe casting
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
