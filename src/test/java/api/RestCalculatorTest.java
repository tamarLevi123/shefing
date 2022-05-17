package api;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RestCalculatorTest {

    @InjectMocks
    private RestCalculator restCalculator;

    @Test
    public void getEquation_null_emptyString(){
        String equation = restCalculator.getEquation(null);

        assertEquals("",equation);
    }
    @Test
    public void getEquation_wrongOpertor_errorString(){
        EquationInput input = new EquationInput("tamar", 5, 7);

        String equation = restCalculator.getEquation(input);

        assertEquals("invalid operator name",equation);
    }
    @Test
    public void getEquation_plusOperator_plusEquation(){
        EquationInput input = new EquationInput("plus", 5, 7);

        String equation = restCalculator.getEquation(input);

        assertEquals("5+7=12",equation);
    }
    @Test
    public void getEquation_minusOperator_minusEquation(){
        EquationInput input = new EquationInput("minus", 5, 7);

        String equation = restCalculator.getEquation(input);

        assertEquals("5-7=-2",equation);
    }
    @Test
    public void getEquation_multiplyOperator_multiplyEquation(){
        EquationInput input = new EquationInput("multiply", 5, 7);

        String equation = restCalculator.getEquation(input);

        assertEquals("5*7=35",equation);
    }
    @Test
    public void getEquation_divideOperator_divideEquation(){
        EquationInput input = new EquationInput("divide", 6, 3);

        String equation = restCalculator.getEquation(input);

        assertEquals("6/3=2",equation);
    }
//    @Test
//    public void getEquation_divideOperator_divideEquation(){
//        EquationInput input = new EquationInput("divide", 6, 4);
//
//        String equation = restCalculator.getEquation(input);
//
//        assertEquals("6/4=1.5",equation);
//    }
    @Test
    public void getEquation_divideBy0_errorString(){
        EquationInput input = new EquationInput("divide", 5, 0);

        String equation = restCalculator.getEquation(input);

        assertEquals("invalid to divide with zero",equation);
    }

}
