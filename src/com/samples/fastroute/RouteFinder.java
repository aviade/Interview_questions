package com.samples.fastroute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avezra on 6/28/2017.
 */
public class RouteFinder {
    public static List<Point> findFastestRoute(int rows, int columns, Point[] blockers){

        ArrayList<List<Point>> routes = new ArrayList<>();
        Point endPoint = new Point(rows-1, columns-1);
        ArrayList<Point> buffer = new ArrayList<>();
        GetRoutesRecursive(routes, 0, 0, buffer, endPoint, blockers);

        if (routes.size() == 0) {
            return null;
        }
        List<Point> faster = routes.get(0);
        for (int i = 1; i < routes.size(); i++) {
            List<Point> route = routes.get(i);
            if (route.size() < faster.size())
            {
                faster = route;
            }
        }
        return faster;
    }

    private static void GetRoutesRecursive(ArrayList<List<Point>> routes, int row, int column, ArrayList<Point> buffer, Point endPoint, Point[] blockers) {
        if (row == endPoint.row && column == endPoint.column)
        {
            buffer.add(new Point(row, column));
            routes.add(buffer);
            return;
        }

        Boolean inRange = isInRange(row, column, endPoint, blockers);
        if (!inRange){
            return;
        }
        ArrayList<Point> newBuffer = new ArrayList<>(buffer);
        newBuffer.add(new Point(row, column));
        GetRoutesRecursive(routes, row+1, column, newBuffer, endPoint, blockers);
        GetRoutesRecursive(routes, row, column+1, newBuffer, endPoint, blockers);
        GetRoutesRecursive(routes, row+1, column+1, newBuffer, endPoint, blockers);
    }

    private static Boolean isInRange(int row, int column, Point endPoint, Point[] blockers) {
        if (row > endPoint.row || column > endPoint.column) {
            return false;
        }

        for (Point p : blockers) {
            if (p.column == column && p.row == row) {
                return false;
            }
        }

        return true;
    }
}
