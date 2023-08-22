import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int score = Integer.parseInt(br.readLine());
        if (90 <= score && score < 101) {
            bw.write("A");
        }
        else if (80 <= score && score < 90) {
            bw.write("B");
        }
        else if (70 <= score && score < 80) {
            bw.write("C");
        }
        else if (60 <= score && score < 70) {
            bw.write("D");
        }
        else {
            bw.write("F");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
