# StudentRegistrationSystem
A program that simulates a college student registration system that I wrote in my CS 232 class.


This is a project, which simulates a students registration system, was assigned to my
class to teach us about inheritance and super-classes.

## Course

The core of this project is the Course class, which is the superclass for the program. It contains the members that
are shared by both the Traditional and Online classes that are used by the program. It also implemts the abstract method conflictsWith() to allow all of the children classes to detect whether or not they conflict with each other. Here is the list of members, constructor, and abstract method from the Course class:

```java
 
  private String courseName;
  private int crnNumber;
  private String courseNumber;
  private String section;
  private int creditHours;
  private String instructor;
    
    ------------------------------------------------------------------------
    
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
  
  --------------------------------------------------------------------------
  
  public abstract boolean conflictsWith(Course c);

```
## TraditionalClass

The TraditionalClass class contains the most members out of any of the classes and has the longest conflictsWith() method in the program. Here are the members, constructor, and conflictsWith() logic for TraditionalClass:

```java
public class TraditionalClass extends Course {
    
    private LocalTime startTime;
    private LocalTime endTime;
    private String daysMet;
    private String location;
    private String classType;

    ----------------------------------------------------------------------
    
    
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
    
    -----------------------------------------------------------------------
    
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
```

The conflictsWith() method of the TraditionalClass class checks for conflictions five different ways after is has determined that two classes meet on the same days:
1. It checks if the first class starts before the second class, but ends during the second class.
2. It checks if the first class starts during the second class, but ends after the second class.
3. It checks if the first class starts after and ends before the second class.
4. It checks if the start times for both classes are equal.
5. It checks if the classes are the same class.

If any of these conditions are met, the conflictsWith() method returns true, and the program will not allow the user to register for the class that they chose.

Here is an example of the conflictsWith() method in use:

```java
      int conflictCounter = 0;
      for (Course course : actualSchedule){

          if(chosenCourse.conflictsWith(course) == false){
              ++conflictCounter;
          }

          else{
              System.out.println("Conflict Detected!");
              System.out.println();
          }
      }

      if(conflictCounter == actualSchedule.size()){
          actualSchedule.add(chosenCourse);
          System.out.println("Class Added!");
          System.out.println();
      }


  }
```

## OnlineClass

The OnlineClass class only contains one member that is not inherited from Course, which is the classtype. This member allows for easier parsing of the CSV file that the data for the program is read from as well as simplifying the conflicts with method. Here are the members, constructor, and conflictsWith() logic for OnlineClass:

```java

 public class OnlineClass extends Course{

     private String classtype;
    
-------------------------------------------------------------------------------------
 public OnlineClass(String newCourseName, int newCrnNumber,
    String newCourseNumber, String newSection, int newCreditHours,
    String newClassType,  String newInstructor){
        
        super(newCourseName, newCrnNumber, newCourseNumber, newSection,
                newCreditHours, newInstructor);
        
        this.classtype = newClassType;
                
-------------------------------------------------------------------------------------
@Override
    public boolean conflictsWith(Course c){
        
        boolean conflicts = false;
        
        if(this.getCrnNumber() == c.getCrnNumber()){
            conflicts = true;
        }
        
        return conflicts;
    }
```

The conflictsWith() method is much simpler for the online class since there is only one case to check for. The only way that an online class has a conflict is if the user attempts to register for the same class twice. Everything else does not conflict.

## How to use StudentRegistrationSystem

To run this program, the user needs java installed on their machine as well as access to the CSV file containing the courses that are used by the program. When the user runs the program, all of the classes are read into Course objects and added to an ArrayList. After this, the user can either search for courses, add a course to their schedule, view their trial schedule, or exit the program. To choose one of these options, the user would enter 1,2,3, or 4 respectivley and press ENTER. Following this, they would be guided by the program as to how to create their schedule. After the user has finished making hteir schedule, they would press 4, and the program will exit.












