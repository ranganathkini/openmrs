package org.openmrs.api;

import org.openmrs.Visit;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zabilcm
 * Date: Jun 18, 2010
 * Time: 12:08:20 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VisitService extends OpenmrsService {
    public List<Visit> getAllVisits();

    public Visit saveVisit(Visit visit);
}
