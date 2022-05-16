package api;

import lombok.*;
import org.springframework.expression.spel.ast.Operator;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EquationInput {
    String operator;
    int left;
    int right;
}
