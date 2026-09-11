package rex.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rex.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    

}
