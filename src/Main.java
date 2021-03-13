import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	private static int[] prices;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String receive = br.readLine();
		while(receive != null){
			int books = Integer.parseInt(receive);
			prices = new int[books];
			String[] arrayB = br.readLine().split(" ");
			int maxPrice = Integer.parseInt(br.readLine());
			int min = 0;
			int max = maxPrice;
			
			for(int i = 0; i<books; i++) {
				prices[i] = Integer.parseInt(arrayB[i]);
			}
			Arrays.sort(prices);
			for(int i = 0; i<books; i++) {
				boolean founded = false;
				int start = 0;
				int end = prices.length-1;
				while(start <= end && !founded) {
					int mid = (start+end)/2;
					if(mid != i && prices[mid]+prices[i] == maxPrice && prices[mid]-prices[i]<max-min && prices[mid]-prices[i]>=0) {
						min = prices[i];
						max = prices[mid];
						founded = true;
					}else if(prices[mid]+prices[i] > maxPrice) {
						end = mid-1;
					}else start = mid+1;
				}
			}
			bw.write("Peter should buy books whose prices are "+min+" and "+max+".\n\n");
			bw.flush();
			br.readLine();
			receive = br.readLine();
		}
		br.close();
		bw.close();
	}
}
