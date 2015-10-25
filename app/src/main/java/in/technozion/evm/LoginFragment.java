package in.technozion.evm;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    private Button btnLogin;
    private EditText inputevmid;
    private EditText inputPassword;
    private SessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //Remove title bar
        super.onCreate(savedInstanceState);
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
                  /*  Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                  */
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
