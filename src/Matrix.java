/*
        Directed or undirected: Write a program that takes a matrix of size nxn as input
        and determines whether that matrix is the representation of the directed graph.
 */

public class Matrix {

    public boolean representation(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != matrix[i][j]){
                    System.out.println("Matrix represent a directed graph");
                    return true;
                }
            }
        }
        System.out.println("Matrix does not represent a directed graph");
        return false;
    }
}
