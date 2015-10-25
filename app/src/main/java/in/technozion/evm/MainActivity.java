package in.technozion.evm;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_main);
        session = new SessionManager(getApplicationContext());
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to home fragment
            getFragmentManager().beginTransaction()
                    .replace(R.id.container,new HomeFragment())
                    .addToBackStack(null)
                    .commit();
        }
        else
        {
            //User is not logged in, take him to login fragment
            getFragmentManager().beginTransaction()
                    .replace(R.id.container,new LoginFragment())
                    .addToBackStack(null)
                    .commit();
        }

    }
}
