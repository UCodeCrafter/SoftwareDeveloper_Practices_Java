package system_design.creational.singelton;

import java.sql.*;

//Basic Enum Singleton class
public enum EnumSafeSingletonBasic {
    INSTANCE;
    public String hello(){
        return "hello";
    }
}

enum EnumDbConnectionInstance {
    INSTANCE;

    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    EnumDbConnectionInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✓ MySQL Connection established");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    public ResultSet executeSelect(String query) throws SQLException {
        if (!isConnected()) throw new SQLException("Not connected to database");
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        if (!isConnected()) throw new SQLException("Not connected to database");
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(query);
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✓ Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}


class EnumDbClientClass {
    public static void main(String[] args) {
        EnumDbConnectionInstance db = EnumDbConnectionInstance.INSTANCE;

        System.out.println("=== MySQL Enum Singleton Demo ===\n");

        try {
            System.out.println("Connection Status: " + db.isConnected());
            System.out.println();

            // CREATE TABLE
            System.out.println("--- CREATE TABLE ---");
            String createTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "email VARCHAR(100))";
            db.executeUpdate(createTable);
            System.out.println("✓ Table created/exists\n");

            // INSERT
            System.out.println("--- INSERT ---");
            db.executeUpdate("INSERT INTO users (name, email) VALUES ('John', 'john@mail.com')");
            db.executeUpdate("INSERT INTO users (name, email) VALUES ('Jane', 'jane@mail.com')");
            System.out.println("✓ Records inserted\n");

            // SELECT
            System.out.println("--- SELECT ---");
            ResultSet rs = db.executeSelect("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email"));
            }
            rs.close();
            System.out.println();

            // UPDATE
            System.out.println("--- UPDATE ---");
            db.executeUpdate("UPDATE users SET email = 'john_new@mail.com' WHERE name = 'John'");
            System.out.println("✓ Record updated\n");

            // DELETE
            System.out.println("--- DELETE ---");
            db.executeUpdate("DELETE FROM users WHERE name = 'Jane'");
            System.out.println("✓ Record deleted\n");

            // SELECT AFTER DELETE
            System.out.println("--- FINAL SELECT ---");
            rs = db.executeSelect("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email"));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            db.closeConnection();
        }
    }
}