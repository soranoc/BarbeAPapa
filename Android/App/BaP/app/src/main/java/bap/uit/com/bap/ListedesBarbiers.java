package bap.uit.com.bap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ListedesBarbiers extends AppCompatActivity {


    public static String nom="";

    private static final String[] items={"-choisir un Barbier-","Barbier 1", "Barbier 2", "Barbier 3", "Barbier 4", "Barbier 5", "Barbier 6"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listedes_barbiers);
        Spinner spin=(Spinner)findViewById(R.id.listeBarbiers);
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listedes_barbiers, menu);
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

    public void doVoirProfil(View view){


        Spinner mySpinner=(Spinner) findViewById(R.id.listeBarbiers);
        String text = mySpinner.getSelectedItem().toString();

        Intent intent = new Intent(ListedesBarbiers.this, PageBarbier.class);
        intent.putExtra(nom, text);
        startActivity(intent);
    }
}
