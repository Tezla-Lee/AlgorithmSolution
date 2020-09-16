package b10871;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
        String [] line1 = br.readLine().split(" ");
        String [] line2 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int x = Integer.parseInt(line1[1]);
//
//        for (int i = 0; i < n; i++) {
//            if (Integer.parseInt(line2[i]) < x) {
//                bw.write(Integer.parseInt(line2[i]) + " ");
//            }
//        }
//        bw.flush();
//        bw.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(line2[i]) < x) {
                sb.append(Integer.parseInt(line2[i])).append(" ");
            }
        }
        System.out.println(sb);
    }
}