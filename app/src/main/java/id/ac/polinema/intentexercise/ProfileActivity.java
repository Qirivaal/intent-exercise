package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private TextView fullname;
    private TextView email;
    private TextView homepage;
    private TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fullname = findViewById(R.id.label_fullname);
        email = findViewById(R.id.label_email);
        homepage = findViewById(R.id.label_homepage);
        about = findViewById(R.id.label_about);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            fullname.setText(extras.getString("fullname"));
            email.setText(extras.getString("email"));
            homepage.setText(extras.getString("homepage"));
            about.setText(extras.getString("about"));
        }
        else{
            Toast.makeText(this,"Intent is missing", Toast.LENGTH_SHORT).show();
        }
    }

    public void handleHomepage(View view) {
        String alamat = homepage.getText().toString();
        String url = "http://www."+ alamat;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
