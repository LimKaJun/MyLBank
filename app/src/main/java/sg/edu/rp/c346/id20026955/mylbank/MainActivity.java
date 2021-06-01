package sg.edu.rp.c346.id20026955.mylbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button DBS, OCBC, UOB;

    String clicked = "";
    String visit = "Website";
    String contact = "Contact Bank";
    String fav = "Added to Favourite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        OCBC = findViewById(R.id.OCBC);
        DBS = findViewById(R.id.DBS);
        UOB = findViewById(R.id.UOB);

        registerForContextMenu(OCBC);
        registerForContextMenu(DBS);
        registerForContextMenu(UOB);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,visit);
        menu.add(0,1,1,contact);
        menu.add(0, 2, 2,fav);
        if (v == OCBC){
            clicked = "OCBC";
        } else if (v == DBS){
            clicked = "DBS";
        } else if (v == UOB){
            clicked = "UOB";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (clicked == "OCBC") {
            if (item.getItemId() == 0) {
                Intent intentWebite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway"));
                startActivity(intentWebite);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (OCBC.getCurrentTextColor()==getResources().getColor(R.color.red)){
                    OCBC.setTextColor(getResources().getColor(R.color.black));
                } else {
                    OCBC.setTextColor(getResources().getColor(R.color.red));
                }
                return true;
            }
        } else if (clicked == "DBS") {
            if (item.getItemId() == 0) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com/default.page"));
                startActivity(intentWebsite);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800222200"));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (DBS.getCurrentTextColor()==getResources().getColor(R.color.red)){
                    DBS.setTextColor(getResources().getColor(R.color.black));
                } else {
                    DBS.setTextColor(getResources().getColor(R.color.red));
                }
                return true;
            }
        } else if (clicked == "UOB"){
            if (item.getItemId() == 0) {
                Intent intentWebite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/"));
                startActivity(intentWebite);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (UOB.getCurrentTextColor()==getResources().getColor(R.color.red)){
                    UOB.setTextColor(getResources().getColor(R.color.black));
                } else {
                    UOB.setTextColor(getResources().getColor(R.color.red));
                }
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
            }
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here.
                int id = item.getItemId();
                if (id == R.id.English) {
                    OCBC.setText(getString(R.string.ocbc));
                    DBS.setText(getString(R.string.dbs));
                    UOB.setText(getString(R.string.uob));
                    visit = getString(R.string.visit);
                    contact = getString(R.string.contact);
                    fav = getString(R.string.fav);
                    return true;
                } else if (id == R.id.Chinese) {
                    OCBC.setText(R.string.chiOCBC);
                    DBS.setText(R.string.chiDBS);
                    UOB.setText(R.string.chiUOB);
                    visit = getString(R.string.chiVisit);
                    contact = getString(R.string.chiDial);
                    fav = getString(R.string.chiFav);
                    return true;
                } else {
                    OCBC.setText(R.string.error);
                    DBS.setText(R.string.error);
                    UOB.setText(R.string.error);
                    visit = getString(R.string.error);
                    contact = getString(R.string.error);
                    fav = getString(R.string.error);
                }
                return super.onOptionsItemSelected(item);
            }

}