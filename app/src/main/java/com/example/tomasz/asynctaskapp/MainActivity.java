package com.example.tomasz.asynctaskapp;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tV;
    EditText eT;
    AsyncTaskComputing aT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tV=findViewById(R.id.textView);
        eT=findViewById(R.id.editText);



    }

    public void onClickSend(View view){
        int value;
            value=Integer.parseInt(eT.getText().toString());
            aT = new AsyncTaskComputing(this);
            aT.execute(value);

        }


    public void onClickCheck(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Status of thread");
        builder.setMessage(aT.getStatus().toString());

        // add a button
        builder.setPositiveButton("OK", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();    }
}

