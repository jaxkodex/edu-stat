package org.inkasoft.edustat.service;

import java.util.List;

import org.inkasoft.edustat.bean.ClaseBean;

public interface ClaseService {
	
	public List<ClaseBean> cargarClasesPorPeriodo (Integer idPeriodo);
	public List<ClaseBean> generarClasesParaPeriodo (Integer idPeriodo);

}
