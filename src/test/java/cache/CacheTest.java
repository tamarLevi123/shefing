package cache;

import api.EquationInput;
import api.RestCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {RestCalculator.class, CacheCalculator.class})
public class CacheTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Autowired
    private RestCalculator restCalculator;

    @Test
    public void getEquation_callFunctionTwiceWithSameData_getSameResultFromCache(){
        EquationInput input = new EquationInput("divide", 5, 5);

        String equation1 = restCalculator.getEquation(input);
        String equation2 = restCalculator.getEquation(input);

        assertTrue(equation1.equals(equation2));
    }

    @Test
    public void getEquation_callFunctionTwiceWithSameData_getEquationFromCache(){
        EquationInput input = new EquationInput("divide", 5, 5);

        System.setOut(new PrintStream(out));
        String equation1 = restCalculator.getEquation(input);
        String equation2 = restCalculator.getEquation(input);

        assertTrue(out.toString().contains("get result from cache"));

        System.setOut(originalOut);
    }
}