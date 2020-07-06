package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.view.View.OnClickListener;
import com.google.firebase.database.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
//import android.support.v4.app.DialogFragment;

public class PatientRegister extends AppCompatActivity {


    private static final String TAG = "patientRegisterActivity";

    private EditText patientName;
    private EditText patientGender;
    private EditText patientAge;
    private EditText patientRemarks;

    Button buttonRegisterPatient;
    FirebaseDatabase database;
    DatabaseReference ref;

    private String name;
    private String gender;
    private long age;
    private String remarks;
    private User user = null;


    //private FirebaseDatabase database = FirebaseDatabase.getInstance();
    //private DatabaseReference mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);

        patientName = findViewById(R.id.patientName);
        patientGender = findViewById(R.id.patientGender);
        patientAge = findViewById(R.id.patientAge);
        patientRemarks = findViewById(R.id.patientRemarks);
        buttonRegisterPatient = findViewById(R.id.buttonRegisterPatient);
        database = FirebaseDatabase.getInstance();
        user = new User();
        ref = database.getReference("User");
        //buttonRegisterPatient.setOnClickListener(PatientRegister.this);

        buttonRegisterPatient.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {

                //StartActivity(new Intent(getApplicationContext(), PatientProfile.class));
                name = patientName.getText().toString().trim();
                gender = patientGender.getText().toString().trim();
                age = Long.parseLong(patientAge.getText().toString().trim());
                remarks = patientRemarks.getText().toString().trim();

                user.setName(name);
                user.setAge(age);
                user.setGender(gender);
                user.setRemarks(remarks);
                ref.push().setValue(user);
                Toast.makeText(PatientRegister.this, "Data entered", Toast.LENGTH_LONG).show();

                //Intent myIntent = new Intent(getBaseContext(),PatientProfile.class);
                //startActivity(myIntent);
                //startActivity(new Intent(getApplicationContext(), PatientProfile.class));

            }
        });



    }
}


