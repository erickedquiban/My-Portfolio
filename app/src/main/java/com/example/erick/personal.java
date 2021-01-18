package com.example.erick;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class personal extends AppCompatActivity {
    Button location;
    TextView btn;
    EditText numTxt;
    String sNum;


    private AdapterViewFlipper adapterViewFlipper;//for th whole adapter

    //this is for the text
    private static final String[] TEXT = {"We attended an Odoo13 manila Road show to tackle the new features of odoo 13. This is one the best experience that I have here in my internship over 100 companies come in  to this event.",
            "Impact Hackathon2019 at Araneta Coliseum the biggest hackathon in our country.We present our Medhack application to inform the community about malnutrition.", "Basic Routing and Switching at Linksee Training Center since the school is are carrying CISCO I aquaired a seminar to enhance my knowledge to Networking. ",
            "Music is my passion , I have a band named True Story we are covering a song from Parokya ni Edgar. The band also have a single called tambayan.", "This picture  was taken in Coron Palawan. Travelling is one of my favorite hobby. I wanted to experience something extraordinary as long I could."};

    //this is for the image
    private static final int[] IMAGES = {R.drawable.s1, R.drawable.s2, R.drawable.s3,
            R.drawable.s4, R.drawable.s5};
    //mposition is for the start
    private int mPosition = -1;
    Dialog myDialog;
    String uriString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//open
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);//tawagin mo ung xml na ginawa mo para sa adapterflipper
        myDialog = new Dialog(this);//for dialog
        btn = (TextView) findViewById(R.id.idbtnCall);//for phone Calls

        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.idAdapterViewFlipper);//gawa ka nito para sa xml mo


        FlipperAdapter adapter = new FlipperAdapter(this, TEXT, IMAGES);//tawagin ang string and larawan
        adapterViewFlipper.setAdapter(adapter);//pagtawaga sa variable na adapter
        adapterViewFlipper.setAutoStart(true);//automatic start
    }//close

    //Contact Dialog
    public void Contact(View v) {
        TextView txtclose;
        Button btn;
        myDialog.setContentView(R.layout.contact);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

    //fb message
    public void facebook(View w) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        uriString = "https://www.facebook.com";
        sharingIntent.putExtra(Intent.EXTRA_TEXT, uriString);
        sharingIntent.setPackage("com.facebook.katana");
        startActivity(sharingIntent);
    }
//email

    public void email(View w) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mail"));
        String[] s = {"erickedquiban03@gmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL, s);
        i.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        i.putExtra(Intent.EXTRA_TEXT, "");
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i, "Luncher Email");
        startActivity(chooser); //ito ginamit
    }

    //Loations
    public void location(View w) {
        String url = "https://www.google.com/maps/place/Western+Bicutan,+Taguig,+Metro+Manila/@14.5178989,121.0217936,14z/data=!3m1!4b1!4m13!1m7!3m6!1s0x3397cf4a54fe3001:0x2fae7af0a998d2ad!2sTaguig,+Metro+Manila!3b1!8m2!3d14.5176184!4d121.0508645!3m4!1s0x3397cf2ca2a215d5:0x38380d2c1d509c80!8m2!3d14.5172043!4d121.036377";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

    //Phone Call
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void btnCall (View v) {
        Intent erick = new Intent(Intent.ACTION_CALL);
            erick.setData(Uri.parse("tel:+639150669721"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 10);

            return;
        }else{
            startActivity(erick);
        }
    }

//Phone Call Ends Here








    public void PersonalData(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.personaldata);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        // btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }




    class FlipperAdapter extends BaseAdapter {//open
        Context ctx;
        int[] images;
        String[] text;
        LayoutInflater inflater;//kailangan na infater

        public FlipperAdapter(Context context, String[] myText, int[] myImages) {
            this.ctx = context;
            this.images = myImages;
            this.text = myText;
            inflater = LayoutInflater.from(context);//variables
        }//close


        @Override
        public int getCount() {
            return text.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.flipper_items, null);
            TextView txtName = (TextView) view.findViewById(R.id.idTextView);
            ImageView txtImage = (ImageView) view.findViewById(R.id.idImageView);
            txtName.setText(text[i]);
            txtImage.setImageResource(images[i]);
            return view;
        }
    }
}