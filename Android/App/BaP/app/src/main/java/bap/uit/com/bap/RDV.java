package bap.uit.com.bap;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import static android.widget.Toast.*;

public class RDV extends AppCompatActivity {


    DialogFragment dial;

    private TextView selection;
    private static final String[] items={"-choisir un Barbier-","Barbier 1", "Barbier 2", "Barbier 3", "Barbier 4", "Barbier 5", "Barbier 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdv);

        // ici trouver la liste de barbier

        
        Spinner spin=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rdv, menu);
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

/*
    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

*/


    public void doValide(View v){

        String nomBarbierS, heureS, dateS;

        Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
        nomBarbierS = mySpinner.getSelectedItem().toString();

        TextView heure =null;
        heure = (TextView) findViewById(R.id.date);
        heureS= heure.getText()+"";

        TextView date =null;
        date = (TextView) findViewById(R.id.heure);
        dateS= date.getText()+"";

        //String tempo = "vous avez bien pris rdv avec le barbier :"+start.getText()+" à "+heure.getText()+" le "+date.getText();
        makeText(getApplicationContext(),"votre rendez vous avec "+nomBarbierS+" à "+heureS+" le "+dateS+" est envoyé.... batard",LENGTH_LONG).show();
        Intent intent = new Intent(RDV.this,ChoixClient.class);
        startActivity(intent);
    }
}
