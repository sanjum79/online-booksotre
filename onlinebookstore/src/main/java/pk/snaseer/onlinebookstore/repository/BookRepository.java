package pk.snaseer.onlinebookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pk.snaseer.onlinebookstore.entity.Book;

//@RepositoryRestResource(collectionResourceRel = "bookCategory", path = "book-category")
@CrossOrigin("http://localhost:4200")
public interface BookRepository extends JpaRepository<Book, Long> {

	@RestResource(path = "categoryid")
	Page<Book> findByCategoryId(@Param("id") Long id, Pageable pageable);
}
