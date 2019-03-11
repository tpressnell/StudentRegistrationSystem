
package tp_project_1;


public  abstract class Course {
    
    private String courseName;
    private int crnNumber;
    private String courseNumber;
    private String section;
    private int creditHours;
    private String instructor;
    
    
    public Course(String newCourseName, int newCrnNumber,
    String newCourseNumber, String newSection, int newCreditHours,
    String newInstructor){
        
        this.courseName = newCourseName;
        this.crnNumber = newCrnNumber;
        this.courseNumber = newCourseNumber;
        this.section = newSection;
        this.creditHours = newCreditHours;
        this.instructor = newInstructor;
        
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String newCourseName) {
        this.courseName = newCourseName;
    }

    public int getCrnNumber() {
        return crnNumber;
    }

    public void setCrnNumber(int newCrnNumber) {
        this.crnNumber = newCrnNumber;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String newCourseNumber) {
        this.courseNumber = newCourseNumber;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String newSection) {
        this.section = newSection;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int newCreditHours) {
        this.creditHours = newCreditHours;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String newInstructor) {
        this.instructor = newInstructor;
    }
    
    public abstract boolean conflictsWith(Course c);
    
    
    
}
