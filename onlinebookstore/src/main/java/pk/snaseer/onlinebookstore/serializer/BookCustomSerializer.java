package pk.snaseer.onlinebookstore.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pk.snaseer.onlinebookstore.entity.Book;

import java.io.IOException;

public class BookCustomSerializer extends StdSerializer<Book> {

	public BookCustomSerializer() {
		this(null);
	}

	public BookCustomSerializer(Class<Book> t) {
		super(t);
	}

	@Override
	public void serialize(Book book, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("id", book.getId());
		jsonGenerator.writeStringField("bookName", book.getName());
		jsonGenerator.writeStringField("description", book.getDescription());
		jsonGenerator.writeStringField("imageUrl", book.getImageUrl());
		jsonGenerator.writeNumberField("categoryId", book.getCategory().getId());
		jsonGenerator.writeEndObject();
	}
}
