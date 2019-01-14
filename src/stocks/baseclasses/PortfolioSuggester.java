package stocks.baseclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PortfolioSuggester {
	
	public static void main(String[] args) {
		int investmentCash = 3700;		
		
		//Build Analaysis Engine
		// Accept all the interested Stocks
		//Get the prices
		//Get the trend
		//Also accept the weightage from user if not set to default weight
		
		
		shareInfo TWTR = new shareInfo("TWTR", 1.0f, 30.10f, priority.Interested.getpriority());
		shareInfo MSFT = new shareInfo("MSFT", 8.0f, 102.14f, priority.Interested.getpriority());
		shareInfo CLDR = new shareInfo("CLDR", 1.0f, 11.00f, priority.StronglyInterested.getpriority());
		shareInfo BABA = new shareInfo("BABA", 8.0f, 140.55f, priority.Interested.getpriority());
		shareInfo GPRO = new shareInfo("GPRO", 2.0f, 4.51f, priority.Interested.getpriority());
		shareInfo GE = new shareInfo("GE", 1.0f, 8.55f, priority.Interested.getpriority());
		shareInfo AMZN = new shareInfo("AMZN", 7.0f, 1580.00f, priority.Interested.getpriority());
		shareInfo APPL = new shareInfo("APPL", 14.0f, 148.40f, priority.Interested.getpriority());
		shareInfo TSLA = new shareInfo("TSLA", 10.0f, 318.00f, priority.Interested.getpriority());
		shareInfo NFLX = new shareInfo("NFLX", 10.0f, 299.75f, priority.Interested.getpriority());
		
		
		//Change to hashSet
		List<shareInfo> stocks = new ArrayList<shareInfo>();
		
		stocks.add(TWTR);
		stocks.add(MSFT);
		stocks.add(CLDR);
		/*stocks.add(BABA);
		stocks.add(GPRO);
		stocks.add(GE);
		stocks.add(AMZN);
		stocks.add(APPL);
		stocks.add(TSLA);
		stocks.add(NFLX);*/
		
		Map<shareInfo, Integer> res = investmentSugesster(stocks, investmentCash, diversity.profitDrivenMode);
		
		if(res!=null)
		{
			Iterator it = res.entrySet().iterator();
			while(it.hasNext())
			{
				Map.Entry pair = (Entry) it.next();
				shareInfo si = (shareInfo) pair.getKey();
				System.out.println(si.getShareCode() + "->" + pair.getValue());
			}
		}
	}
	
	public static Map<shareInfo, Integer> investmentSugesster(List<shareInfo> stocks, int investmentCash, diversity diversity)
	{
		Map<shareInfo, Integer> res = new HashMap<shareInfo, Integer>();
		
		
		//Completely remove the negative and zero trend shares
		
		//List<shareInfo> collSort = Collections.sort(stocks);
		
		Collections.sort(stocks, Collections.reverseOrder());
		
		//Sort the stocks with the descending trend		
		//List<shareInfo> sortedStocksPerTrend = SortStocksPerTrend(stocks);
		
		//When most of the shares in the same trend sort based on the user priority
		
		//List<shareInfo> sortedStocksPerPriority = SortStocksPerTrend(stocks);
		
		Map<diversity, Map<shareInfo, Integer>> resultSetForAllDiversities = findOrderForAllDiversities(stocks, investmentCash);
	
		//adhoc
		printProfitForAllShares(resultSetForAllDiversities);
		
		return resultSetForAllDiversities == null ? null : resultSetForAllDiversities.get(diversity.getdiversity());
	}
	
	private static void printProfitForAllShares(Map<diversity, Map<shareInfo, Integer>> resultSetForAllDiversities) {
		
		if(resultSetForAllDiversities == null)
			return;
		
		Iterator it = resultSetForAllDiversities.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Entry) it.next();
			diversity div = (diversity) pair.getKey();
			float buyingVal = calculateProfit((Map<shareInfo, Integer>) pair.getValue());
			System.out.println("******************************************************************");
			System.out.println("**********     " + div + "->" + buyingVal + "  *******************");
			System.out.println("******************************************************************");
		}
	}
	
	
	private static float calculateProfit(Map<shareInfo, Integer> portfolio) {
		float buyingVal=0f;
		
		if(portfolio == null)
			return buyingVal;
		
		Iterator it = portfolio.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Entry) it.next();
			shareInfo share = (shareInfo) pair.getKey();
			int count = (int) pair.getValue();
			buyingVal+=share.price*count;
			System.out.println("Buying  "+ count + share.shareCode + " shares at " + share.price + " total of " + share.price*count);
		}
		
		return buyingVal;
	}

	private static Map<diversity, Map<shareInfo, Integer>> findOrderForAllDiversities(List<shareInfo> sortedStocksPerPriority, int amount) {
		
		if(sortedStocksPerPriority ==null || amount == 0)
			return null;
		
		Map<shareInfo, Integer> profitMode = purchaseOrderInProfitMode(sortedStocksPerPriority, amount);
		
		Map<shareInfo, Integer> diverseMode = purchaseOrderInDiverseMode(sortedStocksPerPriority, amount);
		
		Map<shareInfo, Integer> mixedMode = purchaseOrderInMixedMode(sortedStocksPerPriority, amount);
		
		Map<diversity, Map<shareInfo, Integer>> purchaseOrders = new HashMap<diversity, Map<shareInfo,Integer>>();
		
		purchaseOrders.put(diversity.profitDrivenMode, profitMode);
		
		purchaseOrders.put(diversity.diversedMode, diverseMode);
		
		purchaseOrders.put(diversity.mixedMode, mixedMode);
		
		
		return purchaseOrders;
	}

	private static Map<shareInfo, Integer> purchaseOrderInMixedMode(
			List<shareInfo> sortedStocksPerPriority, int amount) {

		
		if(sortedStocksPerPriority ==null || amount == 0)
			return null;
		
		return null;
	}

	private static Map<shareInfo, Integer> purchaseOrderInDiverseMode(
			List<shareInfo> sortedStocksPerPriority, int amount) {
		if(sortedStocksPerPriority ==null || amount == 0)
			return null;
		
		return null;
	}

	private static Map<shareInfo, Integer> purchaseOrderInProfitMode(
			List<shareInfo> sortedStocksPerPriority, int amount) {
		
		if(sortedStocksPerPriority ==null || amount == 0)
			return null;
		
		
		
		
		return null;
	}
	
	
	/*private static List<shareInfo> SortStocksPerTrend(List<shareInfo> stocks) {
		if(stocks == null)
			return null;
		
		//Map<Float, shareInfo>
		
		return null;
	}*/
}
