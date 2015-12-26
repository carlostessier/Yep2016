package es.carlostessier.yep2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    final static String TAG = SignUpActivity.class.getSimpleName();

    private EditText usernameField;
    private EditText passwordField;
    private EditText emailAddressField;
    private MenuItem miActionProgressItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initializeViews();

    }

    private void initializeViews() {
        usernameField = (EditText) findViewById(R.id.usernameField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        emailAddressField = (EditText) findViewById(R.id.emailField);
    }

    public void actionSignupButton(View v){

        String sUsername = usernameField.getText().toString().trim();
        String sPassword = passwordField.getText().toString().trim();
        String sEmailAddress = emailAddressField.getText().toString().trim();


        String message ;

        if (sUsername.isEmpty())
        {
            message = String.format(getString(R.string.empty_field_message),getString(R.string.username_hint));
            errorFieldDialog(message);
        }
        else if (sPassword.isEmpty())
        {
            message = String.format(getString(R.string.empty_field_message),getString(R.string.password_hint));
            errorFieldDialog(message);

        }
        else if (sEmailAddress.isEmpty())
        {
            message = String.format(getString(R.string.empty_field_message),getString(R.string.email_hint));
            errorFieldDialog(message);

        }
        else{
            addUser(sUsername,sPassword,sEmailAddress);

        }



    }


    private void errorFieldDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.setTitle(R.string.signup_error_title);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        AlertDialog dialog = builder.create();

        dialog.show();

    }

    private void addUser(final String username, String password, String email) {
        showProgressBar();
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);


        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    String message = String.format(getString(R.string.add_user_error_message), username);
                    errorFieldDialog(message);
                }
                hideProgressBar();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up_activity, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Store instance of the menu item containing progress
        miActionProgressItem = menu.findItem(R.id.miActionProgress);
        // Extract the action-view from the menu item
        ProgressBar v =  (ProgressBar) MenuItemCompat.getActionView(miActionProgressItem);
        // Return to finish
        return super.onPrepareOptionsMenu(menu);
    }

    public void showProgressBar() {
        // Show progress item
        miActionProgressItem.setVisible(true);
    }

    public void hideProgressBar() {
        // Hide progress item
        miActionProgressItem.setVisible(false);
    }
}
