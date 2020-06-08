package pk.snaseer.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.snaseer.onlinebookstore.entity.BookCategory;

public interface CategoryRepository extends JpaRepository<BookCategory, Long> {
}
