package dom1;

public class Main {
    public static void main(String[] args) {
        int[][] matrix_1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix_2 = {{10, 11, 12}, {13, 14, 15}, {3, 2, 8}};
        int n = 3;
        Matrix matrix = new Matrix(matrix_1, matrix_2, n);
        System.out.println("\nСложение матриц: ");
        matrix.sumM();
        System.out.println("\nВычитание матриц: ");
        matrix.subM();
        System.out.println("\nПроизведение матриц:");
        matrix.multiplication();
        System.out.println("\nУмножение матрицы на число: ");
        matrix.multi_number();
        System.out.println("\nТранспонирование матрицы: ");
        matrix.transposition();
        System.out.println("\nВозведение матрицы в степень: ");
        matrix.exponentiation();


        Vector vector = new Vector(1, 2, 3);
        Vector vector_2 = new Vector(4, 5, 6);
        System.out.println("Длина вектора: ");
        System.out.println(vector.length_vector());
        System.out.println("Скалярное произведение: ");
        System.out.println(vector.scalar_vector(vector_2));
        System.out.println("Векторное произведение с другим вектором: ");
        vector.mult(vector_2).value();
        System.out.println("Угол между векторами: ");
        System.out.println(vector.cosin(vector_2));
        System.out.println("Сумма: ");
        vector.summa(vector_2).value();
        System.out.println("Разность: ");
        vector.difference(vector_2).value();
        Vector[] vectors = Vector.generator(10);


    }


}
