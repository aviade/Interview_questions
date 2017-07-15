package com.samples.paintfill;

import com.samples.core.Matrix;

/**
 * Created by avezra on 7/7/2017.
 */
public class PaintFillerTool {
    public static Boolean[][] createdVisitedMatrix(Matrix matrix) {
        Boolean[][] visited = new Boolean[matrix.getRows()][];
        for (int i = 0; i < visited.length; i++) {
            final Boolean[] booleans = new Boolean[matrix.getColumns()];
            for (int j = 0; j < booleans.length; j++) {
                booleans[j] = false;
            }
            visited[i] = booleans;
        }
        return visited;
    }

}
