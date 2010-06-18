package org.openmrs.api.impl;

import org.openmrs.Visit;
import org.openmrs.api.VisitService;
import org.openmrs.api.db.hibernate.VisitDAO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zabilcm
 * Date: Jun 18, 2010
 * Time: 3:18:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class VisitServiceImpl extends BaseOpenmrsService implements VisitService {
    private VisitDAO visitDAO;
    
    public List<Visit> getAllVisits() {
        return null;  
    }

    public Visit saveVisit(Visit visit) {
        return getVisitDAO().saveVisit(visit);
    }

    public VisitDAO getVisitDAO() {
        return visitDAO;
    }

    public void setVisitDAO(VisitDAO visitDAO) {
        this.visitDAO = visitDAO;
    }
}
