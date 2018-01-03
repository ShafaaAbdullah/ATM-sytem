package com.example.shafa.myatmsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String [] Name={"Aa","Bb","Cc","Dd","Ee"};
    String [] Account_ID={"101","102","103","104","105"};
    String [] PassWord={"A101","B102","C103","D104","E105"};

    EditText code,password;

    String getpassword,getid;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        code =(EditText)findViewById(R.id.M_A_code);
        password=(EditText)findViewById(R.id.M_A_passworde);

    }
    public void Enter_MA(View view)
    {
        getid =code.getText().toString();
        getpassword=password.getText().toString();

        for(int i=0;i<Account_ID.length;i++)
        {
            if(getid.equals(Account_ID[i])&& getpassword.equals(PassWord[i]))
            {
                Intent intent=new Intent(this,AcountActivity.class);
                startActivity(intent);
            }
            else
            {
                if (!getid.equals(Account_ID[i]) || !getpassword.equals(PassWord[i]))
                {
                    Toast.makeText(getApplicationContext(), "Incorrect password or ID.....", Toast.LENGTH_SHORT).show();
                }
            }



        }
    }
}
