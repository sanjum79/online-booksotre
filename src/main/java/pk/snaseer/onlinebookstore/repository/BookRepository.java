package pk.snaseer.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pk.snaseer.onlinebookstore.entity.Book;

//@RepositoryRestResource(collectionResourceRel = "bookCategory", path = "book-category")
public interface BookRepository extends JpaRepository<Book, Long> {
}
