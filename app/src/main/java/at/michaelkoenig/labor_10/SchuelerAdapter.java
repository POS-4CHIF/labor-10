package at.michaelkoenig.labor_10;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.List;

public class SchuelerAdapter extends ArrayAdapter<Schueler> {

    private Activity context;
    private List<Schueler> schueler;

    public SchuelerAdapter(Activity context, List<Schueler> schueler) {
        super(context, R.layout.schueler_row);
        this.context = context;
        this.schueler = schueler;
    }
}
