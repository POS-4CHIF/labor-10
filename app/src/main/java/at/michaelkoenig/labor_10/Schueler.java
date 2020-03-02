package at.michaelkoenig.labor_10;

import java.io.Serializable;

/**
 * @author reio
 */
public class Schueler implements Serializable, Comparable<Schueler> {

    private final String klasse;
    private final int nr;
    private final String nachname;
    private final String vorname;
    private final char geschlecht;


    public Schueler(String klasse, int nr, String nachname, String vorname, char geschlecht) {
        this.klasse = klasse;
        this.nr = nr;
        this.nachname = nachname;
        this.vorname = vorname;
        this.geschlecht = geschlecht;
    }

    public static Schueler fromCSV(String csv) {
        String[] token = csv.split(",");
        String nachname = token[0];
        String vorname = token[1];
        char geschlecht = token[2].charAt(0);
        int kat = Integer.parseInt(token[3]);
        String klasse = token[4];
        return new Schueler(klasse, kat, nachname, vorname, geschlecht);
    }

    public String getNachname() {
        return nachname;
    }

    public int getNr() {
        return nr;
    }

    public String getVorname() {
        return vorname;
    }

    public char getGeschlecht() {
        return geschlecht;
    }

    public String getKlasse() {
        return klasse;
    }

    public boolean isWeiblich() {
        return geschlecht == 'W';
    }

    @Override
    public String toString() {
        return String.format("%02d %s %s", nr, nachname, vorname);
    }

    @Override
    public int compareTo(Schueler o) {
        return nr - o.nr;
    }
}
