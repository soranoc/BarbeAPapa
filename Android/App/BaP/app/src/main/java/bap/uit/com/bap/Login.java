package bap.uit.com.bap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class Login extends Activity {

    public static String log="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void doLogin(View view){

        String mdpS;
        String loginS;
        TextView login =null;
        login = (TextView) findViewById(R.id.login);
        loginS = login.getText()+"";

        TextView mdp =null;
        mdp = (TextView) findViewById(R.id.mdp);
        mdpS = mdp.getText()+"";

        if(loginS.equals("") & mdpS.equals("")){
            login.setHintTextColor(getResources().getColor(R.color.red));
            mdp.setHintTextColor(getResources().getColor(R.color.red));
            makeText(getApplicationContext(), "il faut rentrer un login et un mot de passe", LENGTH_LONG).show();
        } else if(mdpS.equals("")) {
            mdp.setHintTextColor(getResources().getColor(R.color.red));
            makeText(getApplicationContext(), "il faut rentrer un mot de passe", LENGTH_LONG).show();
        }else if(loginS.equals("")){
            login.setHintTextColor(getResources().getColor(R.color.red));
            makeText(getApplicationContext(), "il faut rentrer un login", LENGTH_LONG).show();
        }else {

            Intent intent = new Intent(Login.this, ChoixClient.class);
            makeText(getApplicationContext(), "Bonjour " + loginS + " et Bienvenue !", LENGTH_LONG).show();
            intent.putExtra(log, loginS);
            startActivityForResult(intent, 0);
        }

    }
/*
    public void invokeWS(RequestParams params){
        // Show Progress Dialog
        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("46.105.59.176/v1/barber",params ,new AsyncHttpResponseHandler() {
            // When the response returned by REST has Http response code '200'

            @Override
            public void onSuccess(String response) {
                // Hide Progress Dialog
                try {
                    // JSON Object
                    JSONObject obj = new JSONObject(response);
                    // When the JSON response has status boolean value assigned with true
                    if(obj.getBoolean("status")){
                        Toast.makeText(getApplicationContext(), "You are successfully logged in!", Toast.LENGTH_LONG).show();
                        // Navigate to Home screen
                    }
                    // Else display error message
                    else{
                        Toast.makeText(getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }
            }
            // When the response returned by REST has Http response code other than '200'
            @Override
            public void onFailure(int statusCode, Throwable error,
                                  String content) {
                // Hide Progress Dialog
                // When Http response code is '404'
                if(statusCode == 404){
                    Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                }
                // When Http response code is '500'
                else if(statusCode == 500){
                    Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                }
                // When Http response code other than 404, 500
                else{
                    Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                }
            }
        });
    }*/

}
