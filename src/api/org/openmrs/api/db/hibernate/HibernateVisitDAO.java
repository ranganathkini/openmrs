/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.api.db.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.openmrs.Visit;
import org.openmrs.api.db.DAOException;

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

	/**
	 * @see org.openmrs.api.db.hibernate.VisitDAO#getAllVisits()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> getAllVisits() {
		return sessionFactory.getCurrentSession().createQuery("from Visit visit").list();
	}
}
