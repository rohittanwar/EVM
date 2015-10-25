package in.technozion.evm;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import in.technozion.evm.data.URLS;
import in.technozion.evm.data.Util;

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
                    new LoginTask().execute(evmid, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getActivity(), "Please enter the credentials!", Toast.LENGTH_LONG).show();
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
public class LoginTask extends AsyncTask<String,Void,HashMap<String ,String>> {

    private ProgressDialog progressDialog;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Logging in..");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected HashMap<String ,String> doInBackground(String... strings) {

        if (strings==null||strings.length<2) return null;
        if(strings[0]==null||strings[0].length()==0) return null;
        if(strings[1]==null||strings[1].length()==0) return null;

        HashMap<String,String> hashMapPostData=new HashMap();
        Log.d("email in log",strings[0]);
        Log.d("password in log",strings[1]);
        hashMapPostData.put("email", strings[0]);
        hashMapPostData.put("password",strings[1]);

        String jsonstr= Util.getStringFromURL(URLS.LOGIN_URL, hashMapPostData);
      //  Log.d("JSON Response",jsonstr);
        if (jsonstr!=null) {
            Log.d("GOT FROM HTTP", jsonstr);
            try {
                JSONObject jsonObject=new JSONObject(jsonstr);

                if(jsonObject.getString("status").equalsIgnoreCase("success")) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("email", jsonObject.getString("email"));
                //    Log.d("Email",jsonObject.getString("email"));
                    return hashMap;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
//            JSONObject jsonObject=new JSONObject(jsonstr);
        return null;
    }

    @Override
    protected void onPostExecute(HashMap<String ,String> hashMap) {
        super.onPostExecute(hashMap);
        if (progressDialog.isShowing()) {
            progressDialog.cancel();
        }
        if(hashMap!=null)
        {
            SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getActivity());
            SharedPreferences.Editor editor= sharedPreferences.edit();

            for(String s:hashMap.keySet()){
                editor.putString(s,hashMap.get(s));
            }
            SessionManager session=new SessionManager(getActivity());
            session.setLogin(true);
            //editor.putBoolean("logged_in", true);
//                if(hashMap.get("registration").equalsIgnoreCase("paid") && hashMap.get("hospitality").equalsIgnoreCase("paid"))
//                    editor.putBoolean("registered",true);
          //  editor.apply();

//                Intent intent=new Intent(getContext(), MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            getFragmentManager().beginTransaction()
                    .replace(R.id.container,new HomeFragment())
                    .addToBackStack(null)
                    .commit();
        }

    }
}
}