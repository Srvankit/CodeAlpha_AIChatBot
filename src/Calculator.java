public class Calculator {

    public String solve(String expression) {

        try {

            expression =
                    expression.replaceAll("\\s", "");

            if (expression.isEmpty()) {

                return "Usage: calculate 25+15";
            }

            String[] num;

            // Addition

            if (expression.contains("+")) {

                num = expression.split("\\+");

                if (num.length != 2) {

                    return "Please enter only one operation.";
                }

                return "Result = " +
                        (Double.parseDouble(num[0])
                        + Double.parseDouble(num[1]));
            }

            // Subtraction

            if (expression.contains("-")) {

                num = expression.split("-");

                if (num.length != 2) {

                    return "Please enter only one operation.";
                }

                return "Result = " +
                        (Double.parseDouble(num[0])
                        - Double.parseDouble(num[1]));
            }

            // Multiplication

            if (expression.contains("*")) {

                num = expression.split("\\*");

                if (num.length != 2) {

                    return "Please enter only one operation.";
                }

                return "Result = " +
                        (Double.parseDouble(num[0])
                        * Double.parseDouble(num[1]));
            }

            // Division

            if (expression.contains("/")) {

                num = expression.split("/");

                if (num.length != 2) {

                    return "Please enter only one operation.";
                }

                double denominator =
                        Double.parseDouble(num[1]);

                if (denominator == 0) {

                    return "Cannot divide by zero.";
                }

                return "Result = " +
                        (Double.parseDouble(num[0])
                        / denominator);
            }

            return "Unsupported operation.";

        }

        catch (Exception e) {

            return "Invalid calculation.";
        }
    }
}