package com.dena.schedule;

import java.util.*;

public class ScheduleBuilder {
    private ExcelParser parser;

    public ScheduleBuilder(ExcelParser parser) {
        this.parser = parser;
    }

    public List<Section> buildScheduleFromCrns(String[] crnInputs) {
        List<Section> result = new ArrayList<>();
        for (String crnStr : crnInputs) {
            try {
                int crn = Integer.parseInt(crnStr.trim());
                Section section = parser.getSectionByCrn(crn);
                if (section != null) {
                    result.add(section);
                } else {
                    System.out.println("CRN not found: " + crn);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid CRN format: " + crnStr);
            }
        }
        return result;
    }
}

