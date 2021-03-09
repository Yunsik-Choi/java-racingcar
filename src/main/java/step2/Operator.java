package step2;

import java.util.Arrays;

import static step2.Constants.ILLEGAL_ARGUMENT_EXCEPTION_SUPPLIER;
import static step2.Validator.isDivideByZero;

/**
 * 상태와 행위를 한 곳에서 관리하기 위한 enum 활용
 */
public enum Operator {

    PLUS("+", Integer::sum), // 람다 -> 메서드 레퍼런스로 변경 가능
    SUBTRACT("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> {
        isDivideByZero(a);
        return (a / b);
    });

    private final String operator;
    private final OperatorInterface operatorInterface;

    Operator(String operator, OperatorInterface formula) {
        this.operator = operator;
        this.operatorInterface = formula;
    }

    public Integer calculate(Integer a, Integer b) {
        return operatorInterface.apply(a, b);
    }

    // 넘어온 문자가 사칙 연산에 존재하는 경우 해당 연산자를 반환
    public static Operator getOperator(String operation) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.getOperator().equals(operation))
                .findAny()
                .orElseThrow(ILLEGAL_ARGUMENT_EXCEPTION_SUPPLIER);
    }

    private String getOperator() {
        return operator;
    }

    // 사칙연산에 대한 리스트를 반환할 필요없이 유효성 검사 코드를 여기서 관리
    public static boolean isOperation(String operation) {
        return Arrays.stream(Operator.values())
                .anyMatch(o -> o.getOperator().equals(operation));
    }
}