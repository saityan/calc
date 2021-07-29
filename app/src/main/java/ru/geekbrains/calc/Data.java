package ru.geekbrains.calc;

class Data {
    private StringBuilder expression;
    private String memory;

    Data() {
        this.expression = new StringBuilder();
        this.memory = "";
    }

    void add(String s) {
        if (s.length() > 0)
            this.expression.append(s);
    }

    String getExpression () { return this.expression.toString(); }

    String getMemory () { return this.memory; }

    void setMemory (String memory) { this.memory = memory; }

    void compute() { /*add regex here*/ }

    void clear() { this.expression.setLength(0); }

    void restore() {
        if (this.memory.length() > 0)
        this.expression.append(this.memory);
    }

    void backspace() {
        if (this.expression.length() > 0)
            this.expression.setLength(this.expression.length() - 1);
    }
}
