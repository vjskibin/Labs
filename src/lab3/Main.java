package lab3; /**
 * Created by Сусанин on 25.05.17.
 */
public class Main {
 public static void main(String[] args) {
  int[][] array = new int[6][6];
  array[0][1] = 1;
  array[0][2] = 2;
  array[1][0] = 3;
  array[1][2] = 4;
  array[1][3] = 5;
  array[2][0] = 6;
  array[2][1] = 7;
  array[2][4] = 8;
  array[3][1] = 9;
  array[3][4] = 10;
  array[3][5] = 11;
  array[4][2] = 12;
  array[4][3] = 13;
  array[5][3] = 14;

  Deikstra deikstra = new Deikstra(array);
 }


}
