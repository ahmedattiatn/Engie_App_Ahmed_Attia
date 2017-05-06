package ahmedattia.engieapplicationbyahmedatia.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ahmedattia.engieapplicationbyahmedatia.R;
import ahmedattia.engieapplicationbyahmedatia.network.GetUserFromServer;
import ahmedattia.engieapplicationbyahmedatia.utils.SignUpActivityPresenter;

/**
 * Created by Ahmed Attia on 06/05/2017.
 */

public class SignUpActivity extends AppCompatActivity {
    String mailText;
    EditText mail;
    Button SignUpUserButton;
    private SignUpActivityPresenter signUpActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUpActivityPresenter = new SignUpActivityPresenter();

        mail = (EditText) findViewById(R.id.et_mail);
        SignUpUserButton = (Button) findViewById(R.id.btnSignUp);
        SignUpUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailText = mail.getText().toString();
                if (signUpActivityPresenter.isEmailValid(mailText)) {
                    GetUserFromServer.sendUser(mailText, SignUpActivity.this);

                } else {
                    Toast.makeText(SignUpActivity.this, R.string.mail_ver, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

