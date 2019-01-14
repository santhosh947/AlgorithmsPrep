package stocks.baseclasses;

public class shareInfo implements Comparable {
	public String shareCode;
	public float trend;
	public int weight = 0;
	public float price;	

	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	/*public int getNumOfStocks() {
		return numOfStocks;
	}

	public void setNumOfStocks(int numOfStocks) {
		this.numOfStocks = numOfStocks;
	}*/

	public String getShareCode() {
		return shareCode;
	}

	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}

	public float getTrend() {
		return (Float)trend;
	}

	public void setTrend(float trend) {
		this.trend = trend;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}


	public shareInfo(String shareCode, float trend, float price, int weight) {
		this.shareCode = shareCode;
		this.trend = trend;
		this.price = price;
		this.weight = weight;
	}
	
	 /*@Override
	 public int compareTo(Object o) {
	    return Float.compare(this.getTrend(), ((shareInfo) o).getTrend());
	 }*/
	 
	 @Override
	 public int compareTo(Object o) {
	    int c = Float.compare(this.getTrend(), ((shareInfo) o).getTrend());
	    if(c == 0)
	    {
	    	return Integer.compare(this.getWeight(), ((shareInfo) o).getWeight());
	    }
	    return c;
	 }

}
