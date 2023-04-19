package usuario.example.tpanexoa.misActividades;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import usuario.example.tpanexoa.Models.Actividad;
import usuario.example.tpanexoa.R;

public class ListaActividadesAdapter extends RecyclerView.Adapter<ListaActividadesAdapter.ViewHolder> {

    private Context context;
    private List<Actividad> actividades;
    private LayoutInflater inflater;

    public ListaActividadesAdapter(Context context, List<Actividad> actividades, LayoutInflater inflater) {
        this.context = context;
        this.actividades = actividades;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.item_actividad, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actividad actividad = actividades.get(position);
        holder.nombre.setText(actividad.getNombre());
        holder.fecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(actividad.getFecha()));
        holder.hora.setText(actividad.getHora());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir el fragmento de detalle y pasar la información de la actividad
                Fragment fragment = new MisActividadesFragment();
                Bundle args = new Bundle();
                args.putSerializable("actividad", actividad);
                fragment.setArguments(args);
                FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout2, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, fecha, hora;
        Button btnDetalleActividad;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombreActividad);
            fecha = itemView.findViewById(R.id.tvFecha);
            hora = itemView.findViewById(R.id.tvHora);
            btnDetalleActividad = itemView.findViewById(R.id.btnDetalleActividad);

            btnDetalleActividad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Abrir la vista de detalles de la actividad

                    Bundle args = new Bundle();
                    args.putSerializable("actividad", actividades.get(getAdapterPosition()));
                    Log.d("salida" , args+"");
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_mi_menu).navigate(R.id.action_nav_misActividades_to_actividadFragment, args);


                }
            });
        }


    }
}
