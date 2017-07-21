package de.codecentric.psd.worblehat.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsTrueConstraintValidator implements ConstraintValidator<IsTrue, Boolean> {

	@Override
	public void initialize(IsTrue constraintAnnotation) {
	}

	@Override
	public boolean isValid(Boolean value, ConstraintValidatorContext context) {
		// Don't validate null, empty and blank strings, since these are
		// validated by @NotNull, @NotEmpty and @NotBlank

		if (value == true) {
			return true;
		} else {
			return false;
		}
	}

}
