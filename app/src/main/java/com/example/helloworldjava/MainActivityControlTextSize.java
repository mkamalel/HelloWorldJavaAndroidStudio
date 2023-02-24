package com.example.helloworldjava;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivityControlTextSize extends AppCompatActivity {
    Button decreaseTextSizeButton;
    Button increaseTextSizeButton;

    final int MINIMUM_TEXT_SIZE = 48;
    final int MAXIMUM_TEXT_SIZE = 164;
    final int INCREMENT_SIZE = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_control_text_size);

        decreaseTextSizeButton = findViewById(R.id.decreaseTextSizeButton);
        increaseTextSizeButton = findViewById(R.id.increaseTextSizeButton);

        decreaseTextSizeButton.setOnClickListener(v -> decreaseTextSize());
        increaseTextSizeButton.setOnClickListener(v -> increaseTextSize());
    }

    void decreaseTextSize() {
        int textSize = getDiplayTextSize();
        System.out.println(textSize);
        if (textSize <= MINIMUM_TEXT_SIZE) {
            Snackbar.make(
                    findViewById(R.id.MainCoordinatorLayout),
                    R.string.min_text_size,
                    Snackbar.LENGTH_SHORT
            ).show();
            return;
        }

        textSize -= INCREMENT_SIZE;
        setDisplayTextSize(textSize);
    }

    void increaseTextSize() {
        int textSize = getDiplayTextSize();
        System.out.println(textSize);

        if (textSize >= MAXIMUM_TEXT_SIZE) {
            Snackbar.make(
                    findViewById(R.id.MainCoordinatorLayout),
                    R.string.max_text_size,
                    Snackbar.LENGTH_SHORT
            ).show();
            return;
        }

        textSize += INCREMENT_SIZE;
        setDisplayTextSize(textSize);
    }

    void setDisplayTextSize(int size) {
        TextView txtView = (TextView) findViewById(R.id.displayText);
        txtView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    int getDiplayTextSize() {
        TextView txtView = (TextView) findViewById(R.id.displayText);
        return (int)txtView.getTextSize();
    }

}
