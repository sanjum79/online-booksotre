package pk.snaseer.onlinebookstore.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pk.snaseer.onlinebookstore.entity.Book;

public class BookValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return Book.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {

		Book bookToValidate = (Book)o;

		if(checkInputString(bookToValidate.getName())) {
			errors.rejectValue("name", "name.empty");
		}

		if(checkInputString(bookToValidate.getImageUrl())) {
			errors.rejectValue("imageUrl", "imageUrl.empty");
		}
	}

	private boolean checkInputString(String inputString) {
		return (inputString == null || inputString.trim().length() == 0);
	}
}
