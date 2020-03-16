package at.michaelkoenig.labor_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SchuelerActivity extends AppCompatActivity {

    private List<Schueler> schueler;
    private SchuelerAdapter schuelerAdapter;
    private RecyclerView recvwSchueler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klasse);
        recvwSchueler = findViewById(R.id.recvw_schueler);
        recvwSchueler.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        if (intent.getAction().equals(Intent.ACTION_VIEW)) {
            Klasse klasse = (Klasse) intent.getSerializableExtra(MainActivity.EXTRA_TAG);
            setTitle(klasse.getName());
            schueler = klasse.getSchueler();
            Collections.sort(schueler);

            schuelerAdapter = new SchuelerAdapter(schueler);
            recvwSchueler.setAdapter(schuelerAdapter);
        }
    }
}
