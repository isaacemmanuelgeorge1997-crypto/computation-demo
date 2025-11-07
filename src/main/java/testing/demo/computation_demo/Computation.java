package computation;

public class Computation {

    public String checkNumber(int num) {
        if (num > 0) {
            return "Positive";
        } else if (num < 0) {
            return "Negative";
        } else {
            return "Zero";
        }
    }

    public int add(int a, int b) {
        return a + b;
    }
}
