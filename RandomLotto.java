import java.io.*;

public class RandomLotto {
  public static void main(String args[]) throws IOException {
    System.out.println("樂透電腦選號──Java 版");
    System.out.print("您要產生幾組號碼：");
    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int i = Integer.parseInt(str);
    for(int j=1;j<=i;j++) {     //產生指定組數號碼的迴圈
      int[] lotto= new int[49]; // 建立樂透號碼陣列
      for (int k=0;k<49;k++)    // 將陣列元素值設為 1～49
        lotto[k]=k+1;
      int count=0;          // 用來記錄已產生幾個號碼
      do {
        int guess = (int)(Math.random()*49);
        if(lotto[guess]==0) // 若號碼所指的元素值為 0, 表示此數字已
          continue;         // 出現過, 就重新執行迴圈, 產生另一亂數
        else {
          System.out.print(lotto[guess]+"\t");
          lotto[guess]=0;   // 將號碼所指的元素值設為 0, 以免重複用到
          count++;
        }
      } while (count<6);        // 產生 6 個號碼才停止
      System.out.print('\n');   // 每產生一組號碼就換行
    }
    System.out.println("未滿十八歲不得購買及兌換彩券！");
  }
}
