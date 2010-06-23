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
package org.openmrs.api;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.Visit;
import org.openmrs.VisitType;
import org.openmrs.api.context.Context;
import org.openmrs.test.BaseContextSensitiveTest;
import org.openmrs.test.Verifies;

public class VisitServiceTest extends BaseContextSensitiveTest {
	
	protected static final String INITIAL_CONCEPTS_XML = "org/openmrs/api/include/ConceptServiceTest-initialConcepts.xml";
	
	@Test
	public void saveVisit_shouldSaveVisit() throws Exception {
		executeDataSet(INITIAL_CONCEPTS_XML);
		Visit visit = createVisit();
		
		Visit savedVisit = Context.getVisitService().saveVisit(visit);
		Assert.assertNotNull(savedVisit.getVisitId());
		Assert.assertNotNull(savedVisit.getId());
	}
	
	/**
	 * Method to create a visit
	 * 
	 * @return
	 */
	private Visit createVisit() {
		Visit visit = new Visit();
		visit.setPerson(Context.getPersonService().getPerson(1));
		visit.setLocation(Context.getLocationService().getLocation(1));
		visit.setDateStarted(new Date());
		visit.setDateStopped(new Date());
		visit.setStartReason(Context.getConceptService().getConcept(1));
		visit.setEndReason(Context.getConceptService().getConcept(2));
		visit.setVisitType(VisitType.IN_PATIENT);
		return visit;
	}
	
	/**
	 * @see {@link VisitService#getAllVisits()}
	 */
	@Test
	@Verifies(value = "should get all visits", method = "getAllVisits()")
	public void getAllVisits_shouldGetAllVisits() throws Exception {
		executeDataSet(INITIAL_CONCEPTS_XML);
		Context.getVisitService().saveVisit(createVisit());
		Context.getVisitService().saveVisit(createVisit());
		List<Visit> visits = Context.getVisitService().getAllVisits();
		Assert.assertEquals(2, visits.size());
	}
}
