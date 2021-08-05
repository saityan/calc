package ru.geekbrains.calc;

class Data {
    private StringBuilder expression;
    private String memory;

    Data() {
        this.expression = new StringBuilder();
        this.memory = "";
    }

    void add(String s) {
        if (s.length() > 0 && this.expression.length() < 32) {
            if (!isDigitLast() && s.matches("[*/+.-]"))
                return;
            if (s.equals(".") && !isPointEligible())
                return;
            this.expression.append(s);
        }
    }

    String getExpression () { return this.expression.toString(); }

    String getMemory () { return this.memory; }

    void setMemory (String memory) {
        if (memory.length() > 0)
            this.memory = memory;
    }

    void compute() {

    }

    void clear() { this.expression.setLength(0); }

    void restore() {
        if (this.memory.length() > 0 && (this.memory.length() + this.expression.length()) < 32)
        this.expression.append(this.memory);
    }

    void backspace() {
        if (this.expression.length() > 0)
            this.expression.setLength(this.expression.length() - 1);
    }

    private boolean isExpressionEmpty() {
        return this.getExpression().length() == 0;
    }

    private boolean isDigitLast() {
        return !isExpressionEmpty() && this.getExpression().substring(
                this.getExpression().length() - 1).matches("[0-9]");
    }

    private boolean isPointEligible() {
        String sample = this.getExpression();
        if (sample.length() > 0) {
            if (sample.lastIndexOf('*') > sample.lastIndexOf('.'))
                return true;
            if (sample.lastIndexOf('+') > sample.lastIndexOf('.'))
                return true;
            if (sample.lastIndexOf('-') > sample.lastIndexOf('.'))
                return true;
            if (sample.lastIndexOf('/') > sample.lastIndexOf('.'))
                return true;
            return !sample.contains("*") && !sample.contains("+") &&
                    !sample.contains("-") && !sample.contains("/") && !sample.contains(".");
        }
        return false;
    }
}
