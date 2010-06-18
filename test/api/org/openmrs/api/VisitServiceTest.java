package org.openmrs.api;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.Visit;
import org.openmrs.VisitType;
import org.openmrs.api.context.Context;
import org.openmrs.test.BaseContextSensitiveTest;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: zabilcm
 * Date: Jun 18, 2010
 * Time: 12:02:52 PM
 * To change this template use File | Settings | File Templates.
 */
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
