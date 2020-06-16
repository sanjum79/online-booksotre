package pk.snaseer.onlinebookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pk.snaseer.onlinebookstore.entity.Book;

@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository<Book, Long> {

	@RestResource(path = "categoryid")
	Page<Book> findByCategoryId(@Param("id")Long id, Pageable pageable);

	@RestResource(path = "searchbykeyword")
	Page<Book> findByNameContaining(@Param("name") String keyword, Pageable pageable);

//	@RestResource(path = "bookname", rel = "name", exported = false)
//	Book findByName(@Param("name")String name);
}
