package app;

public class Student {
  String sid;
  String fname;
  String lname;
  String email;
  String phone;
  double GPA;
  int classLevel;
      
  public Student(String sid, String fname, String lname,
                 String email, String phone, double gpa, int level){
     this.sid=sid;
     this.fname=fname;
     this.lname=lname;
     this.email=email;
     this.phone=phone;
     this.GPA=gpa;
     this.classLevel=level;
  }

  public String getSID() {
     return sid;
  }

  public String getFirstName() {
     return fname;
  }
  
  public String getLastName() {
     return lname;
  }
  
  public String getEmail() {
     return email;
  }
  
  public String getPhone() {
     return phone;
  }
  
  public double getGPA() {
     return GPA;
  }
  
  public int getClassLevel() {
     return classLevel;
  }

  public boolean equals(Object obj){
     Student other = (Student) obj;
     return (this.sid.equals(other.getSID()));
  }
  
  public String toString(){
     return sid+" "+fname+" "+lname+" "+email+" "+phone+" "+GPA+" "+classLevel+"\n";
  }
}