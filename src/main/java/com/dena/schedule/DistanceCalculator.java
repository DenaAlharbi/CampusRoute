package com.dena.schedule;
import java.util.*;

class DistanceCalculator {
    private Map<String, double[]> buildingCoordinates = new HashMap<>();

    public void addBuilding(String code, double x, double y) {
        buildingCoordinates.put(code, new double[]{x, y});
    }

    public double calculateDistance(String buildingA, String buildingB) {
        double[] a = buildingCoordinates.get(buildingA);
        double[] b = buildingCoordinates.get(buildingB);

        if (a == null || b == null) {
            throw new IllegalArgumentException("Building not found in map.");
        }

        double dx = a[0] - b[0];
        double dy = a[1] - b[1];
        return Math.sqrt(dx*dx + dy*dy);
    }
}