package bap.uit.com.bap;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class IndexBarbier extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_barbier);
        final Intent intent = getIntent();
        String param2 = intent.getStringExtra(Jesuis.param);
        makeText(getApplicationContext(),param2,LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_index_barbier, menu);
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

            Intent intent2 = new Intent(IndexBarbier.this, InscriptionBarbier.class);
            startActivity(intent2);
    }
    public void doLogin(View view){
            Intent intent = new Intent(IndexBarbier.this, LoginBarbier.class);
            startActivity(intent);
    }
}
