package pk.snaseer.onlinebookstore.projection;

import org.springframework.data.rest.core.config.Projection;
import pk.snaseer.onlinebookstore.entity.Book;

@Projection(name = "noCategory", types = {Book.class})
public interface NoCategory {
	Long getId();
	String getName();
	String getDescription();
	String getImageUrl();
}
