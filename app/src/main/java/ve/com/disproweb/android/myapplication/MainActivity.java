package ve.com.disproweb.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatePicker  datePicker;
    EditText    txtName, txtPhone, txtEmail, txtDescription;
    Button      btnNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        txtName   = (EditText) findViewById(R.id.txtName);
        txtPhone  = (EditText) findViewById(R.id.txtPhone);
        txtEmail  = (EditText) findViewById(R.id.txtEmail);
        txtDescription = (EditText) findViewById(R.id.txtDescription);
        btnNext = (Button) findViewById(R.id.btnNext);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            String txt_Name  = (String) bundle.get("txtName");
            String txt_Phone = (String) bundle.get("txtPhone");
            String txt_Email = (String) bundle.get("txtEmail");
            String txt_Description = (String) bundle.get("txtDescription");
            Integer day     =  bundle.getInt("day");
            Integer month   =  bundle.getInt("month");
            Integer year    =  bundle.getInt("year");
            txtName.setText(txt_Name);
            txtPhone.setText(txt_Phone);
            txtEmail.setText(txt_Email);
            txtDescription.setText(txt_Description);
            datePicker.updateDate(year, (month - 1), day);
        }


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                // Asignacion de InputText
                String  Name        = txtName.getText().toString();
                String  Phone       = txtPhone.getText().toString();
                String  Email       = txtEmail.getText().toString();
                String  Description = txtDescription.getText().toString();
                Integer day         = datePicker.getDayOfMonth();
                Integer month       = datePicker.getMonth();
                Integer year        = datePicker.getYear();
                Integer monthNew    = (month + 1);
                // Asignar PutExtras
                intent.putExtra("Name", Name);
                intent.putExtra("Phone", Phone);
                intent.putExtra("Email", Email);
                intent.putExtra("Description", Description);
                intent.putExtra("day", day);
                intent.putExtra("month", monthNew);
                intent.putExtra("year", year);
                intent.putExtra("year", year);
                startActivity(intent);
            }
        });



    }
}
