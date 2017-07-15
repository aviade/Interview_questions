package com.samples.core;

/**
 * Created by avezra on 6/29/2017.
 */
public class Matrix {
    private char[][] matrix;
    int rows, columns;

    public Matrix(char[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        columns = matrix.length == 0 ? 0 : matrix[0].length;
    }

    public Character get(int row, int column) {

        return matrix[row][column];
    }

    public void set(int row, int column, char c) {
        matrix[row][column] = c;
    }

    public Boolean isInRange(int row, int column) {
        return row >= 0 &&
                column >=0 &&
                row < rows &&
                column < columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
