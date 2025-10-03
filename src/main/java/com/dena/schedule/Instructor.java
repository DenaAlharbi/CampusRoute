package com.dena.schedule;
import java.util.*;

class Instructor {
    private String name;
    private List<Section> sections = new ArrayList<>();

    public Instructor(String name) {
        this.name = name;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public List<Section> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public String getName() { return name; }
}
