package in.technozion.evm;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Student on 25-10-2015.
 */
public class HomeFragment extends Fragment{

    public Button btnedit;
    public Button btnedit1;
    public Button btnpar;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Remove title bar

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnedit=(Button)getActivity().findViewById(R.id.btnedit);
        btnedit1=(Button)getActivity().findViewById(R.id.btnedit1);
        btnpar=(Button)getActivity().findViewById(R.id.btnpar);

        btnedit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Check for empty data in the form
                Log.d("Edit","EDITED");
            }

        });

        btnedit1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Check for empty data in the form
                Log.d("Edit1","EDITED1");

            }

        });

        btnpar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Check for empty data in the form
                Log.d("Parti","participants");
            }

        });
    }
    }
