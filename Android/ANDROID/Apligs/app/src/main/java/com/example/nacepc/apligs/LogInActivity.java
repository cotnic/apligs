package com.example.nacepc.apligs;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class LogInActivity extends AppCompatActivity {
    public static Uporabnik trenutnoPrijavljeni;
    EditText user;
    EditText pass;
    String user1="";
    String pass1="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void funkcijaLoginOriginal(View view) {
        user = (EditText) findViewById(R.id.etLoginUserName);
        user1 = user.getText().toString();
        pass = (EditText)findViewById(R.id.etLoginPassword);
        pass1 = pass.getText().toString();
        System.out.println(user1);
        System.out.println(pass1);
        AsyncLogInTask neki = new AsyncLogInTask();
        neki.execute((Void) null);

    }

    public class AsyncLogInTask extends AsyncTask<Void, Void, Void> {
        String neki="";
        String neki2= "http://10.0.2.2:8080/apligs-rest/v1/uporabniki/prijava?email="+user1+"&password="+pass1;

        Context context;
        @Override
        protected Void doInBackground(Void... params) {
            try {
                System.out.println(neki2);
                neki = Connections.getConnection(neki2);
            } catch (IOException e) {
                neki ="";
                e.printStackTrace();
            } catch (RuntimeException e){
                neki ="";
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.e("Response", " " + neki);
            if(neki.length() < 30){
                Toast.makeText(LogInActivity.this, "Prijava Neuspešna", Toast.LENGTH_LONG).show();
                System.out.println("Bedak");
            }else{
                trenutnoPrijavljeni = new Uporabnik(neki);
                Intent a = new Intent();
                a.setClass(getApplicationContext(),ZacetnaActivity.class);
                startActivity(a);
            }

        }
    }
}
