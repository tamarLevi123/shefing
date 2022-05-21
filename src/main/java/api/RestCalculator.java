package api;

import cache.MyCacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calculator")
@Service
public class RestCalculator {

    @MyCacheable
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
        addDecimalFraction(sb,input);
        return sb.toString();
    }

    private void addDecimalFraction(StringBuilder sb, EquationInput input) {
        if (input.getOperator() == OperatorEnum.divide
                && input.getLeft() % input.getRight() != 0) {
            sb.append(".").append(input.getLeft() % input.getRight() *10 / input.getRight());
        }
    }

    private String validateInput(EquationInput input) {
        if (input == null) {
            return "";
        }
        if (input.getOperator() == null) {
            return "invalid operator name";
        }
        if (input.getOperator() == OperatorEnum.divide && input.getRight() == 0) {
            return "invalid to divide with zero";
        }
        return null;
    }

}
