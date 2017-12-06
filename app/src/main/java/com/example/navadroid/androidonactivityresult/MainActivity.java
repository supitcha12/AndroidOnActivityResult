package com.example.navadroid.androidonactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 555;
    private final int RESULT_OK = 0;
    private EditText editText;
    //public static final

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AnotherActivity.class);
                // putExtra to AnotherActivity
                editText = (EditText)findViewById(R.id.editext);
                String result = editText.getText().toString();
                i.putExtra("Value1",result);


                // set the request code to any code you like, you can identify the callback via this code
                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnKey1")) {
                Toast.makeText(this, data.getExtras().getString("returnKey1"),
                        Toast.LENGTH_SHORT).show();
            } else if (data.hasExtra("returnKey2")) {
                Toast.makeText(this, data.getExtras().getString("returnKey2"),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "If you are looking for apple-pen, there is nothing. Ask Pikotaro!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
