package com.medecard.user.medecard_patient.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.medecard.user.medecard_patient.HealthTipsActivity;
import com.medecard.user.medecard_patient.R;
import com.medecard.user.medecard_patient.RegisterActivity;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class PersInfoFragment extends Fragment {

    ImageView imageView;
    Intent intent;
    TextView textView;
    EditText medittext, medittext1, medittext2, medittext3, medittext4, medittext5, medittext6;
    Button button;
    Spinner spinner, spinner1;
    ArrayAdapter<String> adapter;
    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public static PersInfoFragment newInstance() {
        PersInfoFragment fragment = new PersInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pers_info, container,
                false);

        textView = (TextView) view.findViewById(R.id.edit_pers_info);
        imageView = (ImageView) view.findViewById(R.id.tips_btn);
            button = (Button) view.findViewById(R.id.pers_info_sbtn);
            button.setEnabled(false);

            spinner = (Spinner) view.findViewById(R.id.spinner);
            spinner1 = (Spinner) view.findViewById(R.id.spinner_bgroup);

            medittext = (EditText) view.findViewById(R.id.edit_surname);
            medittext.setEnabled(false);
            medittext1 = (EditText) view.findViewById(R.id.edit_fname);
            medittext1.setEnabled(false);
            medittext2 = (EditText) view.findViewById(R.id.edit_dob);
            medittext2.setEnabled(false);
            medittext3 = (EditText) view.findViewById(R.id.edit_weight);
            medittext3.setEnabled(false);
            medittext4 = (EditText) view.findViewById(R.id.edit_height);
            medittext4.setEnabled(false);
            medittext5 = (EditText) view.findViewById(R.id.edit_occupation);
            medittext5.setEnabled(false);
            medittext6 = (EditText) view.findViewById(R.id.edit_address);
            medittext6.setEnabled(false);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setEnabled(true);
                button.setBackgroundResource(R.drawable.button_log_reg_white);
                medittext.setEnabled(true);
                medittext1.setEnabled(true);
                medittext2.setEnabled(true);
                medittext3.setEnabled(true);
                medittext4.setEnabled(true);
                medittext5.setEnabled(true);
                medittext6.setEnabled(true);

                String [] values = {"Male", "Female"};
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout
                        .simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner.setAdapter(adapter);
                spinner.setEnabled(true);

                String [] values1 = {"A+", "B+", "O-", "AB-", "O+", "AB+", "A-", "B-"};
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout
                        .simple_spinner_item, values1);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner1.setAdapter(adapter);
                spinner1.setEnabled(true);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, HealthTipsActivity.class);
                startActivity(intent);
            }
        });

        PushDownAnim.setPushDownAnimTo(button)
                .setScale(MODE_STATIC_DP, 8 )
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            if (medittext.getText().toString().isEmpty()) {
                                medittext.setError("Field is empty");
                                Toast.makeText(context, "Field is empty", Toast.LENGTH_SHORT).show();
                            } else if (medittext1.getText().toString().isEmpty()) {
                                medittext1.setError("Field is empty");
                                Toast.makeText(context, "Field is empty", Toast.LENGTH_SHORT).show();
                            } else if (medittext2.getText().toString().isEmpty()) {
                                medittext2.setError("Field is empty");
                                Toast.makeText(context, "Field is empty", Toast.LENGTH_SHORT).show();
                            }
//                        else if(medittext3.getText().toString().isEmpty() || !medittext3.getText().toString().endsWith("kg")){
//                            medittext3.setError("Incorrect value");
//                        }
//                        else if(medittext4.getText().toString().isEmpty() || !medittext4.getText().toString().endsWith("cm")){
//                            medittext4.setError("Incorrect value");
//                        }
                            else if (medittext5.getText().toString().isEmpty()) {
                                medittext5.setError("Field is empty");
                                Toast.makeText(context, "Field is empty", Toast.LENGTH_SHORT).show();
                            } else if (medittext6.getText().toString().isEmpty()) {
                                medittext6.setError("Field is empty");
                                Toast.makeText(context, "Field is empty", Toast.LENGTH_SHORT).show();
                            }
                        else {
                            Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show();

                            medittext.setEnabled(false);
                            medittext.setTextColor(getResources().getColor(R.color.grad_purple_light));

                            medittext1.setEnabled(false);
                            medittext1.setTextColor(getResources().getColor(R.color.grad_purple_light));

                            medittext2.setEnabled(false);
                            medittext2.setTextColor(getResources().getColor(R.color.grad_purple_light));

                            medittext3.setEnabled(false);
                            medittext3.setTextColor(getResources().getColor(R.color.grad_purple_light));

                            medittext4.setEnabled(false);
                            medittext4.setTextColor(getResources().getColor(R.color.grad_purple_light));

                            medittext5.setEnabled(false);
                            medittext5.setTextColor(getResources().getColor(R.color.grad_purple_light));

                            medittext6.setEnabled(false);
                            medittext6.setTextColor(getResources().getColor(R.color.grad_purple_light));

                            spinner.setEnabled(false);
                            spinner1.setEnabled(false);

                            button.setEnabled(false);
                            button.setBackgroundResource(R.drawable.white_edit_text_purp);
                        }
                    }
                });

        return view;
    }

}
