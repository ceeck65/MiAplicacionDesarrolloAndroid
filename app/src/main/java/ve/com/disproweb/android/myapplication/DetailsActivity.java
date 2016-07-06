package ve.com.disproweb.android.myapplication;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

public class DetailsActivity extends AppCompatActivity {

    Button btnNext;
    TextInputEditText txtName, txtPhone, txtEmail, txtDescription;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }
}
