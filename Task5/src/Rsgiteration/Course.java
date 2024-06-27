package Rsgiteration;

public class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
	public Course(String courseCode, String title, String description, int capacity, String schedule) {
		super();
		this.courseCode = courseCode;
		this.title = title;
		this.description = description;
		this.capacity = capacity;
		this.schedule = schedule;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", title=" + title + ", description=" + description + ", capacity="
				+ capacity + ", schedule=" + schedule + "]";
	}
    

	
}
