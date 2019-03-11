package tp_project_1;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;



public class TP_Project_1 {
    
    public static final int TRADITIONAL = 11;
    public static final int ONLINE = 7;
    
    public static void main(String[] args) throws IOException {
      
        Scanner input = new Scanner(Paths.get("project1input.csv"), "UTF-8");
        ArrayList<Course> catalouge = new ArrayList<>();

        while(input.hasNextLine()){
            
            String currentline = input.nextLine();
            String [] currentCourse = currentline.split("\t");
            
            if(currentCourse.length == TRADITIONAL){
                
                
                String [] start = currentCourse[5].split(":");
                String [] end = currentCourse[6].split(":");
                
                int startHour = Integer.parseInt(start[0]);
                int startMinute = Integer.parseInt(start[1]);
                
                int endHour = Integer.parseInt(end[0]);
                int endMinute = Integer.parseInt(end[1]);

                LocalTime newStrt = LocalTime.of(startHour, startMinute); 
                LocalTime newEnd = LocalTime.of(endHour, endMinute);

                
                String newCourse = currentCourse[0];
                int newCrn = Integer.parseInt(currentCourse[1]);
                String newCourseNum = currentCourse[2];
                String newSec = currentCourse[3];
                int newCredHrs = Integer.parseInt(currentCourse[4]);
                String newDaysMet = currentCourse[7];
                String newLocation = currentCourse[8];
                String newClsType = currentCourse[9];
                String newInstruct = currentCourse[10];
                
                TraditionalClass t = new TraditionalClass(newCourse,newCrn,
                newCourseNum,newSec,newCredHrs,newStrt,newEnd,
                newDaysMet,newLocation,newClsType,newInstruct);

                catalouge.add(t);

                }
                
            
            else if (currentCourse.length == ONLINE){
                
                String newCourse = currentCourse[0];
                int newCrn = Integer.parseInt(currentCourse[1]);
                String newCourseNum = currentCourse[2];
                String newSec = currentCourse[3];
                int newCredHrs = Integer.parseInt(currentCourse[4]);
                String newClssType = currentCourse[5];
                String newInstruct = currentCourse[6];
                
                OnlineClass o = new OnlineClass(newCourse,newCrn,newCourseNum,
                newSec,newCredHrs,newClssType,newInstruct);
                
                catalouge.add(o);
            }
            
  
        }
        
        boolean finishedSchedule = false;
        ArrayList<Course> actualSchedule = new ArrayList<>();
        
        
        System.out.println("Welcome to Registration!");
        System.out.println();
        
        
        while(!finishedSchedule){
            
            
            System.out.println("Please Choose one of the following options:");
            System.out.println("1) Search Courses");
            System.out.println("2) Register for Course");
            System.out.println("3) View Trial Schedule");
            System.out.println("4) Quit");
            System.out.print("Your Choice? ");
            
            Scanner s = new Scanner(System.in);
            int userChoice = s.nextInt();
            
            if (userChoice == 1){
                
                System.out.print("Please search for the class you want,"
                        + " Ex. CS 231: ");
                
                Scanner classPick = new Scanner(System.in);
                String classChoice = classPick.nextLine();
                
                ArrayList<Course> classOptions = new ArrayList<>();
                
                for (Course c : catalouge){
                    
                    if (c.getCourseNumber().equals(classChoice)){
                        
                        classOptions.add(c);
                    }
                }
                
                for (Course c : classOptions){
                    
                    System.out.println(c);
                }
            }
            
            if(userChoice == 2){
                
                System.out.print("Please enter the CRN number for the class"
                        + " you would like to add: ");
                
                Scanner crnPick = new Scanner(System.in);
                int crnChoice = crnPick.nextInt();
                
                for (Course c : catalouge){
                    
                    if(c.getCrnNumber() == crnChoice){
                        Course chosenCourse = c;
                    
                    
                        if(actualSchedule.isEmpty()){
                            actualSchedule.add(chosenCourse);
                            System.out.println("Class Added!");
                            System.out.println();
                        }
                        
                        else{
                            
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
                        
                    }
                    
                }
            }
            
            if(userChoice == 3){
                
                for (Course c : actualSchedule){
                    System.out.println(c);
                }
                
                System.out.println();
            }
            
            if(userChoice == 4){
                
                System.out.println("Goodbye!");
                
                finishedSchedule = true;
            }
        }

    }
    
}
