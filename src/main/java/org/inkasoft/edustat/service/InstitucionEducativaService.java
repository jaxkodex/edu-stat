package org.inkasoft.edustat.service;

import java.util.List;

import org.inkasoft.edustat.model.InstitucionEducativa;

public interface InstitucionEducativaService {
    
    public InstitucionEducativa create (InstitucionEducativa institucionEducativa);
    public InstitucionEducativa loadById (Integer id);
    public List<InstitucionEducativa> findAll ();
    public InstitucionEducativa update (InstitucionEducativa institucionEducativa);
    public void delete (Integer id);

}
