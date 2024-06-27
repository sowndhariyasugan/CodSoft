package Rsgiteration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseHelper {
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Courses";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Course course = new Course(
                    rs.getString("courseCode"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("capacity"),
                    rs.getString("schedule")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public boolean registerStudent(String courseCode, String studentID) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String checkQuery = "SELECT capacity, registeredStudents FROM Courses WHERE courseCode = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setString(1, courseCode);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                int capacity = rs.getInt("capacity");
                int registeredStudents = rs.getInt("registeredStudents");
                if (registeredStudents < capacity) {
                    String updateQuery = "UPDATE Courses SET registeredStudents = registeredStudents + 1 WHERE courseCode = ?";
                    PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                    updateStmt.setString(1, courseCode);
                    updateStmt.executeUpdate();

                    String insertQuery = "INSERT INTO StudentCourses (studentID, courseCode) VALUES (?, ?)";
                    PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
                    insertStmt.setString(1, studentID);
                    insertStmt.setString(2, courseCode);
                    insertStmt.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean dropStudent(String courseCode, String studentID) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String deleteQuery = "DELETE FROM StudentCourses WHERE studentID = ? AND courseCode = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
            deleteStmt.setString(1, studentID);
            deleteStmt.setString(2, courseCode);
            int rowsAffected = deleteStmt.executeUpdate();
            if (rowsAffected > 0) {
                String updateQuery = "UPDATE Courses SET registeredStudents = registeredStudents - 1 WHERE courseCode = ?";
                PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                updateStmt.setString(1, courseCode);
                updateStmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
