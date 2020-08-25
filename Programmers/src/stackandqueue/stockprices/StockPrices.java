package stackandqueue.stockprices;

public class StockPrices {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j < prices.length - i; j++) {
                if (prices[i] <= prices[i + j]) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            answer[i] = count;
            count = 0;
        }
        return answer;
    }
}

class StockPricesTest {
    public static void main(String[] args) {
        StockPrices stock = new StockPrices();
        int[] prices = {1, 2, 3, 2, 3};
        int[] arr = stock.solution(prices);
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%3d ", prices[i]);
        }
        System.out.println();
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%3d ", arr[i]);
        }
    }
}