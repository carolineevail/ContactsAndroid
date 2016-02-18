package com.theironyard.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> items;

    EditText nameText;
    EditText phoneText;
    Button addButton;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        nameText = (EditText) findViewById(R.id.nameText);
        phoneText = (EditText) findViewById(R.id.phoneText);
        addButton = (Button) findViewById(R.id.addButton);
        listView = (ListView) findViewById(R.id.listView);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(items);

        addButton.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameText.getText().toString();
        String phoneNumber = phoneText.getText().toString();
        String contact = name + " " + "(" + phoneNumber + ")";
        items.add(contact);
        nameText.setText("");
        phoneText.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }
}

