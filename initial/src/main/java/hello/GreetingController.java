package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;
import com.google.json.JsonSanitizer;
import javax.validation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @PostMapping("/greeting")
    public Greeting createGreeting(@RequestBody @Valid Greeting greeting) {
        return new Greeting(greeting.getId(), content);
    }
    
    @PostMapping("/unsafeGreeting")
    public Greeting createUnsafeGreeting(@RequestBody Greeting greeting) {
        return new Greeting(greeting.getId(), content);
    }
}
