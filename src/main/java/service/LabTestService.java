package service;

import model.LabTest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LabTestService {
    @Autowired
    private SessionFactory sessionFactory;

    public LabTest addLabTest(LabTest labTest) {
        this.sessionFactory.getCurrentSession().save(labTest);
        return labTest;
    }

    public List<LabTest> getAllLabTests() {
        return this.sessionFactory.getCurrentSession().createQuery("from LabTest").list();
    }
}
