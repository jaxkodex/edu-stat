package org.inkasoft.edustat.service.impl;

import java.util.List;

import org.inkasoft.edustat.model.InstitucionEducativa;
import org.inkasoft.edustat.repository.InstitucionEducativaRepository;
import org.inkasoft.edustat.service.InstitucionEducativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitucionEducativaServiceImpl implements
        InstitucionEducativaService {
    @Autowired InstitucionEducativaRepository institucionEducativaRepository;

    public InstitucionEducativa create(InstitucionEducativa institucionEducativa) {
        return institucionEducativaRepository.save(institucionEducativa);
    }

    public List<InstitucionEducativa> findAll() {
        return institucionEducativaRepository.findAll();
    }

    public InstitucionEducativa update(InstitucionEducativa institucionEducativa) {
        return institucionEducativaRepository.save(institucionEducativa);
    }

    public void delete(Integer id) {
        institucionEducativaRepository.delete(id);
    }

    public InstitucionEducativa loadById(Integer id) {
        return institucionEducativaRepository.findOne(id);
    }

}
