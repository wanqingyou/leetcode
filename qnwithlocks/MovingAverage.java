//Moving Average from Data Stream

public class MovingAverage{
  private int size;
  private List<Integer> nums;
  private int position=0;
  public MovingAverage(int size){
    this.size=size;
    nums=new ArrayList<Integer>();
    this.position=0;
  }
  
  public double next(int num){
    nums.add(num);
    if(nums.size()<=2){
      double sum=0;
      for(int ele:nums){
        sum+=ele;
      }
      return sum/nums.size();
    }else{
      double sum=0;
      for(int i=position;i<position+3;i++){
        sum+=nums.get(i);
      }
      position++;
      return sum/3;
    }
  }
  
}
