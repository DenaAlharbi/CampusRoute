package com.dena.schedule;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExcelParser parser = new ExcelParser();
        parser.parse("Term Schedule 251 (1).xlsx");

        ScheduleBuilder builder = new ScheduleBuilder(parser);

        System.out.println("Enter CRNs separated by commas:");
        String[] crnInputs = scanner.nextLine().split(",");
        List<Section> selectedSections = builder.buildScheduleFromCrns(crnInputs);
        System.out.print("Enter day (U, M, T, W, R): ");
        String day = scanner.nextLine().trim().toUpperCase();

        System.out.println("\n Classes on " + day + ":");
        for (Section section : selectedSections) {
            for (Slot slot : section.getSlots()) {
                if (slot.getDays().contains(day)) {
                    String courseTitle = section.getCourse().getTitle();
                    String building = slot.getBuilding();
                    String room = slot.getRoom();
                    String start = slot.getStartTime();
                    String end = slot.getEndTime();

                    System.out.printf("- %-40s | %-6s %-6s | %s - %s%n",
                            courseTitle, building, room, start, end);

                }
            }
        }
        /*
         * DistanceCalculator dc = new DistanceCalculator();
         * dc.addBuilding("1245", 100, 200);
         * dc.addBuilding("9205", 300, 400);
         * // Add more buildings as needed
         * 
         * double totalDistance = 0;
         * for (int i = 1; i < daySlots.size(); i++) {
         * String b1 = daySlots.get(i - 1).getBuilding();
         * String b2 = daySlots.get(i).getBuilding();
         * totalDistance += dc.calculateDistance(b1, b2);
         * }
         * 
         * System.out.println("\nTotal distance traveled: " + totalDistance +
         * " meters");
         */
    }
}
