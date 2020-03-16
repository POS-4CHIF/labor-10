package at.michaelkoenig.labor_10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KlasseAdapter extends RecyclerView.Adapter<KlasseAdapter.KlasseViewHolder> {
    private List<Klasse> klassen;
    private CustomClickListener clickListener;

    public KlasseAdapter(List<Klasse> klassen, CustomClickListener clickListener) {
        this.klassen = klassen;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public KlasseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("onCreateViewHolder");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.klasse_row, parent, false);
        return new KlasseViewHolder(v, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull KlasseViewHolder holder, int position) {
        holder.txtName.setText(klassen.get(position).getName());
        holder.txtCount.setText(Integer.toString(klassen.get(position).getSchueler().size()));
    }

    @Override
    public int getItemCount() {
        return klassen.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class KlasseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName;
        TextView txtCount;
        CustomClickListener clickListener;

        public KlasseViewHolder(View itemView, CustomClickListener clickListener) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtCount = itemView.findViewById(R.id.txtCount);
            this.clickListener = clickListener;
            itemView.setOnClickListener((View.OnClickListener) this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(getAdapterPosition());
        }
    }

    interface CustomClickListener {
        void onClick(int position);
    }

}
