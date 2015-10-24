package in.technozion.evm;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText inputevmid;
    private EditText inputPassword;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Remove title bar
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
//Remove notification bar
      //  this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getFragmentManager().beginTransaction()
                .replace(R.id.container,new HomeFragment())
                .addToBackStack(null)
                .commit();


        inputevmid = (EditText) findViewById(R.id.evmid);
        inputPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        session = new SessionManager(getApplicationContext());
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            getFragmentManager().beginTransaction()
                    .replace(R.id.container,new HomeFragment())
                    .addToBackStack(null)
                    .commit();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String evmid = inputevmid.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                getFragmentManager().beginTransaction()
                        .replace(R.id.container,new HomeFragment())
                        .addToBackStack(null)
                        .commit();

                // Check for empty data in the form
                if (!evmid.isEmpty() && !password.isEmpty()) {
                    // login user
               //     checkLogin(evmid, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }
            }

        });
    }
    public void checkLogin(String evmid, String password)
    {

   //     if(1)   //IF SUCCESSFUL LOGIN
        {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new HomeFragment())
                    .addToBackStack(null)
                    .commit();
        }
  //      else
        {
            //Toast a message
        }
    }
}
