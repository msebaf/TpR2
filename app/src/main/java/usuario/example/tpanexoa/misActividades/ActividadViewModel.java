package usuario.example.tpanexoa.misActividades;

import androidx.lifecycle.ViewModel;

import usuario.example.tpanexoa.Models.Actividad;
import usuario.example.tpanexoa.databinding.FragmentActividadBinding;

public class ActividadViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    public void CargarListaConDetalle(FragmentActividadBinding binding, Actividad actividad)
    {
        binding.tvLugarDetalle.setText(actividad.getLugar());
        binding.tvDescripcionActividad.setText(actividad.getDescripcion());
        binding.tvFechaDetalle.setText(actividad.getFecha() + "");
        binding.tvHoraDetalle.setText(actividad.getHora());
        binding.tvNombreActividadDetalle.setText(actividad.getNombre());
    }
}