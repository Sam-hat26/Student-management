package rex.studentmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Student {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String studentName;
    private String gender;
    private String email;
    private String mobilno;
    private String course;
    private String semester;
    private String comment;
    
    public Student() {
    }
    
    public Student(String studentName, String gender, String email, String mobilno, String course, String semester, String comment) {
        this.studentName = studentName;
        this.gender = gender;
        this.email = email;
        this.mobilno = mobilno;
        this.course = course;
        this.semester = semester;
        this.comment = comment;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMobilno() {
        return mobilno;
    }
    
    public void setMobilno(String mobilno) {
        this.mobilno = mobilno;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
}
