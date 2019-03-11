package tp_project_1;


public class OnlineClass extends Course{
    
    private String classtype;
    
    
    
    
    public OnlineClass(String newCourseName, int newCrnNumber,
    String newCourseNumber, String newSection, int newCreditHours,
    String newClassType,  String newInstructor){
        
        super(newCourseName, newCrnNumber, newCourseNumber, newSection,
                newCreditHours, newInstructor);
        
        this.classtype = newClassType;
                
                
    }

    public String getClasstype() {
        return classtype;
    }

    public void setClasstype(String newClasstype) {
        this.classtype = newClasstype;
    }
    
    @Override
    public boolean conflictsWith(Course c){
        
        boolean conflicts = false;
        
        if(this.getCrnNumber() == c.getCrnNumber()){
            conflicts = true;
        }
        
        return conflicts;
    }
    
    @Override
    public String toString(){
        
        return (super.getCourseName() + " " + super.getCrnNumber() + " " + 
                super.getCourseNumber() + " " + super.getSection() + " " +
                super.getCreditHours() + " " + this.getClasstype() + " " +
                super.getInstructor());
    }
    
    
    
}
