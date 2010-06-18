package org.openmrs.api.db.hibernate;

import org.hibernate.SessionFactory;
import org.openmrs.Visit;
import org.openmrs.api.db.DAOException;

/**
 * Created by IntelliJ IDEA.
 * User: zabilcm
 * Date: Jun 18, 2010
 * Time: 3:40:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateVisitDAO implements VisitDAO {
    private SessionFactory sessionFactory;

    /**
     * Sets the session factory
     *
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Visit saveVisit(Visit visit) throws DAOException {
        sessionFactory.getCurrentSession().saveOrUpdate(visit);
        return visit;
    }
}
