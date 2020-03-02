package at.michaelkoenig.labor_10;

import java.io.Serializable;
import java.util.List;

public class Klasse implements Serializable {
    private String name;
    private List<Schueler> schueler;

    public Klasse(String name, List<Schueler> schueler) {
        this.name = name;
        this.schueler = schueler;
    }

    public String getName() {
        return name;
    }

    public List<Schueler> getSchueler() {
        return schueler;
    }

    @Override
    public String toString() {
        return name + " (" + schueler.size() + ")";
    }
}
