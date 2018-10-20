import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int recordsCount = Integer.parseInt(bufferedReader.readLine());

        ArrayList<String[]> records = new ArrayList<>();
        for (int i = 0; i < recordsCount; i++) {
            records.add(bufferedReader.readLine().split(" "));
        }

        int maxHuman = 0;
        int temp = 0;
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i)[0].equals("+")) {
                temp++;
                if (temp > maxHuman) {
                    maxHuman = temp;
                }
            } else {
                temp--;
            }
        }

        int here = 0;
        int start = Integer.parseInt(records.get(0)[1]);
        int countTime = 0;
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i)[0].equals("+")){
                here++;
            } else{
                here--;
            }
            if (here == 0){
                countTime += (Integer.parseInt(records.get(i)[1]) - start);
                if (i == records.size() - 1){
                    i = records.size();
                } else{
                    start = Integer.parseInt(records.get(i + 1)[1]);
                }
            }
        }
        System.out.print(maxHuman + " " + countTime);
    }
}
