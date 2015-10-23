package bap.uit.com.bap;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;


import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class Register extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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

    public void doRegister(View view){


        String nomS, prenomS, mailS, mdpS, mdpconfS, telS, adresseS, villeS;
        String codePS ="";
        int codePint=0;

        TextView nom =null;
        nom = (TextView) findViewById(R.id.nom);
        nomS=nom.getText()+"";

        TextView prenom =null;
        prenom = (TextView) findViewById(R.id.prenom);
        prenomS = prenom.getText()+"";

        TextView mail =null;
        mail = (TextView) findViewById(R.id.login);
//        mailS= mail.getText()+"";
        mailS="toto@tamer.fr";


        TextView mdp =null;
        mdp = (TextView) findViewById(R.id.mdp);
        mdpS =mdp.getText()+"";

        TextView mdpconf =null;
        mdpconf = (TextView) findViewById(R.id.mdpconf);
        mdpconfS = mdpconf.getText()+"";

        TextView tel =null;
        tel = (TextView) findViewById(R.id.tel);
        telS=tel.getText()+"";

        TextView adresse =null;
        adresse = (TextView) findViewById(R.id.adresse);
        adresseS= adresse.getText()+"";

        TextView ville =null;
        ville = (TextView) findViewById(R.id.ville);
        villeS= ville.getText()+"";

        TextView codeP =null;
        codeP = (TextView) findViewById(R.id.codepostal);
        codePS=codeP.getText()+"";
        if(codePS.equals("")){
            codePS=1+"";
        }
        codePint=Integer.parseInt(codePS);
        // faire ici le code

        if(!mdpS.equals(mdpconfS)){
            mdp.setText("");
            mdpconf.setText("");
            mdp.setHintTextColor(getResources().getColor(R.color.red));
            mdpconf.setHintTextColor(getResources().getColor(R.color.red));
            makeText(getApplicationContext(), "les mot de passe ne sont pas identiques", LENGTH_LONG).show();

        } else if(villeS.equals("")| adresseS.equals("") | mdpS.equals("") | nomS.equals("") | prenomS.equals("") | mailS.equals("")){
            makeText(getApplicationContext(), "Il faut remplir tout les champs", LENGTH_LONG).show();

        } else if (codePint<9999 | codePint>100000 ) {
            codeP.setText("");
            codeP.setHintTextColor(getResources().getColor(R.color.red));
            makeText(getApplicationContext(), "code postal invalide", LENGTH_LONG).show();
        }else {
            makeText(getApplicationContext(), "pouquoi tu clic batard ?", LENGTH_LONG).show();
            Intent intent = new Intent(Register.this, Login.class);
            startActivity(intent);
        }
    }

/*

    public void invokeWS(RequestParams params){
        // Show Progress Dialog
        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.43.17:9999/useraccount/login/dologin",params ,new AsyncHttpResponseHandler() {
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
    }

*/
    /*
    public Boolean register (Barber barber) {


        return ClientBuilder.newClient()
                .target("http://37.59.171.4/v1/memberdb/login")
                .request()
                .post(memberEntity)
                .readEntity(Boolean.class);
    }

        /*
        Barber barber = new Barber();
        barber.setNom("foo");
        Entity<Barber> barberEntity = Entity.entity(barber,
                MediaType.APPLICATION_JSON);
        Barber savedBarber = target("/barber").request().post(barberEntity)
                .readEntity(Barber.class);
        /*
          List<Barber> barberList = getAllBarber(barber, MediaType.APPLICATION_JSON);

          return ClientBuilder.newClient()
                .target("http://46.105.59.176/v1/odbc/login")
                .request()
                .post(memberEntity)
                .readEntity(Boolean.class);
        }*/
    public void doSubmit(View view){
         Intent intent = new Intent(Register.this,Intro.class);
         startActivity(intent);

    }

}
