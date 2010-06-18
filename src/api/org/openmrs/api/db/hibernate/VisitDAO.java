package org.openmrs.api.db.hibernate;

import org.openmrs.Visit;
import org.openmrs.api.db.DAOException;

/**
 * Created by IntelliJ IDEA.
 * User: zabilcm
 * Date: Jun 18, 2010
 * Time: 3:22:56 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VisitDAO {
    Visit saveVisit(Visit visit) throws DAOException;
}
