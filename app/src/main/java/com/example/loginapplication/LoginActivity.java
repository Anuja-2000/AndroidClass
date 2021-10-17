package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et_email,et_password;
    RelativeLayout btn_login;
    TextView tv_sign_up;
    String email,password;
    private  String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    //private  String MobilePattern = "^\\+[0-9]{10,13}$";
    private String PasswordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = findViewById(R.id.edt_username);
        et_password = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_login);
        tv_sign_up = findViewById(R.id.tv_signup);

        String sign_up_text = "<font>Don't have an account?</font><font color = #E12B29><b> SignUp</b></font>";
        tv_sign_up.setText(Html.fromHtml(sign_up_text));

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = et_email.getText().toString().trim();
                password = et_password.getText().toString().trim();
                validateFields(email,password);
                //Toast.makeText(LoginActivity.this,"Email is "+ email + " Password is " + password,Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void validateFields(String email, String password) {
        if (!(email.isEmpty()) && !(password.isEmpty())){
            if (email.matches(EmailPattern)){
                if (password.matches(PasswordPattern)){
                    Toast.makeText(LoginActivity.this,"Successful! ",Toast.LENGTH_SHORT).show();
                    loguser();
                }
                else {
                    et_password.setError("Password format is wrong!");
                }
            }
            else{
                et_email.setError("Email format is wrong!");
            }

        }else {
            //et_email.setError("Please fill this field!");
            //et_password.setError("Please fill this field!");
            Toast.makeText(LoginActivity.this,"Please fill all fields! ",Toast.LENGTH_SHORT).show();
            }
        }

    private void loguser() {
//        firebase,Rest Api
        startActivity(new Intent(LoginActivity.this,FragmentActivity.class));
    }
}