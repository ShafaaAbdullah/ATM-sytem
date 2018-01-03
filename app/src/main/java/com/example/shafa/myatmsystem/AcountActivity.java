package com.example.shafa.myatmsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shafa on 11/10/2017.
 */
public class AcountActivity extends AppCompatActivity {

    int totalMony =1000000;


   //  typ[0]=cat500, typ[1]=cat1000, typ[2]=cat5000, typ[3]=cat10000, typ[4]=cat25000;
    int typ[]={400,200,40,20,8};

    int [] counter={0,0,0,0,0};
    int amountRequired;

    //tv=texetview
    TextView tV1, tV2, tV3, tV4, tV5,tV6;

    //the user entered amount
    EditText enteredAmount;

    //window May be visible or invisible to show number of poped categories
    LinearLayout window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        enteredAmount =(EditText)findViewById(R.id.howmony_et);
        window =(LinearLayout)findViewById(R.id.tbinfo);

        tV1 =(TextView)findViewById(R.id.tv1);
        tV2 =(TextView)findViewById(R.id.tv2);
        tV3 =(TextView)findViewById(R.id.tv3);
        tV4 =(TextView)findViewById(R.id.tv4);
        tV5 =(TextView)findViewById(R.id.tv5);
        tV6 =(TextView)findViewById(R.id.tv6);

    }


    public void pop(View view)
    {
      //convert textvalue to int
     amountRequired =Integer.parseInt(enteredAmount.getText().toString());

     //counters to count every category
        try {
          //check state with with every category of mony
            if (amountRequired < totalMony && amountRequired % 5 == 0&& amountRequired >=500 ||enteredAmount!=null) {
          for( int i=0;i<5;i++)
          {
              if (amountRequired >= 25000 && amountRequired % 25000 == 0) {
                  amountRequired -= 25000;
                  typ[4]--;
                  counter[0]++;
                  totalMony -= 25000;

              }
             else
              if (amountRequired >= 10000 && amountRequired % 10000 == 0 ) {
                  amountRequired -= 10000;
                  typ[3]--;
                  counter[1]++;
                  totalMony -=10000;

              }
             else
              if (amountRequired >= 5000 && amountRequired % 5000 == 0 ) {
                  amountRequired -= 5000;
                  typ[2]--;
                  counter[2]++;
                  totalMony -=5000;
              }
             else
              if (amountRequired >= 1000 && amountRequired % 1000 == 0) {
                  amountRequired -= 1000;
                  typ[1]--;                  counter[3]++;
                  totalMony -=1000;
              }
              else
              if (amountRequired >= 500 && amountRequired % 500 == 0 ) {
                  amountRequired -= 500;
                  typ[0]--;
                  counter[4]++;
                  totalMony -=500;
              }

              // if the entered value is true the window will be visible
              window.setVisibility(View.VISIBLE);
              //show in text veiw
              tV1.setText("type 25,000 poped =" + counter[0]);

              tV2.setText("type 10,000 poped =" + counter[1]);

              tV3.setText("type 5,000 poped =" + counter[2]);

              tV4.setText("type 1,000 poped =" + counter[3]);

              tV5.setText("type 500 poped =" + counter[4]);

              tV6.setText(""+totalMony);
               }

            }
            else
            if (amountRequired < 500 || amountRequired % 5 != 0 || enteredAmount==null)
            {
                window.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Incorrect amount Enterd ...", Toast.LENGTH_SHORT).show();

            }
        }
            catch (Exception e)
            {
            Toast.makeText(getApplicationContext(), "Retry please ...", Toast.LENGTH_SHORT).show();
            }



    }

}
