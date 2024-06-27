package Rsgiteration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHelper {
    public Student getStudent(String studentID) {
        Student student = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Students WHERE studentID = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, studentID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                student = new Student(
                    rs.getString("studentID"),
                    rs.getString("name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Course> getRegisteredCourses(String studentID) {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT c.courseCode, c.title, c.description, c.capacity, c.schedule " +
                           "FROM Courses c INNER JOIN StudentCourses sc ON c.courseCode = sc.courseCode " +
                           "WHERE sc.studentID = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, studentID);
            ResultSet rs = stmt.executeQuery();
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
}
