package com.dena.schedule;
import java.util.*;

abstract class Slot {
    protected List<String> days;
    protected String startTime;
    protected String endTime;
    protected String building;
    protected String room;

    public Slot(List<String> days, String startTime, String endTime, String building, String room) {
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.building = building;
        this.room = room;
    }

    public List<String> getDays() { return days; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getBuilding() { return building; }
    public String getRoom() { return room; }
}

// ------------------- LectureSlot -------------------
class LectureSlot extends Slot {
    public LectureSlot(List<String> days, String startTime, String endTime, String building, String room) {
        super(days, startTime, endTime, building, room);
    }
}

// ------------------- LabSlot -------------------
class LabSlot extends Slot {
    private String labEquipment;

    public LabSlot(List<String> days, String startTime, String endTime, String building, String room, String labEquipment) {
        super(days, startTime, endTime, building, room);
        this.labEquipment = labEquipment;
    }

    public String getLabEquipment() { return labEquipment; }
}

// ------------------- CoopSlot -------------------
class CoopSlot extends Slot {
    private String partnerOrganization;

    public CoopSlot(List<String> days, String startTime, String endTime, String building, String room, String partnerOrganization) {
        super(days, startTime, endTime, building, room);
        this.partnerOrganization = partnerOrganization;
    }

    public String getPartnerOrganization() { return partnerOrganization; }
}

// ------------------- InternshipSlot -------------------
class InternshipSlot extends Slot {
    private String company;

    public InternshipSlot(List<String> days, String startTime, String endTime, String building, String room, String company) {
        super(days, startTime, endTime, building, room);
        this.company = company;
    }

    public String getCompany() { return company; }
}