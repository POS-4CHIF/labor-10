package at.michaelkoenig.labor_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity implements KlasseAdapter.CustomClickListener {
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE = 1;
    public static final String EXTRA_TAG = "KLASSE";

    private List<Klasse> klassen = new ArrayList<>();
    private KlasseAdapter klassenAdapter;
    private RecyclerView recvwKlassen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recvwKlassen = findViewById(R.id.recvw_klassen);
        recvwKlassen.setLayoutManager(new LinearLayoutManager(this));

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

        klassenAdapter = new KlasseAdapter(klassen, this);
        recvwKlassen.setAdapter(klassenAdapter);

    }


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this, SchuelerActivity.class);
        intent.putExtra(EXTRA_TAG, klassen.get(position));
        intent.setAction(Intent.ACTION_VIEW);
        startActivity(intent);
    }
}
