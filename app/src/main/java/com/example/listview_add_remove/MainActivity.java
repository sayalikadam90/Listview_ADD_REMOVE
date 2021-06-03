package com.example.listview_add_remove;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtcity;
    Button btnadd;
    Button btnremove;
    ListView listView;
    ArrayAdapter<String> adapterCity;
    ArrayList<String> modelcities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtcity=findViewById(R.id.edtcity);

        btnadd=findViewById(R.id.btnadd);
        btnremove=findViewById(R.id.btnremove);
        listView=findViewById(R.id.listview);

        modelcities=new ArrayList<String>();

       adapterCity=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,modelcities);
       listView.setAdapter(adapterCity);
       btnadd.setOnClickListener(new btnadd());
       btnremove.setOnClickListener(new btnremove());





    }

   class btnadd implements View.OnClickListener{

       @Override
       public void onClick(View v) {

        modelcities.add(edtcity.getText().toString().trim());
        adapterCity.notifyDataSetChanged();
        Toast.makeText(MainActivity.this,"Data added successfully...",Toast.LENGTH_LONG).show();


       }
   }

   class btnremove implements View.OnClickListener{
       @Override
       public void onClick(View v) {

           modelcities.remove(edtcity.getText().toString().trim());
           adapterCity.notifyDataSetChanged();
           Toast.makeText(MainActivity.this,"Data removed successfully...",Toast.LENGTH_LONG).show();

       }
   }
}