package dom1;

public class Matrix {
    private int[][] matrix_1;
    private int[][] matrix_2;
    private int n;

    public Matrix(int[][] matrix_1, int[][] matrix_2, int number){
        this.matrix_1 =matrix_1;
        this.matrix_2= matrix_2;
        this.n = n;
    }

    //сложение матриц
    public int[][] sumM() {
        int m = this.matrix_1.length;
        int n = this.matrix_2[0].length;
        int result1[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result1[i][j] += this.matrix_1[i][j] + this.matrix_2[i][j];
            }
        }

        for (int i = 0; i < result1.length; i++) {
            for (int j = 0; j < result1.length; j++) {
                System.out.format("%6d", result1[i][j]);
            }
            System.out.println();
        }
        return result1;

    }

    //Вычитание матриц
    public int[][] subM() {
        int m = this.matrix_1.length;
        int n = this.matrix_2[0].length;
        int result2[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result2[i][j] += this.matrix_1[i][j] - this.matrix_2[i][j];
            }
        }

        for (int i = 0; i < result2.length; i++) {
            for (int j = 0; j < result2.length; j++) {
                System.out.format("%6d", result2[i][j]);
            }
            System.out.println();
        }
        return result2;
    }

    //Произведение матриц
    public int[][] multiplication(){
        int m = this.matrix_1.length;
        int n = this.matrix_2[0].length;
        int k = this.matrix_2.length;
        int result3[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = 0; r < k; r++) {
                    result3[i][j] += this.matrix_1[i][r] * this.matrix_2[r][j];
                }
            }
        }

        for (int i = 0; i < result3.length; i++) {
            for (int j = 0; j < result3[0].length; j++) {
                System.out.format("%6d", result3[i][j]);
            }
            System.out.println();
        }
        return result3;
    }

    //Умножение матрицы на число
    public int[][] multi_number() {
        int num = this.n;
        int m = this.matrix_1.length;
        int n = matrix_1[0].length;
        int result4[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result4[i][j] += this.matrix_1[i][j] * num;
            }
        }

        for (int i = 0; i < result4.length; i++) {
            for (int j = 0; j < result4.length; j++) {
                System.out.format("%6d", result4[i][j]);
            }
            System.out.println();
        }
        return result4;

    }



    //Транспонирование матрицы
    public int[][] transposition() {
        int m = this.matrix_1.length;
        int n = this.matrix_2[0].length;
        int result5[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result5[i][j] = this.matrix_1[j][i];
            }
        }
        for (int i = 0; i < result5.length; i++) {
            for (int j = 0; j < result5.length; j++) {
                System.out.format("%6d", result5[i][j]);
            }
            System.out.println();
        }
        return result5;
    }

    //Возведение матрицы в степень
    public int[][] exponentiation() {
        int m = this.matrix_1.length;
        int n = this.matrix_1[0].length;
        int k = this.matrix_1.length;
        int result6[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int o = 0; o < k; o++) {
                    result6[i][j] += this.matrix_1[i][o] * this.matrix_1[o][j];
                }
            }
        }

        for (int i = 0; i < result6.length; i++) {
            for (int j = 0; j < result6[0].length; j++) {
                System.out.format("%6d", result6[i][j]);
            }
            System.out.println();
        }
        return result6;
    }
}
