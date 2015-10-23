package bap.uit.com.bap;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import java.util.List;

import static android.widget.Toast.*;

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



    public Boolean register (Barber barber) {
          List<Barber> barberList = getAllBarber(barber, MediaType.APPLICATION_JSON);

          return ClientBuilder.newClient()
                .target("http://46.105.59.176/v1/odbc/login")
                .request()
                .post(memberEntity)
                .readEntity(Boolean.class);
        }

        public void doSubmit(View view){
         Intent intent = new Intent(Register.this,MainActivity.class);
         startActivity(intent);

        }
    }
}