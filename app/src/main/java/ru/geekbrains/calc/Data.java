package ru.geekbrains.calc;

class Data {
    private StringBuilder expression;

    Data() {
        this.expression = new StringBuilder();
    }

    Data(String s) {
        this.expression = new StringBuilder().append(s);
    }

    void add(String s) {
        this.expression.append(s);
    }

    String get () { return this.expression.toString(); }
}
