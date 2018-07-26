package hello;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.google.json.JsonSanitizer;
 
public class NoXssValidator implements ConstraintValidator<NoXss, String> {
 
 
   @Override
   public void initialize(NoXss constraintAnnotation) {
      // TODO specify the policy as an annotation attribute
      // to use them, values from annotation are stored in private properties here
   }
 
   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      String sanitized = JsonSanitizer.sanitize(value);
      return sanitized.equals(value);
   }
}
