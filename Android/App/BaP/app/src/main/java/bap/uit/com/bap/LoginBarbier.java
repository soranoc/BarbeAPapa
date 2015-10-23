package bap.uit.com.bap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class LoginBarbier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_barbier);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_barbier, menu);
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
            Intent intent = new Intent(LoginBarbier.this, EDT_Barbier.class);
            makeText(getApplicationContext(), "Bonjour " + loginS + " et Bienvenue !", LENGTH_LONG).show();
            startActivity(intent);
        }
    }
}
