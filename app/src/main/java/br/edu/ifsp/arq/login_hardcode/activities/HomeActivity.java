package br.edu.ifsp.arq.login_hardcode.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import br.edu.ifsp.arq.login_hardcode.R;
import br.edu.ifsp.arq.login_hardcode.model.User;
import br.edu.ifsp.arq.login_hardcode.utils.ExtrasEnum;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        User user = (User) getIntent().getSerializableExtra(ExtrasEnum.USER_EXTRA.toString());
        validateCredentials(user);
    }

    private void validateCredentials(final User user) {
        String message = getString(R.string.error_message);
        if(user.getRegistration().equalsIgnoreCase(User.REGISTRATION_ALLOWED)) {
            if(user.getPassword().equalsIgnoreCase(User.PASSWORD_ALLOWED)) {
                message = getString(R.string.welcome_message).concat(" ") + user.getRegistration();
            }
        }
        setMessage(message);
    }

    private void setMessage(final String message) {
        TextView textView = findViewById(R.id.text_view_logged_id);
        textView.setText(message);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
