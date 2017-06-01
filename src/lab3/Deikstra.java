package lab3;import java.util.Arrays;

/**
 * Created by Сусанин on 25.05.17.
 */
public class Deikstra {
    private static final int MAXW = 1000*1000*1000;
    private int [][] matrix;
    private int n;

    public Deikstra(int n) {
        this.n = n;
        matrix = new int[n][n];
    }

    public Deikstra(int[][] matrix) {
        this.matrix = matrix;
        n = matrix[0].length;
        play();
    }

    private void play() {
        for (int i = 0; i < n; i++) {
            deikstra_start(i);
        }
        ptint();
    }

    private void ptint() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == MAXW)
                    System.out.println(0);
                else
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void deikstra_start(int i){
        int k;
        boolean []isused = new boolean[n];
        int [] temp = new int[n];
        Arrays.fill(temp,MAXW);
        temp[i] = 0;
        while (true){
            k = -1;
            for (int j = 0; j < n; j++) {
                if(!isused[j] && temp[j]<MAXW && (k==-1 || temp[k]>temp[j]))
                    k = j;
            }
            if(k == -1)
                break;
            isused[k] = true;

            for (int j = 0; j < n; j++) {
                if (!isused[j] && matrix[k][j] < MAXW){
                    temp[j] = Math.min(temp[j],temp[k]+matrix[k][j]);
                }
            }
        }

    }
}
