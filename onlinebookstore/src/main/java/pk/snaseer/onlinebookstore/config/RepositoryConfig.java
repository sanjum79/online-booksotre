package pk.snaseer.onlinebookstore.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import pk.snaseer.onlinebookstore.entity.Book;
import pk.snaseer.onlinebookstore.projection.IsbnProjection;
import pk.snaseer.onlinebookstore.projection.NoCategory;
import pk.snaseer.onlinebookstore.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
		.map(Type::getJavaType)
		.toArray(Class[]::new));

		config.getProjectionConfiguration().addProjection(NoCategory.class, IsbnProjection.class);

		config.withEntityLookup().forLookupRepository(BookRepository.class)
			  .withIdMapping(Book::getName)
			  .withLookup(BookRepository::findByName);
	}

	@Override
	public void configureJacksonObjectMapper(ObjectMapper objectMapper) {

	}
}
