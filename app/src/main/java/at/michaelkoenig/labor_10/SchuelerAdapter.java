package at.michaelkoenig.labor_10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SchuelerAdapter extends RecyclerView.Adapter<SchuelerAdapter.SchuelerViewHolder> {
    private List<Schueler> schueler;

    public SchuelerAdapter(List<Schueler> schueler) {
        this.schueler = schueler;
    }

    @NonNull
    @Override
    public SchuelerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("onCreateViewHolder");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.schueler_row, parent, false);
        return new SchuelerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SchuelerViewHolder holder, int position) {
        Schueler s = schueler.get(position);
        holder.txtNr.setText(Integer.toString(s.getNr()));
        holder.txtNachname.setText(s.getNachname());
        holder.txtVorname.setText(s.getVorname());
        if (s.isWeiblich()) {
            holder.imgGeschlecht.setImageResource(R.drawable.female);
        } else {
            holder.imgGeschlecht.setImageResource(R.drawable.male);
        }

    }

    @Override
    public int getItemCount() {
        return schueler.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class SchuelerViewHolder extends RecyclerView.ViewHolder {
        TextView txtNr;
        TextView txtNachname;
        TextView txtVorname;
        ImageView imgGeschlecht;

        public SchuelerViewHolder(View itemView) {
            super(itemView);
            txtNr = itemView.findViewById(R.id.txtNr);
            txtNachname = itemView.findViewById(R.id.txtNachname);
            txtVorname = itemView.findViewById(R.id.txtVorname);
            txtVorname = itemView.findViewById(R.id.txtVorname);
            imgGeschlecht = itemView.findViewById(R.id.imgGeschlecht);
        }
    }


}
