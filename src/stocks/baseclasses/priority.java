/**
 * 
 */
package stocks.baseclasses;

/**
 * @author sacholle
 *
 */
public enum priority {
	StronglyInterested(3),
	Interested(2),
	Neutral(1),
	NotSure(0);
	
	private int priority;

    priority(int priority) {
        this.priority = priority;
    }

    public int getpriority() { 
        return priority;
    }
}
