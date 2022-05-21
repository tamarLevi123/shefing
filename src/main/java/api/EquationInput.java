package api;

import com.sun.org.apache.xpath.internal.operations.Number;
import lombok.*;
import org.springframework.expression.spel.ast.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class EquationInput {
    private OperatorEnum operator;
    private int left;
    private int right;

    public EquationInput(String operator, int left, int right) {
        this.left = left;
        this.right = right;
        setOperator(operator);
    }

    public void setOperator(String operator) {
        switch (operator){
            case "plus": this.operator = OperatorEnum.plus; break;
            case "minus": this.operator = OperatorEnum.minus; break;
            case "multiply": this.operator = OperatorEnum.multiply; break;
            case "divide": this.operator = OperatorEnum.divide; break;
        }
    }
}
