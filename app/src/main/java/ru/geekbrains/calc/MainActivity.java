package ru.geekbrains.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
        TextView screen = (TextView) findViewById(R.id.view_screen);
        screen.setText(instanceState.getString("EXPRESSION"));
    }

    private void init() {
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

        button_0.setOnClickListener(v -> this.data.add("0"));
        button_1.setOnClickListener(v -> this.data.add("1"));
        button_2.setOnClickListener(v -> this.data.add("2"));
        button_3.setOnClickListener(v -> this.data.add("3"));
        button_4.setOnClickListener(v -> this.data.add("4"));
        button_5.setOnClickListener(v -> this.data.add("5"));
        button_6.setOnClickListener(v -> this.data.add("6"));
        button_7.setOnClickListener(v -> this.data.add("7"));
        button_8.setOnClickListener(v -> this.data.add("8"));
        button_9.setOnClickListener(v -> this.data.add("9"));
        buttonAdd.setOnClickListener(v -> this.data.add("+"));
        buttonSubtract.setOnClickListener(v -> this.data.add("-"));
        buttonMultiply.setOnClickListener(v -> this.data.add("*"));
        buttonDivide.setOnClickListener(v -> this.data.add("/"));
        buttonPoint.setOnClickListener(v -> this.data.add("."));
        buttonClear.setOnClickListener(v -> this.data.clear());
        buttonBackspace.setOnClickListener(v -> this.data.backspace());
        buttonMemory.setOnClickListener(v -> this.data.setMemory(this.data.getExpression()));
        buttonRestore.setOnClickListener(v -> this.data.restore());
        buttonEqual.setOnClickListener(v -> this.data.compute());
    }
}