package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import model.Drug;
import model.Prescription;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PrescriptionService {
    @Autowired
    private SessionFactory sessionFactory;

    public PrescriptionService() {
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addPrescription(Prescription prescription) {
        this.sessionFactory.getCurrentSession().save(prescription);
        return prescription.getId();
    }

    public List<Prescription> getAllPrescriptions() {
        return this.sessionFactory.getCurrentSession().createQuery("from Prescription").list();
    }

    public Prescription getPrescription(int id) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from Prescription where id:id");
        query.setInteger("id", id);
        return (Prescription)query.uniqueResult();
    }

//    public Map<Drug, Integer> getDrugCounts() {
//        Map<Drug, Integer> map = new HashMap();
//
//        Prescription prescription;
//        for(Iterator var2 = this.getAllPrescriptions().iterator(); var2.hasNext(); map.put(prescription.getDrug(), (Integer)map.get(prescription.getDrug()) + 1)) {
//            prescription = (Prescription)var2.next();
//            if (!map.containsKey(prescription.getDrug())) {
//                map.put(prescription.getDrug(), 0);
//            }
//        }
//
//        return map;
//    }
}
