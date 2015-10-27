package in.technozion.evm;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    private Button btnLogin;
    private EditText inputevmid;
    private EditText inputPassword;
    private SessionManager session;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnLogin=(Button)getActivity().findViewById(R.id.btnLogin);
        inputevmid=(EditText)getActivity().findViewById(R.id.evmid);
        inputPassword=(EditText)getActivity().findViewById(R.id.password);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String evmid = inputevmid.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();


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

    public void onCreate(Bundle savedInstanceState) {

        //Remove title bar
        super.onCreate(savedInstanceState);

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
