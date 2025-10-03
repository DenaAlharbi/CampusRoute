package com.dena.schedule;
import java.util.*;

class Section {
    private int crn;
    private String term;
    private String sectionNumber;
    private Course course;
    private Instructor instructor;
    private List<Slot> slots = new ArrayList<>();

    public Section(int crn, String term, String sectionNumber, Course course, Instructor instructor) {
        this.crn = crn;
        this.term = term;
        this.sectionNumber = sectionNumber;
        this.course = course;
        this.instructor = instructor;
        course.addSection(this);
        instructor.addSection(this);
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public List<Slot> getSlots() {
        return Collections.unmodifiableList(slots);
    }
}

// ------------------- Abstract Slot -------------------
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