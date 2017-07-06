package com.samples.matrixofwords;

import java.util.List;

/**
 * Created by avezra on 7/4/2017.
 */
public interface WordsFinder {
    List<String> findWordsInMatrix(Matrix matrix, String[] lookupList);
}
