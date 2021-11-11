package AP_Assignment;
import java.util.Scanner;
import java.util.*;



class Matrices{
    Scanner sc=new Scanner(System.in);
    int row;
    int col;
    String name;
    ArrayList<String>matrix_type;
    int mat[][];
    Matrices(int rows,int cols,String Mname,ArrayList<String>mat_type,int matrix[][]){
        row=rows;
        col=cols;
        name=Mname;
        matrix_type=mat_type;
        mat=matrix;
    }
}
class Store {
    ArrayList<Matrices> collection = new ArrayList<Matrices>();

    void Create_matrix(int row, int col, String name, ArrayList<String> matrix_type, int mat[][]) {
        collection.add(new Matrices(row, col, name, matrix_type, mat));
    }

    void Label(int row,int col,ArrayList<String>matrix_type,int mat[][] ){
        if (row == 1 && col != 1) {
            matrix_type.add("Row Matrix");
//            System.out.println("Row Matrix");
        }
        if (col == 1 && row != 1) {
            matrix_type.add("Column Matrix");
//            System.out.println("Column Matrix");
        }
        if (row != col) {
            matrix_type.add("Rectangular Matrix");
//            System.out.println("Rectangular matrix");
        }

        if (row == col) {
            if (row == 1) {
                if (mat[0][0] != 0) {
//                    System.out.println("Singleton matrix");
                    matrix_type.add("Singleton Matrice");
                    matrix_type.add("Square Matrix");
                }
                if (mat[0][0] == 0) {
//                    System.out.println("Null Matrix");
                    matrix_type.add("Null Matrix");
                    matrix_type.add("Square Matrix");
                }
            }
            if (row == 2) {
                if (mat[0][0] == 1 && mat[0][1] == 0 && mat[1][0] == 0 && mat[1][1] == 1) {
//                    System.out.println("Identity matrix");
                    matrix_type.add("Identity Matrix");
                }
                if (mat[0][0] == 1 && mat[0][1] == 1 && mat[1][0] == 1 && mat[1][1] == 1) {
//                    System.out.println("Ones matrix");
                    matrix_type.add("Ones Matrix");
                }
                if (mat[0][0] == 0 && mat[0][1] == 0 && mat[1][0] == 0 && mat[1][1] == 0) {
//                    System.out.println("Null matrix");
                    matrix_type.add("Null Matrix");
                }
                if (mat[0][0] != 0 && mat[0][1] != 0 && mat[1][0] == 0 && mat[1][1] != 0) {
//                    System.out.println("Upper Triangular matrix");
                    matrix_type.add("Upper-Triangular Matrix");
                }
                if (mat[0][0] != 0 && mat[0][1] == 0 && mat[1][0] != 0 && mat[1][1] != 0) {
//                    System.out.println("Lower Triangular matrix");
                    matrix_type.add("Lower-Triangular Matrix");
                }
                if (mat[0][0] != 0 && mat[1][1] != 0 && mat[0][1] == 0 && mat[1][0] == 0) {
                    if (mat[0][0] == mat[1][1]) {
//                        System.out.println("Scalar matrix");
                        matrix_type.add("Scalar Matrix");
                    } else {
//                        System.out.println("Diagonal matrix");
                        matrix_type.add("Diagonal Matrix");
                    }
                }

            }
            if (row == 3) {
                if (mat[0][0] == 1 && mat[0][1] == 0 && mat[0][2] == 0 && mat[1][0] == 0 && mat[1][1] == 1 && mat[1][2] == 0 && mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] == 1) {
                    System.out.println("Identity matrix");
                    matrix_type.add("Identity Matrix");
                }
                if (mat[0][0] == 1 && mat[0][1] == 1 && mat[0][2] == 1 && mat[1][0] == 1 && mat[1][1] == 1 && mat[1][2] == 1 && mat[2][0] == 1 && mat[2][1] == 1 && mat[2][2] == 1) {
                    System.out.println("Ones matrix");
                    matrix_type.add("Ones Matrix");
                }
                if (mat[0][0] == 0 && mat[0][1] == 0 && mat[0][2] == 0 && mat[1][0] == 0 && mat[1][1] == 0 && mat[1][2] == 0 && mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] == 0) {
                    System.out.println("Null matrix");
                    matrix_type.add("Null Matrix");
                }
                if (mat[0][0] != 0 && mat[0][1] != 0 && mat[0][2] != 0 && mat[1][0] == 0 && mat[1][1] != 0 && mat[1][2] != 0 && mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] != 0) {
                    System.out.println("Upper-Triangular matrix");
                    matrix_type.add("Upper-Triangular matrix");
                }
                if (mat[0][0] != 0 && mat[0][1] == 0 && mat[0][2] == 0 && mat[1][0] != 0 && mat[1][1] != 0 && mat[1][2] == 0 && mat[2][0] != 0 && mat[2][1] != 0 && mat[2][2] != 0) {
                    System.out.println("Lower Triangular matrix");
                    matrix_type.add("Lower-Triangular matrix");
                }
                if (mat[0][0] != 0 && mat[0][1] == 0 && mat[0][2] == 0 && mat[1][0] == 0 && mat[1][1] != 0 && mat[1][2] == 0 && mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] != 0) {
                    if (mat[0][0] == mat[1][1] && mat[0][0] == mat[2][2]) {
                        System.out.println("Scalar Matrix");
                        matrix_type.add("Scalar Matrix");
                    } else {
                        System.out.println("Diagonal Matrix");
                        matrix_type.add("Diagonal Matrix");
                    }
                }
            }
            int mat2[][] = new int[mat[0].length][mat.length];
            int flag = 0;
            mat2 = Transpose(mat);
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] != mat2[i][j]) {
                        flag = 1;
                    }
                }
            }
            if (flag == 0) {
                System.out.println("Symmetric Matrix");
                matrix_type.add("Symmetric Matrix");
            }
            int temp = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] != mat2[i][j]) {
                        temp = 1;
                    }
                }
                if (temp == 0) {
                    System.out.println("Skew-Symmetric Matrix");
                    matrix_type.add("Skew-Symmetric Matrix");

                }
            }

//            System.out.println("Square matrix");
            matrix_type.add("Square Matrix");
        }
    }

    void change(int m1[][]){
        Scanner sc=new Scanner(System.in);
        for (int q = 0; q < m1.length; q++) {
            for (int r = 0; r <m1[0].length; r++) {
                m1[q][r] = sc.nextInt();
            }
        }
        System.out.println("You cannot change element of matrix");

    }

    void Display(int row,int col,ArrayList<String>matrix_type,int mat[][]) {
        if (row == 1 && col != 1) {
            System.out.println("Row Matrix");
        }
        if (col == 1 && row != 1) {
            System.out.println("Column Matrix");
        }
        if (row != col) {
            System.out.println("Rectangular Matrix");
        }
        if (row == col) {
            if (row == 1) {
                if (mat[0][0] != 0) {
                    System.out.println("Singleton Matrix");
                    System.out.println("Square Matrix");
                }
                if (mat[0][0] == 0) {
                    System.out.println("Null Matrix");
                    System.out.println("Square Matrix");
                }
            }
            if (row == 2) {
                if (mat[0][0] == 1 && mat[0][1] == 0 && mat[1][0] == 0 && mat[1][1] == 1) {
                    System.out.println("Identity Matrix");
                }
                if (mat[0][0] == 1 && mat[0][1] == 1 && mat[1][0] == 1 && mat[1][1] == 1) {
                    System.out.println("Ones Matrix");
                }
                if (mat[0][0] == 0 && mat[0][1] == 0 && mat[1][0] == 0 && mat[1][1] == 0) {
                    System.out.println("Null Matrix");
                }
                if (mat[0][0] != 0 && mat[0][1] != 0 && mat[1][0] == 0 && mat[1][1] != 0) {
                    System.out.println("Upper-Triangular Matrix");
                }
                if (mat[0][0] != 0 && mat[0][1] == 0 && mat[1][0] != 0 && mat[1][1] != 0) {
                    System.out.println("Lower-Triangular Matrix");
                }
                if (mat[0][0] != 0 && mat[1][1] != 0 && mat[0][1] == 0 && mat[1][0] == 0) {
                    if (mat[0][0] == mat[1][1]) {
                        System.out.println("Scalar Matrix");
                    } else {
                        System.out.println("Diagonal Matrix");
                    }
                }
                System.out.println("Square Matrix");
            }
            if (row == 3) {
                if (mat[0][0] == 1 && mat[0][1] == 0 && mat[0][2] == 0 && mat[1][0] == 0 && mat[1][1] == 1 && mat[1][2] == 0 && mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] == 1) {
                    System.out.println("Identity Matrix");
                }
                if (mat[0][0] == 1 && mat[0][1] == 1 && mat[0][2] == 1 && mat[1][0] == 1 && mat[1][1] == 1 && mat[1][2] == 1 && mat[2][0] == 1 && mat[2][1] == 1 && mat[2][2] == 1) {
                    System.out.println("Ones Matrix");
                }
                if (mat[0][0] == 0 && mat[0][1] == 0 && mat[0][2] == 0 && mat[1][0] == 0 && mat[1][1] == 0 && mat[1][2] == 0 && mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] == 0) {
                    System.out.println("Null Matrix");
                }
                if (mat[0][0] != 0 && mat[0][1] != 0 && mat[0][2] != 0 && mat[1][0] == 0 && mat[1][1] != 0 && mat[1][2] != 0 && mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] != 0) {
                    System.out.println("Upper-Triangular Matrix");
                }
                if (mat[0][0] != 0 && mat[0][1] == 0 && mat[0][2] == 0 && mat[1][0] != 0 && mat[1][1] != 0 && mat[1][2] == 0 && mat[2][0] != 0 && mat[2][1] != 0 && mat[2][2] != 0) {
                    System.out.println("Lower-Triangular Matrix");
                }
                if (mat[0][0] != 0 && mat[0][1] == 0 && mat[0][2] == 0 && mat[1][0] == 0 && mat[1][1] != 0 && mat[1][2] == 0 && mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] != 0) {
                    if (mat[0][0] == mat[1][1] && mat[0][0] == mat[2][2]) {
                        System.out.println("Scalar Matrix");
                    } else {
                        System.out.println("Diagonal Matrix");
                    }
                }
            }
            int mat2[][] = new int[mat[0].length][mat.length];
            int flag = 0;
            mat2 = Transpose(mat);
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] != mat2[i][j]) {
                        flag = 1;
                    }
                }
            }
            if (flag == 0) {
                System.out.println("Symmetric Matrix");
            }
            int temp = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] != -mat2[i][j]) {
                        temp = 1;
                    }
                }
            }
                if (temp == 0) {
                    System.out.println("Skew-Symmetric Matrix");
                }
            }
            System.out.println("Square Matrix");
        }


    void math_operation(int choice, int m1[][], int m2[][]) {
        int m3[][] = null;
        if (choice == 1) {
            if (m1.length == m2.length) {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1[0].length; j++) {
                        m3[i][j] = m1[i][j] + m2[i][j];
                        System.out.print(m3[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        if (choice == 2) {
            if (m1[0].length == m2.length) {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1[0].length; j++) {
                        m3[i][j] = m1[i][j] - m2[i][j];
                        System.out.print(m3[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        if (choice == 3) {
            if (m1[0].length == m2.length) {
                int product[][] = new int[m1.length][m2[0].length];
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m2[0].length; j++) {
                        product[i][j] = 0;
                    }
                }
                for (int s = 0; s < m1.length; s++) {
                    for (int t = 0; t < m2[0].length; t++) {
                        for (int u = 0; u < m1[0].length; u++) {
                            product[s][t] += m1[s][u] * m2[u][t];
                        }
                        System.out.print(product[s][t] + " ");
                    }
                    System.out.println();
                }
            }
        }
        if (choice == 4) {
            if (m1.length == m2.length) {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1[0].length; j++) {
                        m3[i][j] = m1[i][j] / m2[i][j];
                        System.out.print(m3[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        System.out.println("invalid matrices operation cannot be performed");
    }

    void Element_wise(int ch,int m1[][],int m2[][]){

        int m3[][] = null;
        if (ch == 1) {
            if (m1.length == m2.length) {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1[0].length; j++) {
                        m3[i][j] = m1[i][j] + m2[i][j];
                        System.out.print(m3[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        if (ch == 2) {
            if (m1[0].length == m2.length) {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1[0].length; j++) {
                        m3[i][j] = m1[i][j] - m2[i][j];
                        System.out.print(m3[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        if (ch == 3) {
            if (m1.length == m2.length) {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1[0].length; j++) {
                        m3[i][j] = m1[i][j] * m2[i][j];
                        System.out.print(m3[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        if (ch == 4) {
            if (m1.length == m2.length) {
                for (int i = 0; i < m1.length; i++) {
                    for (int j = 0; j < m1[0].length; j++) {
                        m3[i][j] = m1[i][j] / m2[i][j];
                        System.out.print(m3[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        System.out.println("invalid matrices operation cannot be performed");
    }

    int[][] Transpose(int m1[][]) {
//        if(m1.length==m1[0].length){
        int m2[][]=new int[m1[0].length][m1.length];
//        int data;
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
//                data = m1[i][j];
//                m1[i][j] = m1[j][i];
//                m1[j][i] = data;
                m2[i][j]=m1[j][i];
            }
        }
//        return m1;
        return m2;
    }

    void Inverse(int m1[][]) {
        if (m1.length == m1[0].length) {
            if (m1.length == 2) {
                float d;
                int temp;
                d = (m1[0][0] * m1[1][1]) - (m1[0][1] * m1[1][0]);
                if (d == 0) {
                    System.out.println("Inverse cannot be possible");
                } else {
                    temp = m1[0][0];
                    m1[0][0] = m1[1][1];
                    m1[1][1] = temp;
                    m1[0][1] = -m1[0][1];
                    m1[1][0] = -m1[1][0];
                    System.out.println("Inverse");
                    for (int i = 0; i < 2; ++i) {
                        for (int j = 0; j < 2; ++j) {
                            System.out.print((m1[i][j] / d) + " ");
                            System.out.print("\n");
                        }
                    }
                }
            }
            if (m1.length == 3) {
                float d = 0;
                for (int i = 0; i < 3; i++)
                    d = d + (m1[0][i] * (m1[1][(i + 1) % 3] * m1[2][(i + 2) % 3] - m1[1][(i + 2) % 3] * m1[2][(i + 1) % 3]));
                if (d == 0) {
                    System.out.println("Inverse cannot be possible");
                } else {
                    System.out.println("Inverse");
                    for (int i = 0; i < 3; ++i) {
                        for (int j = 0; j < 3; ++j)
                            System.out.print((((m1[(j + 1) % 3][(i + 1) % 3] * m1[(j + 2) % 3][(i + 2) % 3]) - (m1[(j + 1) % 3][(i + 2) % 3] * m1[(j + 2) % 3][(i + 1) % 3])) / d) + " ");
                        System.out.print("\n");
                    }
                }
            }
        }
    }

    float Determinant(int m1[][]) {
        if (m1.length == m1[0].length) {
            float d;
            if (m1.length == 1) {

                d = m1[0][0];
//                System.out.println("Determinant of matrice " + d);
                return d;
            }
            if (m1.length == 2) {
                d = (m1[0][0] * m1[1][1]) - (m1[0][1] * m1[1][0]);
//                System.out.println("Determinant of matrice " + d);
                return d;
            }
            if (m1.length == 3) {
                float det = 0;
                for (int i = 0; i < 3; i++)
                    det = det + (m1[0][i] * (m1[1][(i + 1) % 3] * m1[2][(i + 2) % 3] - m1[1][(i + 2) % 3] * m1[2][(i + 1) % 3]));
//                System.out.println("Determinant of matrice " + det);
                return det;
            }
        } else {
            System.out.println("Determinant of matrice does not exist");
        }
        return 0;
    }
    void Mean(int ch,int m1[][]){

        int sum;
        if(ch==1){
            int number=m1.length;
            System.out.println("Row wise mean is ");
            for(int i=0;i<m1.length;i++){
                sum=0;
                for (int j=0;j<m1[0].length;j++){
                    sum=sum+m1[i][j];
                }System.out.println("Row wise mean of"+(i+1) +"row is "+ sum/number);
                System.out.println();
            }

        }
        if(ch==2){
            int number=m1[0].length;
            System.out.println("Coloumn wise mean is ");
            for(int i=0;i<m1.length;i++){
                sum=0;
                for(int j=0;j<m1[0].length;j++){
                    sum=sum+m1[j][i];

                }System.out.println("COloumn wise mean of"+(i+1)+"Coloumn is "+sum/number);
                System.out.println();
            }
        }
        if(ch==3){
            int number=m1.length*m1[0].length;
            int total=0;
            System.out.println("The mean of all the element is");
            for(int i=0;i<m1.length;i++){
                for(int j=0;j<m1.length;j++){
                    total=total=m1[i][j];
                }
            }
            System.out.println("The mean of all the elemnet is  "+ total/number);
        }
    }





    void singleton_matrix(int choice, int m1[][], int m2[][]) {
        int number = m1[0][0];
        int flag = 0;
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                if (choice == 1) {
                    m2[i][j] = number + m2[i][j];
                    flag = 1;
                }
                if (choice == 2) {
                    m2[i][j] = number * m2[i][j];
                    flag = 1;
                }
                if (choice == 3) {
                    m2[i][j] = m2[i][j] - number;
                    flag = 1;
                }
                if (choice == 4) {
                    if (number != 0) {
                        m2[i][j] = m2[i][j] / number;
                        flag = 1;
                    }
                }
            }
        } if (flag == 0) {
            System.out.println("Not possible");
        }
    }

    void Solve_eq(int n, int main[][], int cof[][]) {
        float d = Determinant(main);
        if (n == 2) {
            int m1[][] = {{cof[0][0], main[0][1]}, {cof[1][0], main[1][1]},};
            int m2[][] = {{main[0][0], cof[0][1]}, {main[1][0], cof[1][0]},};
            float d1 = Determinant(m1);
            float d2 = Determinant(m2);
            if (d != 0) {
                System.out.println("unique solution");
                double x = d1 / d;
                double y = d2 / d;
            }
            if (d1 == 0 && d2 == 0)
                System.out.println("Infinite solutions");
            else if (d1 != 0 || d2 != 0)
                System.out.println("No solutions");
        }

        if (n == 3) {
            int m1[][] = {{cof[0][0], main[0][1], main[0][2]}, {cof[1][0], main[1][1], main[1][2]}, {cof[2][0], main[2][1], main[2][2]},};
            int m2[][] = {{main[0][0], cof[0][0], main[0][2]}, {main[1][0], cof[1][0], main[1][2]}, {main[2][0], cof[2][0], main[2][2]},};
            int m3[][] = {{main[0][0], main[0][1], cof[0][0]}, {main[1][0], main[1][1], cof[1][0]}, {main[2][0], main[2][1], cof[2][0]},};
            float d1 = Determinant(m1);
            float d2 = Determinant(m2);
            float d3 = Determinant(m3);
            if (d != 0) {
                System.out.println("Unique Solution");
                double x = d1 / d;
                double y = d2 / d;
                double z = d3 / d;
                System.out.println("x = "+x+", Y = "+y+", Z= "+z);
            }else{
            if (d1 == 0 && d2 == 0 && d3 == 0)
                System.out.println("Infinite solutions");
            else if (d1 != 0 || d2 != 0 || d3 != 0)
                System.out.println("No solutions");
        }}
    }
}






public class AP_Assignment_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Store s=new Store();
        ArrayList<String>matrix_type=new ArrayList<String>();
        while(true){
            System.out.println("Enter which option you want to perform");
            System.out.println("1. Take matrices as input and label them with appropriate matrix-types.\n");
            System.out.println("2. Create matrices of requested matrix-types and label them with appropriate matrix-types.\n");
            System.out.println("3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.\n");
            System.out.println("4. Display all the matrix-type labels of a requested matrix.\n");
            System.out.println("5. Perform addition, subtraction, multiplication & division.\n");
            System.out.println("6. Perform element-wise operations.\n");
            System.out.println("7. Transpose matrices.\n");
            System.out.println("8. Inverse matrices.\n");
            System.out.println("9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\n");
            System.out.println("10. Compute determinants.\n");
            System.out.println("11. Use singleton matrices as scalars, if requested.\n");
            System.out.println("12. Compute A+AT for a matrix A\n");
            System.out.println("13. Compute Eigen vectors and values.\n");
            System.out.println("14. Solve sets of linear equations using matrices.\n");
            System.out.println("15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.");

            System.out.println("Enter the user choice which you want to perform from the above");
            int Uchoice=sc.nextInt();
            switch(Uchoice){
                case 1:
                    System.out.println("Enter the number of rows of matrices");
                    int row=sc.nextInt();
                    System.out.println("Enter the number of coloumns");
                    int col=sc.nextInt();
                    System.out.println("Enter the name of the matrix");
                    String name=sc.next();
                    if(row<0||col<0||row>3||col>3||row<1||col<1){
                        System.out.println("Invalid matrix");
                    }
                    else {
                        System.out.println("Enter the Elements of matrix");
                        int mat[][] = new int[row][col];
                        for (int q = 0; q < row; q++) {
                            for (int r = 0; r < col; r++) {
                                mat[q][r] = sc.nextInt();
                            }
                        }
                        s.Create_matrix(row, col, name, matrix_type, mat);
                    }
                    break;
                case 2:
                    System.out.println("Enter matrix name to which you want to assign Label");
                    String label=sc.next();
                    int matrixL[][]=null;
                    for(int i=0;i<s.collection.size();i++) {
                        if (s.collection.get(i).name.equals(label))
                            matrixL = s.collection.get(i).mat;
                    }
                    s.Label(matrixL.length,matrixL[0].length,matrix_type,matrixL);
                    break;

                case 3:
                    System.out.println("Enter matrix name to which you want to change the element");
                    String lab=sc.next();
                    int matl[][]=null;
                    for(int i=0;i<s.collection.size();i++) {
                        if (s.collection.get(i).name.equals(lab))
                            matl = s.collection.get(i).mat;
                    }
                    s.change(matl);

                case 4:
                    System.out.println("Enter matrix name to which you want to assign Label");
                    String dis=sc.next();
                    int matrixd[][]=null;
                    for(int i=0;i<s.collection.size();i++) {
                        if (s.collection.get(i).name.equals(dis))
                            matrixd = s.collection.get(i).mat;
                    }
                    s.Display(matrixd.length,matrixd[0].length,matrix_type,matrixd);
                    break;

                case 5:
                    System.out.println("Enter what mathematical operation you want to performfrom the below one");
                    System.out.println("1.Addition");
                    System.out.println("2.Substraction");
                    System.out.println("3.Multiplication");
                    System.out.println("4.Divide");
                    int wish=sc.nextInt();
                    if(wish==1){
                        System.out.println("Enter matrix name of which you want do addition");
                        String mat1=sc.next();
                        String mat2=sc.next();
                        int matrix1[][]=null;
                        int matrix2[][]=null;
                        for(int i=0;i<s.collection.size();i++){
                            if(s.collection.get(i).name.equals(mat1))
                                matrix1=s.collection.get(i).mat;
                            if(s.collection.get(i).name.equals(mat2))
                                matrix2=s.collection.get(i).mat;
                        }
                        s.math_operation(wish,matrix1,matrix2);
                    }
                    if(wish==2){
                        System.out.println("Enter matrix name of which you want do Substraction");
                        String mat1=sc.next();
                        String mat2=sc.next();
                        int matrix1[][]=null;
                        int matrix2[][]=null;
                        for(int i=0;i<s.collection.size();i++){
                            if(s.collection.get(i).name.equals(mat1))
                                matrix1=s.collection.get(i).mat;
                            if(s.collection.get(i).name.equals(mat2))
                                matrix2=s.collection.get(i).mat;

                        }
                        s.math_operation(wish,matrix1,matrix2);

                    }
                    if(wish==3){
                        System.out.println("Enter matrix name of which you want do Multiplication");
                        String mat1=sc.next();
                        String mat2=sc.next();
                        int matrix1[][]=null;
                        int matrix2[][]=null;
                        for(int i=0;i<s.collection.size();i++){
                            if(s.collection.get(i).name.equals(mat1))
                                matrix1=s.collection.get(i).mat;
                            if(s.collection.get(i).name.equals(mat2))
                                matrix2=s.collection.get(i).mat;

                        }
                        s.math_operation(wish,matrix1,matrix2);
                    }
                    if(wish==4){
                        System.out.println("Enter matrix name of which you want do DIVISION");
                        String mat1=sc.next();
                        String mat2=sc.next();
                        int matrix1[][]=null;
                        int matrix2[][]=null;
                        for(int i=0;i<s.collection.size();i++){
                            if(s.collection.get(i).name.equals(mat1))
                                matrix1=s.collection.get(i).mat;
                            if(s.collection.get(i).name.equals(mat2))
                                matrix2=s.collection.get(i).mat;
                        }
                        s.math_operation(wish,matrix1,matrix2);
                    }
                    else{
                        System.out.println("Invalid choice");
                    }break;

                case 6:
                    System.out.println("Perform element wise ");
                    System.out.println("1.Addition");
                    System.out.println("2.Subtraction");
                    System.out.println("3.Multiplication");
                    System.out.println("4.Divide");
                    int dream=sc.nextInt();
                    if(dream==1){
                        System.out.println("Enter matrices name of which you want do element wise addition");
                        String mate1=sc.next();
                        String mate2=sc.next();
                        int matrixe1[][]=null;
                        int matrixe2[][]=null;
                        for(int i=0;i<s.collection.size();i++){
                            if(s.collection.get(i).name.equals(mate1))
                                matrixe1=s.collection.get(i).mat;
                            if(s.collection.get(i).name.equals(mate2))
                                matrixe2=s.collection.get(i).mat;

                        }
                        s.Element_wise(dream,matrixe1,matrixe2);
                    }
                    if(dream==2){
                        System.out.println("Enter matrices name of which you want do element wise Substraction");
                        String mate1=sc.next();
                        String mate2=sc.next();
                        int matrixe1[][]=null;
                        int matrixe2[][]=null;
                        for(int i=0;i<s.collection.size();i++){
                            if(s.collection.get(i).name.equals(mate1))
                                matrixe1=s.collection.get(i).mat;
                            if(s.collection.get(i).name.equals(mate2))
                                matrixe2=s.collection.get(i).mat;
                        }
                        s.Element_wise(dream,matrixe1,matrixe2);

                    }
                    if(dream==3){
                        System.out.println("Enter matrix name of which you want do Multiplication");
                        String mat1=sc.next();
                        String mat2=sc.next();
                        int matrixe1[][]=null;
                        int matrixe2[][]=null;
                        for(int i=0;i<s.collection.size();i++){
                            if(s.collection.get(i).name.equals(mat1))
                                matrixe1=s.collection.get(i).mat;
                            if(s.collection.get(i).name.equals(mat2))
                                matrixe2=s.collection.get(i).mat;

                        }
                        s.Element_wise(dream,matrixe1,matrixe2);
                    }
                    if(dream==4){
                        System.out.println("Enter matrix name of which you want do DIVISION");
                        String mat1=sc.next();
                        String mat2=sc.next();
                        int matrixe1[][]=null;
                        int matrixe2[][]=null;
                        for(int i=0;i<s.collection.size();i++){
                            if(s.collection.get(i).name.equals(mat1))
                                matrixe1=s.collection.get(i).mat;
                            if(s.collection.get(i).name.equals(mat2))
                                matrixe2=s.collection.get(i).mat;
                        }
                        s.Element_wise(dream,matrixe1,matrixe2);
                    }
                    else{
                        System.out.println("Invalid choice");
                    }
                    break;
                case 7:
                    System.out.println("Enter matrix name of which you want do Transpose");
                    String mat1=sc.next();
                    int matrix1[][]=null;

                    for(int i=0;i<s.collection.size();i++){
                        if(s.collection.get(i).name.equals(mat1))
                            matrix1=s.collection.get(i).mat;
                    }
                    int matrix2[][]=new int[matrix1[0].length][matrix1.length];
                    matrix2=s.Transpose(matrix1);
                    for(int i=0;i<matrix2.length;i++){
                        for(int j=0;j<matrix2[0].length;j++){
                            System.out.print(matrix2[i][j]+" ");
                        }
                        System.out.println();
                    }
                    break;

                case 8:
                    System.out.println("Enter matrix name of which you want do Inverse");
                    String matI=sc.next();
                    int matrixI[][]=null;
                    for(int i=0;i<s.collection.size();i++){
                        if(s.collection.get(i).name.equals(matI))
                            matrixI=s.collection.get(i).mat;
                    }
                    s.Inverse(matrixI);
                    break;

                case 9:
                    System.out.println("Enter matrix name of which you want perform element wise operation");
                    String matm=sc.next();
                    System.out.println("enter which you want to find");
                    System.out.println("1.Row wise mean");
                    System.out.println("2. Coloumn wise mean");
                    System.out.println("3. Mean of all element");
                    int ych=sc.nextInt();
                    int matrixm[][]=null;
                    for(int i=0;i<s.collection.size();i++){
                        if(s.collection.get(i).name.equals(matm))
                            matrixm=s.collection.get(i).mat;
                    }
                    s.Mean(ych,matrixm);
                    break;


                case 10:
                    System.out.println("Enter matrix name of which you want do Inverse");
                    String matd=sc.next();
                    int matrixi[][]=null;
                    for(int i=0;i<s.collection.size();i++){
                        if(s.collection.get(i).name.equals(matd))
                            matrixi=s.collection.get(i).mat;
                    }
                    s.Inverse(matrixi);
                    break;

                case 11:
                    System.out.println("Enter matrix name of singular matrix which you use as scalar and then enter the matrice on which you want to perform operation");
                    String single1=sc.next();
                    String single2=sc.next();
                    System.out.println("Enter what mathematical function you want to perform ");
                    System.out.println("1.Addition");
                    System.out.println("2.multiplication");
                    System.out.println("3.Substraction");
                    System.out.println("4.Divide");
                    int w=sc.nextInt() ;
                    int sin_mat1[][]=null;
                    int sin_mat2[][]=null;
                    for(int i=0;i<s.collection.size();i++) {
                        if (s.collection.get(i).name.equals(single1))
                            sin_mat1 = s.collection.get(i).mat;
                        if(s.collection.get(i).name.equals(single2))
                            sin_mat2=s.collection.get(i).mat;
                    }
                    s.singleton_matrix(w,sin_mat1,sin_mat2);
                    break;
                case 12:
                    System.out.println("Enter matrix name of which you want do A+AT(transpose)");
                    String matS=sc.next();
                    int matrix1S[][]=null;
                    int matrix2S[][]=null;
                    for(int i=0;i<s.collection.size();i++) {
                        if (s.collection.get(i).name.equals(matS))
                            matrix1S = s.collection.get(i).mat;
                    }
                    matrix2S=s.Transpose(matrix1S);
                    s.math_operation(1,matrix1S,matrix2S);
                    break;

                case 13:
                    //I will manage it later.
                    break;

                case 14:
                    System.out.println("Linear equation");
                    System.out.println("Enter the number of variables");
                    int var = sc.nextInt();
                    System.out.println("Enter the coefficients variable");
                    System.out.println("Enter in the ->ax + by....=d  format");
                    int[][] mateq = new int[var][var];
                    int[][] C = new int[var][1];
                    for (int i = 0; i < var; i++) {
                        for (int j = 0; j <var; j++) {
                            mateq[i][j] = sc.nextInt();
                        }
                        C[i][0] = sc.nextInt();
                    }
                    s.Solve_eq(var,mateq,C);
                    break;

                case 15:
                    System.out.println("Enter the matrice Type From the below format");
                    System.out.println("1. Rectangular Matrix\n" +
                            "2. Row Matrix\n" +
                            "3. Column Matrix\n" +
                            "4. Square Matrix\n" +
                            "5. Symmetric Matrix\n" +
                            "6. Skew-symmetric Matrix\n" +
                            "7. Upper-triangular Matrix\n" +
                            "8. Lower-triangular Matrix\n" +
                            "9. Singular Matrix\n" +
                            "10. Diagonal Matrix\n" +
                            "11. Scalar Matrix\n" +
                            "12. Identity Matrix\n" +
                            "13. Singleton Matrix\n" +
                            "14. Ones Matrix\n" +
                            "15. Null Matrix");

                    String reqm=sc.next();
                    for(int i=0;i<s.collection.size();i++) {
                        int matrixT[][]=null;
                        if (s.collection.get(i).matrix_type.equals(reqm))
                            matrixT = s.collection.get(i).mat;
                            for(int j=0;j<matrixT.length;j++){
                                for(int k=0;k<matrixT[0].length;k++){
                                    System.out.print(matrixT[i][j]);
                                }
                                System.out.println();
                            }
                    }
                    break;
            }
        }
        }
    }
