package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entities.Diagnosis;
import pl.coderslab.repositories.DiagnosisRepository;

import java.util.List;

@Service
@Transactional
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public void save(Diagnosis diagnosis)  {
        diagnosisRepository.save(diagnosis);
    }

    @Override
    public void update(Diagnosis diagnosis)   {
        diagnosisRepository.save(diagnosis);
    }

    @Override
    public Diagnosis find(Long id)  {
        return diagnosisRepository.getOne(id);
    }

    @Override
    public void delete(Long id)  {
        diagnosisRepository.delete(id);
    }

    @Override
    public List<Diagnosis> findAll()  {
        return diagnosisRepository.findAll();
    }
}
