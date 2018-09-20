package service;

import model.Diagnosis;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DiagnosisService {
    @Autowired
    private SessionFactory sessionFactory;

    public Diagnosis addDiagnosis(Diagnosis diagnosis) {
        this.sessionFactory.getCurrentSession().save(diagnosis);
        return diagnosis;
    }

    public List<Diagnosis> getAllDiagnoses() {
        return this.sessionFactory.getCurrentSession().createQuery("from Diagnosis").list();
    }
}
