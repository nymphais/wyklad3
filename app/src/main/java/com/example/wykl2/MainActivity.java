package com.example.wykl2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private ListView listView;
    private MyAdapter adapter;
    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//            String item = stringItems.get(i);
//            Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivity.this, ImageActivity.class);
            intent.putExtra("index", i);
            startActivity(intent);

        }
    };

    private List<String> stringItems;

    private View.OnClickListener myClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String text = editText.getText().toString();

            Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();

            //adapter item list update
            stringItems.add(text);
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edittext1);
        button = (Button) findViewById(R.id.button1);

        //click listener
        button.setOnClickListener(myClickListener);

        //sample items setup
        String[] items = {"item1", "item2"};
        stringItems = new ArrayList<>();
        stringItems.addAll(Arrays.asList(items));

        //addapter initialization
        adapter = new MyAdapter(MainActivity.this, R.layout.item_layout);
        adapter.setItems(stringItems);

        //listView
        listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);


    }
}
