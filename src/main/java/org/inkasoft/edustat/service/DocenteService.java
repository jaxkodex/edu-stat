package org.inkasoft.edustat.service;

import java.util.List;

import org.inkasoft.edustat.bean.DocenteBean;
import org.inkasoft.edustat.model.Docente;

public interface DocenteService {
	
	public DocenteBean create(Docente docente) throws Exception;
	public DocenteBean loadById(Integer id);
	public List<DocenteBean> findAll ();
	public List<DocenteBean> findAllByIe (Integer idIe);
	public DocenteBean update (Docente docente) throws Exception;
	public void delete (Integer id);

}
