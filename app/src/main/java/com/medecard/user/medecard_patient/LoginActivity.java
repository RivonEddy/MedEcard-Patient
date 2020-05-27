package com.medecard.user.medecard_patient;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.thekhaeng.pushdownanim.PushDownAnim;

import org.json.JSONObject;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class LoginActivity extends AppCompatActivity {


    TextInputLayout email, password;
    TextInputEditText mEmail, mPassword;
    Button button;

    TextView textView, textView1;
    Intent intent;
    ImageView image_back;

    final String base_URL_login = "https://apptualise.net/medirec/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView = (TextView) findViewById(R.id.forgot_passwd);
        textView1 = (TextView) findViewById(R.id.register_text);

        image_back = (ImageView) findViewById(R.id.back_btn);

        button = (Button) findViewById(R.id.login_btn);

        mEmail = (TextInputEditText) findViewById(R.id.email_login);
        mPassword = (TextInputEditText) findViewById(R.id.password_login);

        email = (TextInputLayout) findViewById(R.id.textInputEmailLogin);
        password = (TextInputLayout) findViewById(R.id.textInputPasswordLogin);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, LogRegActivity.class);
                startActivity(intent);
            }
        });

        // initiate progress bar and start button
        final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        // Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        PushDownAnim.setPushDownAnimTo(button)
                .setScale(MODE_STATIC_DP, 20)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mEmail.getText().toString().isEmpty() ||
                                !mEmail.getText().toString().endsWith(".com")) {
                            email.setError("Invalid email type");
                        } else if (mPassword.getText().toString().isEmpty() &&
                                mPassword.getText().length() < 6) {
                            password.setError("Input valid password");
                        } else {
//    public class LoginUser extends AsyncTask<String, Void, String> {
//        @Override
//        protected String doInBackground(String... strings) {
//            String Email = strings[0];
//            String Password = strings[1];
//
//            OkHttpClient okHttpClient = new OkHttpClient();
//            RequestBody formBody = new FormBody.Builder()
//                    .add("user_id", Email)
//                    .add("user_password", Password)
//                    .build();
//
//            Request request = new Request.Builder()
//                    .url(url_Login)
//                    .post(formBody)
//                    .build();
//
//            Response response = null;
//            try{
//                response = okHttpClient.newCall(request).execute();
//                if(response.isSuccessful()){
//                    String result = response.body().string();
//                    if(result.equalsIgnoreCase("login")){
//                        Intent i = new Intent(LoginActivity.this,
//                                MainActivity.class);
//                        startActivity(i);
//                        finish();
//                    }else{
//                        showToast("Email or Password mismatched!");
//                    }
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }


//                            JsonObjectRequest objectRequest = new JsonObjectRequest(
//                                    Request.Method.POST,
//                                    base_URL_login+"doLogin",
//                                    null,
//                                    new Response.Listener<JSONObject>() {
//                                        @Override
//                                        public void onResponse(JSONObject response) {
//                                            simpleProgressBar.setVisibility(View.VISIBLE);
//                                            showToast("Login Successful");
//                                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                                        }
//                                    },
//                                    new Response.ErrorListener() {
//                                        @Override
//                                        public void onErrorResponse(VolleyError error) {
//                                            showToast("Error Logging in");
//                                        }
//                                    }
//                            );
//                            requestQueue.add(objectRequest);
                            if (mEmail.getText().toString().equals("user@gmail.com") &&
                                    mPassword.getText().toString().equals("password")){
                                simpleProgressBar.setVisibility(View.VISIBLE);
                                showToast("Logged In Successfully");
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else{
                                showToast("Incorrect login details");
                            }
                        }
                    }
    });
    }

    public void showToast(final String Text){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this,
                        Text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
