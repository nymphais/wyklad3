package com.example.wykl2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(ImageActivity.this);

            builder.setTitle("Tytuł okna");
            builder.setMessage("Jakaś wiadomośc w naszym dialogu. " +
                    "ojewr fewuhc ewfunhew cew");
            builder.setPositiveButton("Ok", dialogClickListener);
            builder.setNegativeButton("Cancel", dialogClickListener);
            builder.create().show();
        }
    };

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == AlertDialog.BUTTON_POSITIVE) {
                Intent intent = new Intent(ImageActivity.this,ViewPagerActivity.class);
                startActivity(intent);
            }

            else if(which == AlertDialog.BUTTON_NEGATIVE){
                Toast.makeText(ImageActivity.this, "Cancel", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        int i = getIntent().getExtras().getInt("index");

        TextView textView = (TextView) findViewById(R.id.index_text);
        textView.setText(Integer.toString(i));

        findViewById(R.id.image).setOnClickListener(onClickListener);
        initFragment();
    }

    private void initFragment () {
        ExampleFragment fragment = new ExampleFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit(); //kompatybilne z Androidem v 2
    }
}
