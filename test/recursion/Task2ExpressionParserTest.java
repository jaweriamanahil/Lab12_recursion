package recursion;

import org.junit.Test;
import static org.junit.Assert.*;

public class Task2ExpressionParserTest {

    @Test
    public void testEvaluateExpressionWithParentheses() {
        String expression = "(3 + 5) * 2";
        double result = Task2ExpressionParser.evaluateExpression(expression);
        assertEquals("The result should be 16.0", 16.0, result, 0.0001);
    }

    @Test
    public void testEvaluateExpressionSingleNumber() {
        String expression = "5";
        double result = Task2ExpressionParser.evaluateExpression(expression);
        assertEquals("The result should be 5.0", 5.0, result, 0.0001);
    }

    @Test
    public void testEvaluateExpressionWithDecimal() {
        String expression = "3.5 + 2.5";
        double result = Task2ExpressionParser.evaluateExpression(expression);
        assertEquals("The result should be 6.0", 6.0, result, 0.0001);
    }

    @Test
    public void testEvaluateExpressionWithDivision() {
        String expression = "6 / 2";
        double result = Task2ExpressionParser.evaluateExpression(expression);
        assertEquals("The result should be 3.0", 3.0, result, 0.0001);
    }

    @Test
    public void testEvaluateExpressionWithMultipleOperators() {
        String expression = "10 + 2 * 5 - 3";
        double result = Task2ExpressionParser.evaluateExpression(expression);
        assertEquals("The result should be 17.0", 17.0, result, 0.0001);
    }

    @Test
    public void testEvaluateExpressionWithNestedParentheses() {
        String expression = "(3 + (2 * 5)) * 2";
        double result = Task2ExpressionParser.evaluateExpression(expression);
        assertEquals("The result should be 26.0", 26.0, result, 0.0001);
    }

    @Test
    public void testEvaluateExpressionWithNegativeNumbers() {
        String expression = "-3 + 5 * -2";
        double result = Task2ExpressionParser.evaluateExpression(expression);
        assertEquals("The result should be -13.0", -13.0, result, 0.0001);
    }

    @Test
    public void testEvaluateExpressionDivisionByZero() {
        String expression = "10 / 0";
        try {
            Task2ExpressionParser.evaluateExpression(expression);
            fail("Expected ArithmeticException for division by zero");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero is not allowed.", e.getMessage());
        }
    }

    @Test
    public void testEvaluateExpressionInvalidInput() {
        String expression = "5 + ";
        try {
            Task2ExpressionParser.evaluateExpression(expression);
            fail("Expected IllegalArgumentException for invalid input");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Invalid expression"));
        }
    }
}

