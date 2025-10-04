package com.dena.schedule;

import java.util.List;

public class Slot {
    private List<String> days;
    private String startTime;
    private String endTime;
    private String building;
    private String room;
    private String activityType; // e.g., "LEC", "LAB", "COOP", etc.

    public Slot(List<String> days, String startTime, String endTime,
                String building, String room, String activityType) {
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.building = building;
        this.room = room;
        this.activityType = activityType;
    }

    public List<String> getDays() {
        return days;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoom() {
        return room;
    }

    public String getActivityType() {
        return activityType;
    }

    @Override
    public String toString() {
        return activityType + " | " + building + " " + room +
               " | " + startTime + " - " + endTime + " | Days: " + days;
    }
}

/* 
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
}*/