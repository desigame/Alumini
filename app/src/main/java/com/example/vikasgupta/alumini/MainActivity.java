package com.example.vikasgupta.alumini;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

/*Developer : Vikas Gupta
  JNV Shivpuri
  Batch 2007 Passout
* */

public class MainActivity extends AppCompatActivity {

    public static final String TAG="MainACtivity";
    ImageView loginOrLogout;
    ImageView registerOrSearch;
    ImageView info;
    ImageView contactUs;
    ViewFlipper mViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mViewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
        loginOrLogout=(ImageView)findViewById(R.id.loginorlogout);      //setUpResource();
        registerOrSearch=(ImageView)findViewById(R.id.registerorsearch);
        info=(ImageView)findViewById(R.id.gallery);
        contactUs=(ImageView)findViewById(R.id.contact);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // sendEmail();
        View.OnClickListener mItemClcikListner;
        mItemClcikListner=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(v.getId()==R.id.registerorsearch){
                        Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                        Log.i(TAG,"intent going to launch");
                        startActivity(intent);
                        Log.i(TAG, "intent launched");
                        // intent.setAction()
                    }
                    if(v.getId()==R.id.loginorlogout){
                        Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                        Log.i(TAG,"intent going to launch");
                        startActivity(intent);
                        Log.i(TAG, "intent launched");
                    }
                if(v.getId()==R.id.contact){
                    Intent intent=new Intent(getApplicationContext(),ContactUsActivity.class);
                    Log.i(TAG,"intent going to launch");
                    startActivity(intent);
                    Log.i(TAG, "intent launched");
                }
                }
        };

        loginOrLogout.setOnClickListener(mItemClcikListner);
        registerOrSearch.setOnClickListener(mItemClcikListner);
        contactUs.setOnClickListener(mItemClcikListner);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"vikashgupta625@gmail.com"};
        String[] CC = {"vikas.iiitm101@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            // Log.i("Finished sending email...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
