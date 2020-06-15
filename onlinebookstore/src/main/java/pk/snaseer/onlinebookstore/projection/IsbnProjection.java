package pk.snaseer.onlinebookstore.projection;

import org.springframework.data.rest.core.config.Projection;
import pk.snaseer.onlinebookstore.entity.Book;

@Projection(name = "showIsbn", types = {Book.class})
public interface IsbnProjection {

	String getIsbn();
}
