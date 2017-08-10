public class maxShapeXMatrix {
    // O(5 * N * M) and the coefficient can be dropped
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1}
        };
        int[][] topLeft = getDPMatrix(matrix, -1, -1, 0);
        int[][] topRight = getDPMatrix(matrix, -1, 1, 1);
        int[][] bottomLeft = getDPMatrix(matrix, 1, -1, 2);
        int[][] bottomRight = getDPMatrix(matrix, 1, 1, 3);
        displayMatrix(topLeft);
        displayMatrix(topRight);
        displayMatrix(bottomLeft);
        displayMatrix(bottomRight);
        int bestResult = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                bestResult = Math.max(bestResult, Math.min(topLeft[i][j], Math.min(topRight[i][j], Math.min(bottomLeft[i][j], bottomRight[i][j]))));
            }
        }
        System.out.println("Best X size = " + bestResult);
    }

    static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] getDPMatrix(int[][] matrix, int dx, int dy, int mode) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = matrix[i].clone();
        }
        if (mode == 0) { // topLeft
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        int newI = i + dx;
                        int newJ = j + dy;
                        if (valid(newI, newJ, matrix.length, matrix[0].length)) {
                            newMatrix[i][j] += newMatrix[newI][newJ];
                        }
                    }
                }
            }
        } else if (mode == 1) { // topRight
            for (int i = 0; i < matrix.length; i++) {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    if (matrix[i][j] != 0) {
                        int newI = i + dx;
                        int newJ = j + dy;
                        if (valid(newI, newJ, matrix.length, matrix[0].length)) {
                            newMatrix[i][j] += newMatrix[newI][newJ];
                        }
                    }
                }
            }
        } else if (mode == 2) { // bottomLeft
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        int newI = i + dx;
                        int newJ = j + dy;
                        if (valid(newI, newJ, matrix.length, matrix[0].length)) {
                            newMatrix[i][j] += newMatrix[newI][newJ];
                        }
                    }
                }
            }
        } else { // bottomRight
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    if (matrix[i][j] != 0) {
                        int newI = i + dx;
                        int newJ = j + dy;
                        if (valid(newI, newJ, matrix.length, matrix[0].length)) {
                            newMatrix[i][j] += newMatrix[newI][newJ];
                        }
                    }
                }
            }
        }
        return newMatrix;
    }

    private static boolean valid(int i, int j, int maxI, int maxJ) {
        return i >= 0 && i < maxI && j >= 0 && j < maxJ;
    }
}
