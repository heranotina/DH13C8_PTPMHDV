package dh13c8.lab3.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import dh13c8.lab3.course;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository extends JpaRepository<course, Long> {
    boolean existsByTenMonHocIgnoreCase(String tenMonHoc);
    Page<course> findByTenMonHocContainingIgnoreCase(String keyword, Pageable pageable);
}
