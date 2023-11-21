import java.util.ArrayList;
import java.util.List;

class Student{
  private int student_id;
  private String student_name;
  private List <Double> grades;

  public int getStudent_id(){
    return student_id;
  }

  public void setStudent_id(int student_id){
    this.student_id = student_id;
  }

  public String getStudent_name(){
    return student_name;
  }

  public void setStudent_name(String student_name){
    this.student_name = student_name;
  }

  public List <Double> getGrades(){
    return grades;
  }

  public void addGrade(double grade){
    if (grades == null) {
      grades = new ArrayList<>();
    }
    grades.add(grade);
  }
}

public class StudentClass {
  public static void main(String[] args) {
    Student student = new Student();
    student.setStudent_id(1);
    student.setStudent_name("Thomas Miloski");
    student.addGrade(90.5);
    student.addGrade(80.2);
    student.addGrade(72.8);
    int student_id = student.getStudent_id();
    String student_name = student.getStudent_name();
    List <Double> grades = student.getGrades();
    System.out.println("Student ID: " + student_id);
    System.out.println("Student Name: " + student_name);
    System.out.println("Grades: " + grades);
  }
}