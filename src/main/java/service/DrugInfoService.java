package service;

import model.DrugCountsDTO;
import model.DrugInfo;
import model.DrugNameCountsDTO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DrugInfoService {
    @Autowired
    private SessionFactory sessionFactory;

    public DrugInfo addDrugInfo(DrugInfo drugInfo) {
        this.sessionFactory.getCurrentSession().save(drugInfo);
        return drugInfo;
    }

    public List<DrugInfo> getDrugInfos(int prescriptionId) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from DrugInfo where prescription_id = :prescriptionId");
        query.setInteger("prescriptionId", prescriptionId);
        return query.list();
    }

    public List<DrugNameCountsDTO> getDrugCounts()
    {
        List<DrugCountsDTO> results = sessionFactory.getCurrentSession().createCriteria(DrugInfo.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("drug"), "drug")
                        .add(Projections.rowCount(), "count"))
                .setResultTransformer(Transformers.aliasToBean(DrugCountsDTO.class))
                .list();

        List<DrugNameCountsDTO> res = new ArrayList<>();
        for (DrugCountsDTO dto : results) {
            res.add(new DrugNameCountsDTO(dto.getDrug().getName(), dto.getCount()));
        }
        return res;
    }
}
