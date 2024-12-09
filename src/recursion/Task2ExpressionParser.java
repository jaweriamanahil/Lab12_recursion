package recursion;

import java.util.Scanner;

public class Task2ExpressionParser {

    // Recursive evaluation of a mathematical expression
    public static double evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s", ""); // Remove spaces
        return parseExpression(expression);
    }

    private static double parseExpression(String expression) {
        // Base case: If the expression is just a number (could be negative or floating-point)
        if (expression.matches("-?\\d+(\\.\\d+)?")) {
            return Double.parseDouble(expression);
        }

        // Handle parentheses: Find the innermost pair and evaluate it
        if (expression.contains("(")) {
            int openIndex = expression.lastIndexOf('(');
            int closeIndex = expression.indexOf(')', openIndex);

            if (openIndex != -1 && closeIndex != -1) {
                String insideParentheses = expression.substring(openIndex + 1, closeIndex);
                double resultInsideParentheses = parseExpression(insideParentheses);
                // Replace the parentheses with their evaluated result
                expression = expression.substring(0, openIndex) + resultInsideParentheses + expression.substring(closeIndex + 1);
                return parseExpression(expression);  // Recurse after replacing
            }
        }

        // Handle addition and subtraction (left to right)
        if (expression.contains("+") || expression.contains("-")) {
            int index = findOperatorIndex(expression, "+", "-");
            if (index != -1) {
                char operator = expression.charAt(index);
                if (operator == '+') {
                    return parseExpression(expression.substring(0, index)) + parseExpression(expression.substring(index + 1));
                } else if (operator == '-') {
                    return parseExpression(expression.substring(0, index)) - parseExpression(expression.substring(index + 1));
                }
            }
        }

        // Handle multiplication and division (left to right)
        if (expression.contains("*") || expression.contains("/")) {
            int index = findOperatorIndex(expression, "*", "/");
            if (index != -1) {
                char operator = expression.charAt(index);
                if (operator == '*') {
                    return parseExpression(expression.substring(0, index)) * parseExpression(expression.substring(index + 1));
                } else if (operator == '/') {
                    double denominator = parseExpression(expression.substring(index + 1));
                    if (denominator == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    return parseExpression(expression.substring(0, index)) / denominator;
                }
            }
        }

        throw new IllegalArgumentException("Invalid expression: " + expression);
    }

    private static int findOperatorIndex(String expression, String operator1, String operator2) {
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // Ignore operators inside parentheses
            if (currentChar == '(') {
                int closingIndex = findClosingParenthesis(expression, i);
                if (closingIndex != -1) {
                    i = closingIndex; // Skip the entire parenthesis block
                }
            } else if ((currentChar == operator1.charAt(0) || currentChar == operator2.charAt(0))) {
                // Check that this is not part of a negative number
                if (i == 0 || (expression.charAt(i - 1) != '(' && !Character.isDigit(expression.charAt(i - 1)))) {
                    continue; // Skip as this is part of a negative number
                }
                return i; // Valid operator found
            }
        }
        return -1; // No valid operator found
    }

    private static int findClosingParenthesis(String expression, int openIndex) {
        int count = 0;
        for (int i = openIndex; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') count++;
            if (expression.charAt(i) == ')') count--;
            if (count == 0) return i; // Found the closing parenthesis
        }
        return -1; // No closing parenthesis found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mathematical expression to evaluate:");

        // Take user input for the expression
        String expression = scanner.nextLine();

        try {
            // Evaluate the expression
            double result = evaluateExpression(expression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            // Handle errors (e.g., invalid expression)
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
