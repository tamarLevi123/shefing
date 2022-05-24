package api;

import lombok.*;

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
        this.operator = OperatorEnum.tryValueOf(operator);
    }

}
