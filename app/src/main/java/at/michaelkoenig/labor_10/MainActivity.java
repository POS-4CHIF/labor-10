package at.michaelkoenig.labor_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE = 1;
    public static final String EXTRA_TAG = "KLASSE";

    private List<Klasse> klassen = new ArrayList<>();
    private ArrayAdapter<Klasse> klassenAdapter;
    private ListView lstvwKlassen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstvwKlassen = findViewById(R.id.lstvw_klassen);

        klassenAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                klassen);

        lstvwKlassen.setAdapter(klassenAdapter);

        lstvwKlassen.setOnItemClickListener((parent, view, position, id) -> {
            Klasse klasse = klassenAdapter.getItem(position);
            Intent intent = new Intent(this, KlasseActivity.class);
            intent.setAction(Intent.ACTION_VIEW);
            intent.putExtra(MainActivity.EXTRA_TAG, klasse);

            this.startActivityForResult(intent, REQUEST_CODE);
        });

        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.schueler)))) {
            String line;
            Map<String, List<Schueler>> klassenMap = new TreeMap<>();

            while ((line = br.readLine()) != null) {
                Schueler s = Schueler.fromCSV(line);
                if (klassenMap.containsKey(s.getKlasse())) // class already in map
                    klassenMap.get(s.getKlasse()).add(s);
                else // class not in map yet
                    klassenMap.put(s.getKlasse(), new ArrayList<Schueler>(Arrays.asList(s)));
            }

            klassenMap.entrySet().forEach(e -> klassen.add(new Klasse(e.getKey(), e.getValue())));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
