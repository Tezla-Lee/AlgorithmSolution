package b2439;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder space;// = new StringBuilder();
        StringBuilder star;// = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n ; i++) {
            space = new StringBuilder();
            star = new StringBuilder();
            for (int j = 1; j <= n - i ; j++) {
                space.append(" ");
            }
            for (int j = 1; j <= i ; j++) {
                star.append('*');
            }
            space.append(star);
            bw.write(space + "\n");
        }
        bw.flush();
        bw.close();
    }
}
