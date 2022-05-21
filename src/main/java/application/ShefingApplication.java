package application;

import api.RestCalculator;
import cache.CacheCalculator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackageClasses = {RestCalculator.class, CacheCalculator.class})
@ImportResource(value = "classpath:config.xml")
public class ShefingApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ShefingApplication.class).run(args);
    }

}
