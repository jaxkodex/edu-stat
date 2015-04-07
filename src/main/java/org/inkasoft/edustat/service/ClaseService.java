package org.inkasoft.edustat.service;

import java.util.List;

import org.inkasoft.edustat.bean.ClaseBean;
import org.inkasoft.edustat.model.Clase;

public interface ClaseService {
    
    public List<ClaseBean> cargarClasesPorPeriodo (Integer idPeriodo);
    public List<ClaseBean> generarClasesParaPeriodo (Integer idPeriodo);
    
    public List<ClaseBean> cargarClasesPorPeriodoTurnoNivel (Integer idPeriodo, Integer idNivel, Integer idTurno);

    public ClaseBean actualizarClase (Clase clase);
    
    public ClaseBean loadClase (Integer idClase);
}
