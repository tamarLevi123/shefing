package application;

import api.RestCalculator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackageClasses = {RestCalculator.class})
public class ShefingApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ShefingApplication.class).run(args);
    }

}
