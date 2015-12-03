package com.example.seok.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("인텐트");

        final EditText edtNum1 = (EditText) findViewById(R.id.editNum1);
        final EditText edtNum2 = (EditText) findViewById(R.id.editNum2);
        final RadioGroup rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup);
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                switch (rdoGroup.getCheckedRadioButtonId()) {
                    case R.id.btnAdd:
                        intent.putExtra("Calc", "+");
                        break;
                    case R.id.btnSub:
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.btnMul:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.btnDiv:
                        intent.putExtra("Calc", "/");
                        break;
                    default:
                        break;
                }

                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "결과 :" + hap, Toast.LENGTH_SHORT).show();
        }
    }
}