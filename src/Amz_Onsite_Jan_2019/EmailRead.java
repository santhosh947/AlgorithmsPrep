package Amz_Onsite_Jan_2019;

import java.util.Collections;
import java.util.PriorityQueue;

import Amz_Nov_2018.Emp;


public class EmailRead{
  //Queue<Emp> holder = new LinkedList<Emp>();
  final PriorityQueue<Emp> holder = new PriorityQueue<>(Collections.reverseOrder());
  
  
  public EmailRead(Emp root)
  {
    if(root!=null)
      holder.add(root);
  }
  
  public boolean hasNext()
  {
    return !holder.isEmpty();
  }
  
  public Emp next()
  {
    Emp e = holder.remove();
    
    Emp[] reporte = e.reportees;
    int parentEff =e.efficiency+e.rollingTimeTaken;
    int lvl =1;
    while(lvl>0 && reporte!=null && reporte.length>0)
    {
      for(int i=0;i<reporte.length;i++)
      {
        Emp modEmp = reporte[i];
        modEmp.rollingTimeTaken = parentEff;
        holder.add(modEmp);
      }
      lvl--;
    }
    
    return e;
  }
  
}


