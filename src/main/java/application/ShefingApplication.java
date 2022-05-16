package application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = {"api"})
public class ShefingApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ShefingApplication.class).run(args);
    }
}
