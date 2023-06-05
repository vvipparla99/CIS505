public class Student {

	private String firstName;
	
	private String lastName;
	
	private String course;
	
	private String grade;

	public Student() {
		
	}
	public Student(String firstName, String lastName, String course, String grade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.grade = grade;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getCourse() {
		return course;
	}

	
	public void setCourse(String course) {
		this.course = course;
	}

	
	public String getGrade() {
		return grade;
	}

	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	 public String toString() {
	        return String.format("Name: %s, %s\nCourse: %s\nLetter Grade: %s", lastName, firstName,
	                course, grade);
	    }
	
}
