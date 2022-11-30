package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import javax.xml.validation.Validator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText textnom= (EditText) findViewById(R.id.PersonName);

        Button btnvalider= (Button) findViewById(R.id.button);
        RadioButton homme= (RadioButton) findViewById(R.id.radioButton);
        RadioButton femme= (RadioButton) findViewById(R.id.radioButton2);
        CheckBox fr= (CheckBox) findViewById(R.id.checkBox);
        CheckBox anglais= (CheckBox) findViewById(R.id.checkBox2);
        CheckBox Espagnol= (CheckBox) findViewById(R.id.checkBox3);
        ConstraintLayout constraintLayout=(ConstraintLayout) findViewById(R.id.leith);

        btnvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom=textnom.getText().toString();
                String honorfrigueFR="";
                String honorfrigueES="";
                String message_accueil="";
                int nombre_cochage=0;
                if ((!homme.isChecked())&& (!femme.isChecked())){
                homme.setChecked(true);
                }
                if (homme.isChecked()){
                    honorfrigueFR="cher";
                    honorfrigueES="senor";

                }
                else if  (femme.isChecked()){
                    honorfrigueFR="chère";
                    honorfrigueES="senora";

                }

                if((!fr.isChecked())&&(!anglais.isChecked())&&(!Espagnol.isChecked())){
                    fr.setChecked(true);

                }

                if (fr.isChecked()) {
                    message_accueil=message_accueil + "Bonjour " + honorfrigueFR + " " + nom + "\n";
                    nombre_cochage++;
                }
                if (anglais.isChecked()) {
                    message_accueil=message_accueil + "Hello Dear " + nom + "\n";
                    nombre_cochage++;
                }
                if (Espagnol.isChecked()) {
                    message_accueil = message_accueil + "Hola " + honorfrigueES + " " + nom + "\n";
                    nombre_cochage++;
                }
                Snackbar snackbar = Snackbar.make(constraintLayout,message_accueil,Snackbar.LENGTH_LONG);
                if (nombre_cochage>2) {
                    View snackBarView = snackbar.getView();
                    TextView snackTextView = (TextView) snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
                    snackTextView.setMaxLines(3);
                }
                snackbar.show();





            }


        });
}}