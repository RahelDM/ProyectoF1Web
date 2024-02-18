package org.pspr.entrega_formula.serviceImpl;

import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.repository.PilotoRepository;
import org.pspr.entrega_formula.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotoServiceImpl implements PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    @Override
    public List<Piloto> findAllPilotos() {
        return pilotoRepository.findAll();
    }

    @Override
    public List<Piloto> findPilotosAlAzar(int desde, int hasta) {
        return pilotoRepository.findPilotosAlAzar(desde,hasta);
    }

    @Override
    public Optional<Piloto> findPilotoById(Long id) {
        return pilotoRepository.findById(id);
    }

    @Override
    public Piloto save(Piloto piloto) {
        if(piloto!=null){
            return pilotoRepository.save(piloto);
        }
        return null;
    }


}
