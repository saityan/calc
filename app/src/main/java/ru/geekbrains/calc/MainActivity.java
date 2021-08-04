package ru.geekbrains.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Data data;
    private TextView screen;
    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button buttonAdd;
    private Button buttonSubtract;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonPoint;
    private Button buttonClear;
    private Button buttonBackspace;
    private Button buttonMemory;
    private Button buttonRestore;
    private Button buttonEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initState();
        this.initListeners();
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == this.button_0.getId())
            this.data.add("0");
        else if (id == this.button_1.getId())
            this.data.add("1");
        else if (id == this.button_2.getId())
            this.data.add("2");
        else if (id == this.button_3.getId())
            this.data.add("3");
        else if (id == this.button_4.getId())
            this.data.add("4");
        else if (id == this.button_5.getId())
            this.data.add("5");
        else if (id == this.button_6.getId())
            this.data.add("6");
        else if (id == this.button_7.getId())
            this.data.add("7");
        else if (id == this.button_8.getId())
            this.data.add("8");
        else if (id == this.button_9.getId())
            this.data.add("9");
        else if (id == this.buttonAdd.getId())
            this.data.add("+");
        else if (id == this.buttonSubtract.getId())
            this.data.add("-");
        else if (id == this.buttonMultiply.getId())
            this.data.add("*");
        else if (id == this.buttonDivide.getId())
            this.data.add("/");
        else if (id == this.buttonPoint.getId())
            this.data.add(".");
        else if (id == this.buttonClear.getId())
            this.data.clear();
        else if (id == this.buttonBackspace.getId())
            this.data.backspace();
        else if (id == this.buttonMemory.getId())
            this.data.setMemory(this.data.getExpression());
        else if (id == this.buttonRestore.getId())
            this.data.restore();
        else if (id == this.buttonEqual.getId())
            this.data.compute();
        screen.setText(this.data.getExpression());
    }

    private void initState() {
        this.data = new Data();
        this.screen = findViewById(R.id.view_screen);
        this.button_0 = findViewById(R.id.button_0);
        this.button_1 = findViewById(R.id.button_1);
        this.button_2 = findViewById(R.id.button_2);
        this.button_3 = findViewById(R.id.button_3);
        this.button_4 = findViewById(R.id.button_4);
        this.button_5 = findViewById(R.id.button_5);
        this.button_6 = findViewById(R.id.button_6);
        this.button_7 = findViewById(R.id.button_7);
        this.button_8 = findViewById(R.id.button_8);
        this.button_9 = findViewById(R.id.button_9);
        this.buttonAdd = findViewById(R.id.button_add);
        this.buttonSubtract = findViewById(R.id.button_subtract);
        this.buttonMultiply = findViewById(R.id.button_multiply);
        this.buttonDivide = findViewById(R.id.button_divide);
        this.buttonPoint = findViewById(R.id.button_point);
        this.buttonClear = findViewById(R.id.button_clear);
        this.buttonBackspace = findViewById(R.id.button_backspace);
        this.buttonMemory = findViewById(R.id.button_memory);
        this.buttonRestore = findViewById(R.id.button_restore);
        this.buttonEqual = findViewById(R.id.button_equal);
    }

    private void initListeners() {
        this.button_0.setOnClickListener(this);
        this.button_1.setOnClickListener(this);
        this.button_2.setOnClickListener(this);
        this.button_3.setOnClickListener(this);
        this.button_4.setOnClickListener(this);
        this.button_5.setOnClickListener(this);
        this.button_6.setOnClickListener(this);
        this.button_7.setOnClickListener(this);
        this.button_8.setOnClickListener(this);
        this.button_9.setOnClickListener(this);
        this.buttonAdd.setOnClickListener(this);
        this.buttonSubtract.setOnClickListener(this);
        this.buttonMultiply.setOnClickListener(this);
        this.buttonDivide.setOnClickListener(this);
        this.buttonPoint.setOnClickListener(this);
        this.buttonClear.setOnClickListener(this);
        this.buttonBackspace.setOnClickListener(this);
        this.buttonMemory.setOnClickListener(this);
        this.buttonRestore.setOnClickListener(this);
        this.buttonEqual.setOnClickListener(this);
    }
}