package bap.uit.com.bap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PageBarbier extends AppCompatActivity {

    public static String nom="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_barbier);

        final Intent intent = getIntent();
        nom= intent.getStringExtra(ListedesBarbiers.nom);
        //il faut recup la bdd ici
        String entrepriseS=nom;
        intent.putExtra(nom, nom);

        TextView entreprise =null;
        entreprise = (TextView) findViewById(R.id.entreprise);
        entreprise.setText(entrepriseS);

        String descriptionS="blblkjsjkfhsjkdhf sfjeskfhgjksgf klfgksjgj kgkjhgiuer tkj jdhgkjh  merci";
        TextView description =null;
        description = (TextView) findViewById(R.id.description);
        description.setText(descriptionS);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page_barbier, menu);
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
        Intent intent = new Intent(PageBarbier.this, RDV.class);
        intent.putExtra(nom, nom);
        startActivity(intent);
    }
}
