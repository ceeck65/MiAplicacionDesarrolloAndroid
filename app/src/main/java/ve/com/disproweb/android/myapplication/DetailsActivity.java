package ve.com.disproweb.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;


public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDetails;
    TextView tvName, tvBirthDay, tvPhone, tvEmail, tvDescription;
    DatePicker birthDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvName  = (TextView) findViewById(R.id.tvName);
        tvBirthDay = (TextView) findViewById(R.id.tvBirthDay);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        btnDetails = (Button) findViewById(R.id.btnEditDetails);
        btnDetails.setOnClickListener(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        if (bundle != null) {
            // Asignación de Variables
            String name  = (String) bundle.get("Name");
            String Phone = (String) bundle.get("Phone");
            String Email = (String) bundle.get("Email");
            String Description = (String) bundle.get("Description");

            Integer day      =  bundle.getInt("day");
            Integer month    =  bundle.getInt("month");
            Integer year     =  bundle.getInt("year");

            // Setear Variables
            tvName.setText(name);
            tvBirthDay.setText(String.valueOf(day + "/" + month + "/" + year));
            tvPhone.setText(Phone);
            tvEmail.setText(Email);
            tvDescription.setText(Description);
        } else {
            Toast.makeText(getApplicationContext(), "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == findViewById(R.id.btnEditDetails).getId()){
            Intent intentDetails = new Intent(getApplicationContext(), MainActivity.class);

            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();

            Integer day     =  bundle.getInt("day");
            Integer month   =  bundle.getInt("month");
            Integer year    =  bundle.getInt("year");


            tvName  = (TextView) findViewById(R.id.tvName);
            birthDay = (DatePicker) findViewById(R.id.datePicker);
            tvPhone = (TextView) findViewById(R.id.tvPhone);
            tvEmail = (TextView) findViewById(R.id.tvEmail);
            tvDescription = (TextView) findViewById(R.id.tvDescription);

            String  Name        = tvName.getText().toString();
            String  Phone       = tvPhone.getText().toString();
            String  Email       = tvEmail.getText().toString();
            String  Description = tvDescription.getText().toString();

            intentDetails.putExtra("txtName", Name);
            intentDetails.putExtra("day", day);
            intentDetails.putExtra("month", month);
            intentDetails.putExtra("year", year);
            intentDetails.putExtra("txtPhone", Phone);
            intentDetails.putExtra("txtEmail", Email);
            intentDetails.putExtra("txtDescription", Description);


            startActivity(intentDetails);
        }
    }
}
