package com.example.vikasgupta.alumini;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity {
    Spinner mYearOfJoining;
    Spinner mProfession;
    Spinner mJnvName;
    EditText mName;
    EditText mPwd;
    RadioButton isMale;
    //RadioButton isFemale;
    EditText mobNo;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_form);
        mJnvName=(Spinner)findViewById(R.id.jnv_name);
        mProfession=(Spinner)findViewById(R.id.profession);
        mYearOfJoining=(Spinner)findViewById(R.id.year_of_joining);
        mName=(EditText)findViewById(R.id.name);
        mPwd=(EditText)findViewById(R.id.pwd);
        isMale=(RadioButton)findViewById(R.id.male);
        mobNo=(EditText)findViewById(R.id.mobile_no);
        email=(EditText)findViewById(R.id.email);

        ArrayAdapter<CharSequence> adapterJnvName = ArrayAdapter.createFromResource(this,
                R.array.jnv_name, android.R.layout.simple_spinner_item);
        adapterJnvName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adaptermProfession = ArrayAdapter.createFromResource(this,
                R.array.profession, android.R.layout.simple_spinner_item);
        adaptermProfession.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapterYearOfJoining = ArrayAdapter.createFromResource(this,
                R.array.year_of_joining, android.R.layout.simple_spinner_item);
        adapterYearOfJoining.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mJnvName.setAdapter(adapterJnvName);
        mProfession.setAdapter(adaptermProfession);
        mYearOfJoining.setAdapter(adapterYearOfJoining);
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
    void registerInfo(View view){
        JnvAlumini alumini=new JnvAlumini();
        alumini.setName(mName.getText().toString());
        alumini.setPwd(mPwd.getText().toString());
        alumini.setEmail(email.getText().toString());
        alumini.setMale(isMale.isChecked());
        alumini.setMobNo(mobNo.getText().toString());
        alumini.setPassYear(mYearOfJoining.getSelectedItem().toString());
        alumini.setJnvName(mJnvName.getSelectedItem().toString());
        alumini.setOccupation(mProfession.getSelectedItem().toString());
        RegisterAndLoginInfo.regiserInfoInFile(alumini,getApplicationContext());
    }
}
