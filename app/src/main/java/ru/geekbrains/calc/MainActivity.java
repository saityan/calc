package ru.geekbrains.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.darkmode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (getResources().getString(R.string.mode).equals("day mode"))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putString("EXPRESSION", this.data.getExpression());
        instanceState.putString("MEMORY", this.data.getMemory());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        this.data.add(instanceState.getString("EXPRESSION"));
        this.data.setMemory(instanceState.getString("MEMORY"));
        TextView screen = findViewById(R.id.view_screen);
        screen.setText(instanceState.getString("EXPRESSION"));
    }

    private void init() {
        TextView screen = findViewById(R.id.view_screen);
        Button button_0 = findViewById(R.id.button_0);
        Button button_1 = findViewById(R.id.button_1);
        Button button_2 = findViewById(R.id.button_2);
        Button button_3 = findViewById(R.id.button_3);
        Button button_4 = findViewById(R.id.button_4);
        Button button_5 = findViewById(R.id.button_5);
        Button button_6 = findViewById(R.id.button_6);
        Button button_7 = findViewById(R.id.button_7);
        Button button_8 = findViewById(R.id.button_8);
        Button button_9 = findViewById(R.id.button_9);
        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonSubtract = findViewById(R.id.button_subtract);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);
        Button buttonPoint = findViewById(R.id.button_point);
        Button buttonClear = findViewById(R.id.button_clear);
        Button buttonBackspace = findViewById(R.id.button_backspace);
        Button buttonMemory = findViewById(R.id.button_memory);
        Button buttonRestore = findViewById(R.id.button_restore);
        Button buttonEqual = findViewById(R.id.button_equal);

        button_0.setOnClickListener(v -> {
            this.data.add("0");
            screen.setText(this.data.getExpression());
        });
        button_1.setOnClickListener(v -> {
            this.data.add("1");
            screen.setText(this.data.getExpression());
        });
        button_2.setOnClickListener(v -> {
            this.data.add("2");
            screen.setText(this.data.getExpression());
        });
        button_3.setOnClickListener(v -> {
            this.data.add("3");
            screen.setText(this.data.getExpression());
        });
        button_4.setOnClickListener(v -> {
            this.data.add("4");
            screen.setText(this.data.getExpression());
        });
        button_5.setOnClickListener(v -> {
            this.data.add("5");
            screen.setText(this.data.getExpression());
        });
        button_6.setOnClickListener(v -> {
            this.data.add("6");
            screen.setText(this.data.getExpression());
        });
        button_7.setOnClickListener(v -> {
            this.data.add("7");
            screen.setText(this.data.getExpression());
        });
        button_8.setOnClickListener(v -> {
            this.data.add("8");
            screen.setText(this.data.getExpression());
        });
        button_9.setOnClickListener(v -> {
            this.data.add("9");
            screen.setText(this.data.getExpression());
        });
        buttonAdd.setOnClickListener(v -> {
            this.data.add("+");
            screen.setText(this.data.getExpression());
        });
        buttonSubtract.setOnClickListener(v -> {
            this.data.add("-");
            screen.setText(this.data.getExpression());
        });
        buttonMultiply.setOnClickListener(v -> {
            this.data.add("*");
            screen.setText(this.data.getExpression());
        });
        buttonDivide.setOnClickListener(v -> {
            this.data.add("/");
            screen.setText(this.data.getExpression());
        });
        buttonPoint.setOnClickListener(v -> {
            this.data.add(".");
            screen.setText(this.data.getExpression());
        });
        buttonClear.setOnClickListener(v -> {
            this.data.clear();
            screen.setText(this.data.getExpression());
        });
        buttonBackspace.setOnClickListener(v -> {
            this.data.backspace();
            screen.setText(this.data.getExpression());
        });
        buttonMemory.setOnClickListener(v -> {
            this.data.setMemory(this.data.getExpression());
            screen.setText(this.data.getExpression());
        });
        buttonRestore.setOnClickListener(v -> {
            this.data.restore();
            screen.setText(this.data.getExpression());
        });
        buttonEqual.setOnClickListener(v -> {
            this.data.compute();
            screen.setText(this.data.getExpression());
        });
    }
}