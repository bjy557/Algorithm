import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        
        for (String s : str) {
            if (input.contains(s)) {
                input = input.replace(s, "!");
            }
        }
        
        System.out.println(input.length());
    }
}
