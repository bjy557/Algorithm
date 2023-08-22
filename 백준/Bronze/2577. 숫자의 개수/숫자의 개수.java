import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = a * b * c;
        String r = String.valueOf(d);

        int[] arr = new int[10];
        for (int i=0; i<r.length(); i++) {
            arr[Character.getNumericValue(r.charAt(i))]++;
        }
        
        for (int i=0; i<10; i++) {
            System.out.println(arr[i]);
        }
    }
}
