package org.inkasoft.edustat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.inkasoft.edustat.bean.TurnoBean;
import org.inkasoft.edustat.model.Turno;
import org.inkasoft.edustat.repository.TurnoRepository;
import org.inkasoft.edustat.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoServiceImpl implements TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public List<TurnoBean> listActive() {
        List<TurnoBean> turnos = new ArrayList<TurnoBean>();
        for (Turno turno : turnoRepository.findAll()) {
            turnos.add(TurnoBean.transformToBean(turno));
        }
        return turnos;
    }

}
