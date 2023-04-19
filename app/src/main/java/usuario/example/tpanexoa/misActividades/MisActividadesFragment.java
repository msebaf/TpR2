package usuario.example.tpanexoa.misActividades;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

import usuario.example.tpanexoa.Models.Actividad;
import usuario.example.tpanexoa.R;

public class MisActividadesFragment extends Fragment {

    private MisActividadesViewModel mViewModel;
    private RecyclerView rvLista;

    public static MisActividadesFragment newInstance() {
        return new MisActividadesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mis_actividades, container, false);

        ArrayList<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad("Yoga en el parque", "Clase de yoga al aire libre en el parque", new Date(1220227200000L), "9:00 am", "Parque Central")); // 01/09/2008 9:00 AM
        lista.add(new Actividad("Concierto en vivo", "Concierto de música rock en vivo", new Date(1420070400000L), "7:00 pm", "Estadio Municipal")); // 01/01/2015 7:00 PM
        lista.add(new Actividad("Cine bajo las estrellas", "Proyección de película al aire libre", new Date(1609459200000L), "8:30 pm", "Plaza de Armas")); // 01/01/2021 8:30 PM
        lista.add(new Actividad("Tour de arte urbano", "Recorrido por los murales y graffitis de la ciudad", new Date(1496232000000L), "2:00 pm", "Punto de encuentro: Centro Cultural")); // 31/05/2017 2:00 PM
        lista.add(new Actividad("Clases de cocina", "Taller de cocina italiana", new Date(1514764800000L), "10:00 am", "Cocina Central")); // 01/01/2018 10:00 AM


        rvLista = root.findViewById(R.id.rvLista);

        GridLayoutManager grilla = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rvLista.setLayoutManager(grilla);

        ListaActividadesAdapter adapter = new ListaActividadesAdapter(getContext(), lista, getLayoutInflater());
        rvLista.setAdapter(adapter);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MisActividadesViewModel.class);
        // TODO: Use the ViewModel
    }

}
