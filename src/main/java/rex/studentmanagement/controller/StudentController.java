package rex.studentmanagement.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import rex.studentmanagement.entity.Student;
import rex.studentmanagement.service.StudentService;

@Controller 
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/student/new";
    }

    @GetMapping("/student")
    public String getStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student";
    }

    @GetMapping("/student/new")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return "redirect:/student";
        }
        model.addAttribute("student", student);
        return "student-form";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/student";
    }

    @GetMapping("/api/students")
    @ResponseBody
    public List<Student> getStudentsApi() {
        return studentService.getAllStudents();
    }
}
