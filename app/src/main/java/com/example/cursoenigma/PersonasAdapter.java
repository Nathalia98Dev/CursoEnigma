package com.example.cursoenigma;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonasAdapter extends RecyclerView.Adapter<PersonasAdapter.PersonasItemView>{

    private List<Personas> datos;

    public PersonasAdapter(List<Personas> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public PersonasItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View personaItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.persona_item, parent, false);
        return new PersonasItemView(personaItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonasItemView holder, int position) {
        holder.tvNombre.setText(datos.get(position).getNombre());
        holder.tvApellido.setText(datos.get(position).getApellido());
        holder.tvEdad.setText("" + datos.get(position).getEdad());
        holder.tvTelefono.setText(datos.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class PersonasItemView extends RecyclerView.ViewHolder {

        TextView tvNombre;
        TextView tvApellido;
        TextView tvEdad;
        TextView tvTelefono;

        public PersonasItemView(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellido = itemView.findViewById(R.id.tvApellido);
            tvEdad = itemView.findViewById(R.id.tvEdad);
            tvTelefono = itemView.findViewById(R.id.tvTelefono);
        }
    }
}
