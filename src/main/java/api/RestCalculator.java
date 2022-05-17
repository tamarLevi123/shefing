package api;

import org.springframework.expression.spel.ExpressionState;
import org.springframework.expression.spel.ast.OpDivide;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/calculator")
@Service
public class RestCalculator {

    @PostMapping(value = "/getEquation")
    public String getEquation(@RequestBody EquationInput input) {
        String validationError = validateInput(input);
        if (validationError != null) {
            return validationError;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(input.getLeft())
                .append(input.getOperator().getOperatorString())
                .append(input.getRight())
                .append("=")
                .append(input.getOperator().getAccumulator().apply(input.getLeft(), input.getRight()));
        return sb.toString();
    }

    private String validateInput(EquationInput input) {
        if (input.getOperator() == null) {
            return "invalid operator name";
        } else if (input.getOperator() == OperatorEnum.divide && input.getRight() == 0) {
            return "invalid to divide with zero";
        }
        return null;
    }

    public static void main(String[] args) {
        EquationInput input = new EquationInput("tamar", 8, 0);
        String equation = new RestCalculator().getEquation(input);

        System.out.println(equation);
    }
}
