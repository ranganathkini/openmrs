package org.openmrs;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: zabilcm
 * Date: Jun 18, 2010
 * Time: 12:14:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Visit extends BaseOpenmrsData implements Auditable {
    private Location location;
    private String uuid;
    private Date dateStarted;
    private Date dateStopped;
    private Concept startReason;
    private Concept endReason;
    private VisitType visitType;
    private Integer visitId;
    private Person person;

    public Integer getId() {
        return getVisitId();
    }

    public void setId(Integer id) {
        setVisitId(id);
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public void setDateStopped(Date dateStopped) {
        this.dateStopped = dateStopped;
    }

    public void setStartReason(Concept startReason) {
        this.startReason = startReason;
    }

    public void setEndReason(Concept endReason) {
        this.endReason = endReason;
    }

    public void setVisitType(VisitType visitType) {
        this.visitType = visitType;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public Date getDateStopped() {
        return dateStopped;
    }

    public Concept getStartReason() {
        return startReason;
    }

    public Concept getEndReason() {
        return endReason;
    }

    public VisitType getVisitType() {
        return visitType;
    }

    public Person getPerson() {
        return person;
    }

    public Location getLocation() {
        return location;
    }
}