package bap.uit.com.bap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class ChoixClient extends AppCompatActivity {

    public static String log="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_client);
        final Intent intent = getIntent();
        log= intent.getStringExtra(Login.log);
        makeText(getApplicationContext(),log,LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choix_client, menu);
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

    public void doReserver(View view){
        Intent intent = new Intent(ChoixClient.this, RDV.class);
        startActivity(intent);
    }

    public void doLister(View view){
        Intent intent = new Intent(ChoixClient.this, ListedesBarbiers.class);
        startActivity(intent);
    }
}
