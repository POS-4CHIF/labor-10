package at.michaelkoenig.labor_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KlasseActivity extends AppCompatActivity {

    private List<Schueler> schueler;
    private ArrayAdapter<Schueler> schuelerAdapter;
    private ListView lstvwSchueler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klasse);
        lstvwSchueler = findViewById(R.id.lstvw_schueler);

        Intent intent = getIntent();
        if (intent.getAction().equals(Intent.ACTION_VIEW)) {
            Klasse klasse = (Klasse) intent.getSerializableExtra(MainActivity.EXTRA_TAG);
            setTitle(klasse.getName());
            schueler = klasse.getSchueler();
            Collections.sort(schueler);;
            schuelerAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1,
                    schueler);
            lstvwSchueler.setAdapter(schuelerAdapter);
        }
    }
}
