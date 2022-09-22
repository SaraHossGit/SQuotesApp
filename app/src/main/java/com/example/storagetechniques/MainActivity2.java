package com.example.storagetechniques;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button generateBtn;
    TextView okBtn, quoteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        generateBtn = findViewById(R.id.generate_btn);

        generateBtn.setOnClickListener(view -> openDialog());

    }

    private void openDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity2.this).create();
        View view1 = getLayoutInflater().inflate(R.layout.alert_dialog_layout, null);
        okBtn = view1.findViewById(R.id.ok_btn);
        quoteText = view1.findViewById(R.id.quote_text);
        getQuote();
        alertDialog.setView(view1);
        // This line sets the background of the dialog to transparent
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.show();

        // Dialog Options
        // OK Button
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        // Share with Friends Button

        // Add to Favorites Button

    }

    private void getQuote() {
        ArrayList<String> quotes = new ArrayList<>( Arrays.asList("“We cannot solve problems with the kind of thinking we employed when we came up with them.” \n— Albert Einstein",
                "“Learn as if you will live forever, live like you will die tomorrow.” \n— Mahatma Gandhi",
                "“Stay away from those people who try to disparage your ambitions. Small minds will always do that, but great minds will give you a feeling that you can become great too.” \n— Mark Twain",
                "“When you give joy to other people, you get more joy in return. You should give a good thought to happiness that you can give out.”\n— Eleanor Roosevelt",
                "“When you change your thoughts, remember to also change your world.”\n—Norman Vincent Peale",
                "“It is only when we take chances, when our lives improve. The initial and the most difficult risk that we need to take is to become honest. \n—Walter Anderson",
                "“Nature has given us all the pieces required to achieve exceptional wellness and health, but has left it to us to put these pieces together.”\n—Diane McLaren"));


        // Random index generator
        Random rand = new Random();
        // Obtain a number between [0 - 6].
        int n = rand.nextInt(7);

        // Display corresponding quote
        quoteText.setText(quotes.get(n));
    }
}