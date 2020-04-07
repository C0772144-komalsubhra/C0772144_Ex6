package com.example.c0772144_ex6.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0772144_ex6.model.CanadaAttraction;
import com.example.c0772144_ex6.R;

public class AttractionDetailsActivity extends AppCompatActivity {

    CanadaAttraction canadaAttraction;
    private TextView txtName;
    private TextView txtCity;
    private TextView txtAddress;
    private TextView txtProvince;
    private TextView txtDescription;
    private ImageView imgBtnBack;
    private ImageView imgAttractions;
    private Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        imgBtnBack = findViewById(R.id.imgBtnBack);
        txtName = findViewById(R.id.txtName);
        txtCity = findViewById(R.id.txtCity);
        txtAddress = findViewById(R.id.txtAddress);
        txtProvince = findViewById(R.id.txtProvince);
        txtDescription = findViewById(R.id.txtDescription);
        imgAttractions = findViewById(R.id.imgAttraction);
        btnHome = findViewById(R.id.btnHome);

        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (getIntent().getExtras() != null) {
            canadaAttraction = (CanadaAttraction) getIntent().getExtras().getSerializable("attractionsKey");
            txtName.setText(canadaAttraction.getName());
            txtCity.setText(canadaAttraction.getCity());
            txtAddress.setText(canadaAttraction.getAddress());
            txtProvince.setText(canadaAttraction.getProvince());
            txtDescription.setText(canadaAttraction.getDescription());
            imgAttractions.setImageResource(canadaAttraction.getImg());
        }
    }
}
