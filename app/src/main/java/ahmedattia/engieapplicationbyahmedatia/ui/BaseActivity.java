package ahmedattia.engieapplicationbyahmedatia.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ahmedattia.engieapplicationbyahmedatia.R;

/**
 * Created by Ahmed Attia on 06/05/2017.
 */
public class BaseActivity extends AppCompatActivity {
    Button goToSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


        goToSignUpButton = (Button) findViewById(R.id.log);
        goToSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUp = new Intent(BaseActivity.this, SignUpActivity.class);
                startActivity(SignUp);
            }
        });

    }


}




