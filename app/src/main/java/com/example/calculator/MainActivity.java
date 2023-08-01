package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView displayTextView;
    private String currentInput = "";
    private double result = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTextView = findViewById(R.id.displayTextView);
    }

    // Method to handle numeric button clicks
    public void onNumberClick(View view) {
        Button button = (Button) view;
        currentInput += button.getText().toString();
        updateDisplay();
    }

    // Method to handle operator button clicks
    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        if (!currentInput.isEmpty()) {
            result = Double.parseDouble(currentInput);
        }
        currentInput = "";
    }

    // Method to handle equal button click
    public void onEqualClick(View view) {
        if (!currentInput.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            switch (operator) {
                case "+":
                    result += secondOperand;
                    break;
                case "-":
                    result -= secondOperand;
                    break;
                case "*":
                    result *= secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result /= secondOperand;
                    }
                    break;
            }
            currentInput = String.valueOf(result);
            operator = "";
            updateDisplay();
        }
    }

    // Method to handle clear button click
    public void onClearClick(View view) {
        currentInput = "";
        result = 0;
        operator = "";
        updateDisplay();
    }

    // Method to update the display
    private void updateDisplay() {
        displayTextView.setText(currentInput);
    }
}
