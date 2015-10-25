package in.technozion.evm.data;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Set;

public class Util {
    public static String getStringFromURL(String s,HashMap<String,String> hashMap){
        try {
            URL url=new URL(s);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();
            StringBuilder data=new StringBuilder();
            for (String key:hashMap.keySet()){
                data.append(key);
                data.append('=');
                data.append(URLEncoder.encode(hashMap.get(key), "UTF-8"));
                data.append('&');
            }
            data.deleteCharAt(data.length()-1);
            Log.d("checking_send_data", data.toString());

            OutputStreamWriter out = new OutputStreamWriter(httpURLConnection.getOutputStream());
            out.write(data.toString());
            out.close();
            int HttpResult =httpURLConnection.getResponseCode();
            if(HttpResult ==HttpURLConnection.HTTP_OK) {
                InputStream is = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                return builder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getStringFromURL(String s) {
        try {
            URL url=new URL(s);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            InputStream is=httpURLConnection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder builder=new StringBuilder();
            while((line=reader.readLine())!=null){
                builder.append(line);
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}