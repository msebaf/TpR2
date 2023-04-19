package usuario.example.tpanexoa.misActividades;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import usuario.example.tpanexoa.Models.Actividad;
import usuario.example.tpanexoa.R;
import usuario.example.tpanexoa.databinding.FragmentActividadBinding;
import usuario.example.tpanexoa.databinding.FragmentGalleryBinding;

public class ActividadFragment extends Fragment {

    private TextView nombreActividadTextView;
    private TextView fechaActividadTextView;
    private TextView horaActividadTextView;
    private TextView detalleActividadTextView;
    private TextView lugarActividadTextView;

    private FragmentActividadBinding binding;


    private Actividad actividad;
    private ActividadViewModel vm ;
    public ActividadFragment() {
        // Required empty public constructor
    }

    public static ActividadFragment newInstance() {
        return new ActividadFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(ActividadViewModel.class);

        binding = FragmentActividadBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (getArguments() != null) {
            actividad = (Actividad) getArguments().getSerializable("actividad");
            vm.CargarListaConDetalle(binding,actividad);
        }
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*nombreActividadTextView = view.findViewById(R.id.tvNombreActividad);
        //fechaActividadTextView = view.findViewById(R.id.tvFecha);
        horaActividadTextView = view.findViewById(R.id.tvHora);
        detalleActividadTextView = view.findViewById(R.id.tvDescripcionActividad);
        lugarActividadTextView = view.findViewById(R.id.tvLugarDetalle);

        if (actividad != null) {
            nombreActividadTextView.setText(actividad.getNombre());
            //fechaActividadTextView.setText(new SimpleDateFormat("dd/MM/yyyy").format(actividad.getFecha()));
            horaActividadTextView.setText(actividad.getHora());
            detalleActividadTextView.setText(actividad.getDescripcion());
            lugarActividadTextView.setText(actividad.getLugar());
        }*/
    }
}
