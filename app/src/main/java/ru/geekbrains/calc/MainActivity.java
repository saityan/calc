package ru.geekbrains.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;

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
        instanceState.putString("Expression", this.data.get());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        this.data.add(instanceState.getString("Expression"));

        Toast.makeText(this, data.get(), Toast.LENGTH_LONG).show();
    }

    protected void init() {
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
        Button button_add = findViewById(R.id.button_add);
        Button button_subtract = findViewById(R.id.button_subtract);
        Button button_multiply = findViewById(R.id.button_multiply);
        Button button_divide = findViewById(R.id.button_divide);
        Button button_equal = findViewById(R.id.button_equal);
        Button button_point = findViewById(R.id.button_point);

        button_0.setOnClickListener(v -> data.add("0"));
        button_1.setOnClickListener(v -> data.add("1"));
        button_2.setOnClickListener(v -> data.add("2"));
        button_3.setOnClickListener(v -> data.add("3"));
        button_4.setOnClickListener(v -> data.add("4"));
        button_5.setOnClickListener(v -> data.add("5"));
        button_6.setOnClickListener(v -> data.add("6"));
        button_7.setOnClickListener(v -> data.add("7"));
        button_8.setOnClickListener(v -> data.add("8"));
        button_9.setOnClickListener(v -> data.add("9"));
        button_add.setOnClickListener(v -> data.add("+"));
        button_subtract.setOnClickListener(v -> data.add("-"));
        button_multiply.setOnClickListener(v -> data.add("*"));
        button_divide.setOnClickListener(v -> data.add("/"));
        button_equal.setOnClickListener(v -> data.add("="));
        button_point.setOnClickListener(v -> data.add("."));
    }
}