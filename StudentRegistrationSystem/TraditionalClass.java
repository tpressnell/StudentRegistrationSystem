package tp_project_1;


import java.time.LocalTime;


public class TraditionalClass extends Course {
    
    private LocalTime startTime;
    private LocalTime endTime;
    private String daysMet;
    private String location;
    private String classType;

    
    
    
    public TraditionalClass(String newCourseName, int newCrnNumber,
    String newCourseNumber, String newSection, int newCreditHours,
    LocalTime newStartTime, LocalTime newEndTime,
    String newDaysMet, String newLocation, String newClassType, 
    String newInstructor){
        
        super(newCourseName, newCrnNumber, newCourseNumber, newSection,
                newCreditHours, newInstructor);
        
        this.startTime = newStartTime;
        this.endTime = newEndTime;
        this.daysMet = newDaysMet;
        this.location = newLocation;
        this.classType = newClassType;
    }
    
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime newStartTime) {
        this.startTime = newStartTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime newEndTime) {
        this.endTime = newEndTime;
    }

    public String getDaysMet() {
        return daysMet;
    }

    public void setDaysMet(String newDaysMet) {
        this.daysMet = newDaysMet;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setRoomNumber(String newClassType) {
        this.classType = newClassType;
    }
    
    @Override
    public boolean conflictsWith(Course c){
        
        boolean conflicts = false;
        
        
        
        if(c instanceof TraditionalClass){
            TraditionalClass t1 = (TraditionalClass)c;
            
            if(this.getDaysMet().equals(t1.getDaysMet())){
            
                if(this.getEndTime().isAfter(t1.getStartTime())
                        && this.getStartTime().isBefore(t1.getStartTime())){
                    conflicts = true;
                }
                
                else if(this.getStartTime().isBefore(t1.getEndTime())
                        && this.getEndTime().isAfter(t1.getEndTime())){
                    conflicts = true;
                }
                
                else if(this.getStartTime().isAfter(t1.getStartTime()) &&
                        this.getEndTime().isBefore(t1.getEndTime())){
                    conflicts = true;
                }
                
                else if(this.getStartTime() == t1.getStartTime()){
                    conflicts = true;
                }

            }
            
            else{
                conflicts = false;
            }
        }
        
        else if(this.getCrnNumber() == c.getCrnNumber()){
            
            conflicts = true;
        }
        
        else{
            conflicts = false;
        }
        
        
        return conflicts;
    }
    
    @Override
    public String toString(){
        
        return (super.getCourseName() + " " + super.getCrnNumber() + " " + 
                super.getCourseNumber() + " " + super.getSection() + " " +
                super.getCreditHours() + " " + this.getStartTime() + " " +
                this.getEndTime() + " " + this.getDaysMet() + " " + " " +
                this.getLocation() + " " + this.getClassType() + " " +
                super.getInstructor());
    }
    
    
    
}
