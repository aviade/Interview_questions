package com.samples.paintfill;

import com.samples.core.Matrix;

/**
 * Created by avezra on 7/7/2017.
 */
public interface PaintFiller {
    void fill(Matrix matrix, int rowIndex, int columnIndex, char target, char replacement);
}
