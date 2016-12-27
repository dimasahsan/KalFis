package id.dimas.android.kalkulatorfisika;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnBabClickListener {

    private static final String LOG_TAG = MainActivity.class.getName();

    private RecyclerView mRecyclerView;

    private BabRVAdapter mAdapter;

    private List<String> bab = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_mainactivity);

        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(llm);



        bab.add("Besaran dan Satuan");
        bab.add("Gerak Lurus");
        bab.add("Hukum Newton");
        bab.add("Memandu gerak");
        bab.add("Gerak Melingkar");
        bab.add("Gravitasi");
        bab.add("Usaha dan Energi");
        bab.add("Momentum");
        bab.add("Elastisitas");
        bab.add("Fluida");

        mAdapter = new BabRVAdapter(bab, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onBabClick() {
        Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);

        startActivity(detailIntent);
    }
}
