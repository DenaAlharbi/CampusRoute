package com.dena.schedule;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.*;

public class ExcelParser {
    private Map<String, Department> departments = new HashMap<>();
    private Map<String, Instructor> instructors = new HashMap<>();
    private Map<Integer, Section> crnMap = new HashMap<>();

    // Parses day codes like "UT" → ["U", "T"]
    private List<String> parseDays(String raw) {
        List<String> result = new ArrayList<>();
        if (raw == null || raw.trim().isEmpty())
            return result;

        raw = raw.trim().toUpperCase();
        for (char c : raw.toCharArray()) {
            String dayCode = String.valueOf(c);
            if (List.of("U", "M", "T", "W", "R").contains(dayCode)) {
                result.add(dayCode);
            }
        }
        return result;
    }

    public void parse(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0)
                    continue; // Skip header

                try {
                    String crnStr = getCell(row, 1);
                    if (crnStr.isEmpty() || !crnStr.matches("\\d+"))
                        continue;
                    int crn = Integer.parseInt(crnStr);

                    String term = getCell(row, 0);
                    String courseCode = getCell(row, 2);
                    String deptCode = getCell(row, 3);
                    String sectionNum = getCell(row, 4);
                    String title = getCell(row, 5);
                    String activity = getCell(row, 6).replaceAll("[^A-Z]", "").trim();
                    String daysColl = getCell(row, 7);
                    String startTime = getCell(row, 8);
                    String endTime = getCell(row, 9);
                    String building = getCell(row, 10);
                    String room = getCell(row, 11);
                    String instructorName = getCell(row, 12);
                    System.out.println("Raw days string for CRN " + crn + ": '" + daysColl + "'");

                    List<String> days = parseDays(daysColl);

                    Department dept = departments.computeIfAbsent(deptCode, d -> new Department(d, d));
                    Course course = new Course(courseCode, title, dept);
                    Instructor instructor = instructors.computeIfAbsent(instructorName, Instructor::new);
                    Section section = new Section(crn, term, sectionNum, course, instructor);

                    Slot slot;
                    if (!startTime.isEmpty() && !endTime.isEmpty()) {
                        slot = new Slot(days, startTime, endTime, building, room, activity);
                    } else {

                        slot = new Slot(days, "UNSCHEDULED", "UNSCHEDULED", building, room, activity);
                        // System.out.println("Unscheduled slot for CRN " + crn + ": " + activity);
                    }
                    System.out.println("Parsed days for CRN " + crn + ": " + days);

                    section.addSlot(slot);
                    crnMap.put(crn, section);

                } catch (Exception e) {
                    System.out.println("Skipping row " + row.getRowNum() + ": " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
        }
    }

    public Section getSectionByCrn(int crn) {
        return crnMap.get(crn);
    }

    private String getCell(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell == null)
            return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue()).trim(); // force integer
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue()).trim();
            case FORMULA:
                return cell.getCellFormula().trim();
            default:
                return cell.toString().trim();
        }
    }

}
