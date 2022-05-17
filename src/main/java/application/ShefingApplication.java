package application;

import api.RestCalculator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackageClasses = {RestCalculator.class})
public class ShefingApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ShefingApplication.class).run(args);
    }

}
