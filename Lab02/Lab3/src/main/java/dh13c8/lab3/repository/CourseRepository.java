package dh13c8.lab3.repository;

import dh13c8.lab3.course;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository extends JpaRepository<course, Long> {
    boolean existsByTenMonHocIgnoreCase(String tenMonHoc);
}
