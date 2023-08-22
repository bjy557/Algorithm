import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            list.add(Integer.parseInt(st1.nextToken()));
        }
        
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        
        int[] res = new int[m];
        
        Collections.sort(list);
        for (int i=0; i<m; i++) {
            int j = Integer.parseInt(st2.nextToken());
            if (-1 < Collections.binarySearch(list, j)) {
                res[i] = 1;
            }
        }
        
        for (int i=0; i<m; i++) {
            System.out.println(res[i]);
        }
    }
}
