package com.example.digitalsocity_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edemail,edpassword;
    Button btnlogin;
    ApiInterface apiInterface;
    List<Chairman_Model> chairman_models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        edemail = findViewById(R.id.ed_email);
        edpassword = findViewById(R.id.ed_password);
        btnlogin = findViewById(R.id.btn_login);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Call<List<Chairman_Model>> call = apiInterface.chairman_login(edemail.getText().toString(),edpassword.getText().toString());
            call.enqueue(new Callback<List<Chairman_Model>>() {
                @Override
                public void onResponse(Call<List<Chairman_Model>> call, Response<List<Chairman_Model>> response) {

                    chairman_models = response.body();
                    if (chairman_models.isEmpty())
                    {
                        Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Log.d("mydata","----------chairmain"+chairman_models);
                        Toast.makeText(LoginActivity.this, "Login Succesfully", Toast.LENGTH_SHORT).show();

                        Intent i =new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<List<Chairman_Model>> call, Throwable t) {

                    Toast.makeText(LoginActivity.this, "False", Toast.LENGTH_SHORT).show();

                }
            });
            }
        });




    }
}