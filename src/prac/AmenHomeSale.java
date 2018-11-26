package prac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AmenHomeSale {

	public static void main(String[] fileNames) {

		long startTime = System.nanoTime();

		ProcessFile(fileNames[0]);
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println("Time Taken: " + elapsedTime);
	}

	private static void ProcessFile(String fileName) {
		File file = new File(fileName);

		if (!file.exists()) {
			return;
		} else {
			BufferedReader br = null;
			try {
				// Open the file
				FileInputStream fstream = new FileInputStream(file);
				br = new BufferedReader(new InputStreamReader(fstream));

				String strLine;
				int K = 0, N = 0;
				int line_count = 0;
				String[] price = null;
				List<Integer> window;
				// Read File Line By Line
				while ((strLine = br.readLine()) != null) {
					// Print the content on the console
					System.out.println(strLine);
					if (line_count == 0) {
						String[] temp = strLine.split(" ");
						N = Integer.parseInt(temp[0]);
						K = Integer.parseInt(temp[1]);
					} else {
						price = strLine.split(" ");
					}
					line_count++;
				}
				for (int i = 0; i < N - K+1; i++) {
					int index = 0;
					window = new ArrayList<Integer>();
					for (int j = i; index < 3; index++, j++) {
						window.add(Integer.parseInt(price[j]));
					}
					// System.out.println(FindPatterns(K, window));
					System.out.println(FindPatterns(K, window));

				}
				/* FindPatterns(K, N, price); */
			} catch (Exception e) {
				System.out.println("Exception occurred while reading the file "
						+ fileName);
			}

			finally {
				if (br != null) {
					// Close the input stream
					try {
						br.close();
					} catch (IOException e) {
						System.out.println("Exception while closing the file");
					}
				}

			}

		}

	}

	private static int FindPatterns(int n, List<Integer> price) {
		//int size = price.size();
		int max_possible_val = ((n-1)*n)/2;
		int count=0,index=0;
		boolean isBadData=false;
		int k;
		boolean allAreIncreasingOrder =false;
		for (int size = n; size >1; size--) {
			for(int j=0;j+size<=n;j++)
			{
				isBadData=false;
				for(k=j;k<j+size-1;k++)
				{
					if(price.get(k)>price.get(k+1))
					{
						isBadData=true;
						k++;
						break;
					}
				}
				
				if(k==j+size-1)
				{
					if(isBadData)
						count--;
					else
						count++;
				}
				/*else if()
				{
					count--;
				}*/
			}
			if(index==0 && count>0)
			{
				allAreIncreasingOrder=true;
				break;
			}
			index++;
		}
		if(allAreIncreasingOrder)
			return max_possible_val;
		return count;
	}

}