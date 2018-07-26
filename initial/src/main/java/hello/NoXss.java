package hello;

import java.lang.annotation.*;
import javax.validation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoXssValidator.class)
public @interface NoXss {
    String message() default "Bad Xss";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
