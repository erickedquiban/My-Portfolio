package com.example.erick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button personal;
    Button skills;
    Button work;
    Button apps;
    Button certificate;
    Dialog myDialog;
    String uriString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);//for dialog
        personal = (Button) findViewById(R.id.btnpersonaldata);
        skills = (Button) findViewById(R.id.btnability);
        work = (Button) findViewById(R.id.btnwork);
        apps = (Button) findViewById(R.id.btnapps);
        certificate = (Button) findViewById(R.id.btncertificate);


        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, personal.class);
                startActivity(registerIntent);
            }
        });//close the intent

    }//End of the button of personal to intent if you want to create another button don't put } this




    //Skills Dialog

    public void Skills(View v) {
        TextView txtclose;
        Button btn;
        myDialog.setContentView(R.layout.skills);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);//exit the dialog
        txtclose.setText("X");//edit the text in close textbox
        txtclose.setOnClickListener(new View.OnClickListener() {//listener
            @Override
            public void onClick(View v) {
                myDialog.dismiss();//call the popup message
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//editable in xml
        myDialog.show();//to show

    }
//Education Dialog

    public void Education(View v) {
        TextView txtclose;
        Button btn;
        myDialog.setContentView(R.layout.education);//xml na inasign mo para mapuntahan
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);//exit the dialog
        txtclose.setText("X");//edit the text in close textbox
        txtclose.setOnClickListener(new View.OnClickListener() {//listener
            @Override
            public void onClick(View v) {
                myDialog.dismiss();//call the popup message
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//editable in xml
        myDialog.show();//to show

    }

    //Education Dialog

    public void Certificate(View v) {
        TextView txtclose;
        Button btn;
        myDialog.setContentView(R.layout.certificate);//xml na inasign mo para mapuntahan
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);//exit the dialog
        txtclose.setText("X");//edit the text in close textbox

        txtclose.setOnClickListener(new View.OnClickListener() {//listener
            @Override
            public void onClick(View v) {//set this to call the dialog or the popups
                myDialog.dismiss();//call the popup message
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//editable in xml
        myDialog.show();//to show

    }

    //Work Dialog

    public void Work (View v) {
        TextView txtclose;
        Button btn;
        myDialog.setContentView(R.layout.workexperience);//xml na inasign mo para mapuntahan
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);//exit the dialog
        txtclose.setText("X");//edit the text in close textbox
        txtclose.setOnClickListener(new View.OnClickListener() {//listener
            @Override
            public void onClick(View v) {
                myDialog.dismiss();//call the popup message
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//editable in xml
        myDialog.show();//to show

    }

    //Application Dialog

    public void MobileApplication (View v) {
        TextView txtclose;
        Button btn;
        myDialog.setContentView(R.layout.mobileapp);//xml na inasign mo para mapuntahan
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);//exit the dialog
        txtclose.setText("X");//edit the text in close textbox
        txtclose.setOnClickListener(new View.OnClickListener() {//listener
            @Override
            public void onClick(View v) {
                myDialog.dismiss();//call the popup message
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//editable in xml
        myDialog.show();//to show

    }
    public void MotherWords(View w){
        String url = "http://www.mediafire.com/file/6gnv323azjvfc5q/app-debug.apk/file\n";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void Alphabet(View w){
        Intent int1 = new Intent(MainActivity.this, alphabet.class);
        startActivity(int1);
    }
    }



