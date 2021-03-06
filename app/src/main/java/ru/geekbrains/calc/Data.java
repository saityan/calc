package ru.geekbrains.calc;

import java.util.Arrays;
import java.util.LinkedList;

class Data {
    private StringBuilder expression;
    private String memory;

    Data() {
        this.expression = new StringBuilder();
        this.memory = "";
    }

    void add(String s) {
        if (s.length() > 0 && this.expression.length() < 32) {
            if (this.getExpression().equals("Infinity"))
                return;
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
        if (memory.length() > 0) {
            if ((memory.charAt(0) == '-') || memory.equals("Infinity"))
                return;
            if (memory.substring(0, 1).matches("[*/+.-]"))
                memory = memory.substring(1);
            this.memory = memory;
        }
    }

    void compute() {
        if (!isExpressionEmpty()) {
            LinkedList <String> sample = new LinkedList<>(Arrays.asList(this.getExpression().split(
                    "(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])")));
            String last = sample.get(sample.size() - 1);
            if (last.matches("[*/+-]"))
                sample.removeLast();
            if (last.charAt(last.length() - 1) == '.') {
                sample.set(sample.size() - 1, last.substring(0, last.length() - 1));
            }
            if (sample.getFirst().equals("-")) {
                sample.remove(0);
                String temp = "-" + sample.getFirst();
                sample.set(0, temp);
            if (sample.size() < 3)
                return;
            }
            search: while (sample.size() > 1) {
                for (int i = 0; i < sample.size(); i++) {
                    if (sample.get(i).matches("[*/]")) {
                        double a = Double.parseDouble(sample.get(i - 1));
                        double b = Double.parseDouble(sample.get(i + 1));
                        double result;
                        if (sample.get(i).equals("*")) {
                            result = a * b;
                            sample.set(i - 1, String.valueOf(result));
                            sample.remove(i + 1);
                            sample.remove(i);
                            continue search;
                        } else if (sample.get(i).equals("/")) {
                            if (b == 0.0) {
                                this.expression.setLength(0);
                                this.expression.append("Infinity");
                                return;
                            }
                            result = a / b;
                            sample.set(i - 1, String.valueOf(result));
                            sample.remove(i + 1);
                            sample.remove(i);
                            continue search;
                        }
                    }
                }
                for (int i = 0; i < sample.size(); i++) {
                    if (sample.get(i).matches("[+-]")) {
                        double a = Double.parseDouble(sample.get(i - 1));
                        double b = Double.parseDouble(sample.get(i + 1));
                        double result;
                        if (sample.get(i).equals("+")) {
                            result = a + b;
                            sample.set(i - 1, String.valueOf(result));
                            sample.remove(i + 1);
                            sample.remove(i);
                            continue search;
                        } else if (sample.get(i).equals("-")) {
                            result = a - b;
                            sample.set(i - 1, String.valueOf(result));
                            sample.remove(i + 1);
                            sample.remove(i);
                            continue search;
                        }
                    }
                }
            }
            double result = Double.parseDouble(sample.get(0));
            this.expression.setLength(0);
            if (Math.ceil(result) == Math.floor(result))
                this.expression.append((int) result);
            else
                this.expression.append(result);
        }
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
        if (!isExpressionEmpty()) {
            String sample = this.getExpression();
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
