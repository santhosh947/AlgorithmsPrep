package stocks.baseclasses;

public enum diversity {
	diversedMode(0),
	mixedMode(1),
	profitDrivenMode(2);
	
	private int diversity;

	diversity(int diversity) {
        this.diversity = diversity;
    }

    public int getdiversity() { 
        return diversity;
    }
}
