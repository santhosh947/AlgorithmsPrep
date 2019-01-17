package Amz_Nov_2018;

public class Emp implements Comparable<Emp>
{
  public String name;
  public int efficiency;
  public int rollingTimeTaken;
  public Emp[] reportees;
  public Emp(String n,int e, int t)
  {
	  this.name = n;
    this.efficiency = e;
    this.rollingTimeTaken = t;    
  }
@Override
public int compareTo(Emp arg0) {
	// TODO Auto-generated method stub
	return Integer.compare((arg0.efficiency+arg0.rollingTimeTaken),(this.efficiency + this.rollingTimeTaken));
	}
}
