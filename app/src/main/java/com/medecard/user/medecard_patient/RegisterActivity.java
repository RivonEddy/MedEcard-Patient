package com.medecard.user.medecard_patient;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.thekhaeng.pushdownanim.PushDownAnim;

import org.json.JSONObject;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class RegisterActivity extends AppCompatActivity {

    TextView textView;
    Intent intent;
    ImageView image_back;
    Button button;
    TextInputLayout surname, firstname, email, phone, passwd, cnfpasswd;
    TextInputEditText msname, mfname, memail, mphone, mpassword, mcnfpassword;
//    LinearLayout linearLayout;

    final String base_URL_register = "https://apptualise.net/medirec/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        surname = (TextInputLayout) findViewById(R.id.textInputSurnameRegister);
        firstname = (TextInputLayout) findViewById(R.id.textInputFirstnameRegister);
        email = (TextInputLayout) findViewById(R.id.textInputEmailRegister);
        phone = (TextInputLayout) findViewById(R.id.textInputPhoneRegister);
        passwd = (TextInputLayout) findViewById(R.id.textInputPasswordRegister);
        cnfpasswd = (TextInputLayout) findViewById(R.id.textConfirmPasswordRegister);

        msname = (TextInputEditText) findViewById(R.id.surname_register);
        mfname = (TextInputEditText) findViewById(R.id.firstname_register);
        memail = (TextInputEditText) findViewById(R.id.email_register);
        mphone = (TextInputEditText) findViewById(R.id.phone_register);
        mpassword = (TextInputEditText) findViewById(R.id.password_register);
        mcnfpassword = (TextInputEditText) findViewById(R.id.confirm_password_register);

        button = (Button) findViewById(R.id.register_btn);
        textView = (TextView) findViewById(R.id.login_text);
        image_back = (ImageView) findViewById(R.id.back_btn);

//        linearLayout = findViewById(R.id.reg_content);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RegisterActivity.this, LogRegActivity.class);
                startActivity(intent);
            }
        });

        // Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        PushDownAnim.setPushDownAnimTo(button)
                .setScale(MODE_STATIC_DP, 20 )
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(msname.getText().toString().isEmpty()){
                            surname.setError("Input valid name");
                        }
                        else
                        if(mfname.getText().toString().isEmpty()){
                            firstname.setError("Input valid name");
                        }
                        else
                        if(memail.getText().toString().isEmpty() ||
                                !memail.getText().toString().endsWith("@gmail.com") &&
                                        !memail.getText().toString().endsWith("@yahoo.com")){
                            email.setError("Invalid email type");
                        }
                        else
                        if(mphone.getText().toString().isEmpty()){
                            phone.setError("Input valid phone number");
                        }
                        else
                        if(mpassword.getText().toString().isEmpty() &&
                                mpassword.getText().length() < 6){
                            passwd.setError("Invalid password type");
                        }
                        else
                        if(mcnfpassword.getText().length() != mpassword.getText().length()){
                            cnfpasswd.setError("Password do not match");
                        }
                        else {

                            JsonObjectRequest objectRequest = new JsonObjectRequest(
                                    Request.Method.POST,
                                    base_URL_register+"addPatient",
                                    null,
                                    new Response.Listener<JSONObject>() {
                                        @Override
                                        public void onResponse(JSONObject response) {
                                            showToast("Registration successful");
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            showToast("Error in Registration");
                                        }
                                    }
                            );

                            requestQueue.add(objectRequest);
                        }
                    }
        });
    }


    public void showToast(final String Text){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisterActivity.this,
                        Text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addUser(StringRequest stringRequest){

    }
}