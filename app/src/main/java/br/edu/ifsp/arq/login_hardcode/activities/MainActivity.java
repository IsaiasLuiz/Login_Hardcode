package br.edu.ifsp.arq.login_hardcode.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.arq.login_hardcode.R;
import br.edu.ifsp.arq.login_hardcode.model.User;
import br.edu.ifsp.arq.login_hardcode.utils.ExtrasEnum;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText registrationEditText;

    private EditText passwordEditText;

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrationEditText = findViewById(R.id.edit_text_registration_id);

        passwordEditText = findViewById(R.id.edit_text_password_id);

        btnLogin = findViewById(R.id.login_button_id);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnLogin) {
            getUserValues();
        }
    }

    private void getUserValues() {
        String registration = registrationEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        User user;

        if(registration.isEmpty() || password.isEmpty()) {
            showToast(getString(R.string.toast_message));
            return;
        }

        user =  new User(registration, password);

        // Nesse ponto poderia usar a classe Bundle, mas optei por usar a orientação a objetos e estudar um pouco mais sobre a passagem de dados

        Intent homeActivity = new Intent(this, HomeActivity.class);
        homeActivity.putExtra(ExtrasEnum.USER_EXTRA.toString(), user);
        startActivity(homeActivity);

    }

    private void showToast(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
