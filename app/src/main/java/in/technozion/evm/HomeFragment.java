package in.technozion.evm;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Student on 25-10-2015.
 */
public class HomeFragment extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //Remove title bar
        super.onCreate(savedInstanceState);

        (getActivity()).getActionBar().show();




    }



}
