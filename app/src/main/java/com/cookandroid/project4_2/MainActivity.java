package com.cookandroid.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOk;
    ImageView imgPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진보기");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (CheckBox)findViewById(R.id.ChkAgree);
        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);

        btnOk = (Button)findViewById(R.id.BtnOK);
        imgPet = (ImageView) findViewById(R.id.Imgpet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(chkAgree.isChecked() == true){
                        text2.setVisibility(android.view.View.VISIBLE);
                        rGroup1.setVisibility(android.view.View.VISIBLE);
                        btnOk.setVisibility(android.view.View.VISIBLE);
                        imgPet.setVisibility(android.view.View.VISIBLE);

                    }else
                    {
                        text2.setVisibility(android.view.View.INVISIBLE);
                        rGroup1.setVisibility(android.view.View.INVISIBLE);
                        btnOk.setVisibility(android.view.View.INVISIBLE);
                        imgPet.setVisibility(android.view.View.INVISIBLE);
                    }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.RdoDog:
                        imgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.RdoCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;

                    default:
                        Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요 !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}