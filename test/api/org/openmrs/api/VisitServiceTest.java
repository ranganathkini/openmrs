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

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.Visit;
import org.openmrs.VisitType;
import org.openmrs.api.context.Context;
import org.openmrs.test.BaseContextSensitiveTest;

public class VisitServiceTest extends BaseContextSensitiveTest {
	
	protected static final String INITIAL_CONCEPTS_XML = "org/openmrs/api/include/ConceptServiceTest-initialConcepts.xml";
	
	@Test
	public void saveVisit_shouldSaveVisit() throws Exception {
		executeDataSet(INITIAL_CONCEPTS_XML);
		Visit visit = new Visit();
		visit.setPerson(Context.getPersonService().getPerson(1));
		visit.setLocation(Context.getLocationService().getLocation(1));
		visit.setDateStarted(new Date());
		visit.setDateStopped(new Date());
		visit.setStartReason(Context.getConceptService().getConcept(1));
		visit.setEndReason(Context.getConceptService().getConcept(2));
		visit.setVisitType(VisitType.IN_PATIENT);
		
		Visit savedVisit = Context.getVisitService().saveVisit(visit);
		Assert.assertNotNull(savedVisit.getVisitId());
		Assert.assertNotNull(savedVisit.getId());
	}
}
