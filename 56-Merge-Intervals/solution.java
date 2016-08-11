/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new ArrayList<Interval>();
        if(intervals==null||intervals.size()==0) return result;
        
        Comparator<Interval> comp = new Comparator<Interval>()  {
			@Override
			public int compare(Interval i1, Interval i2) {
			    if(i1.start==i2.start) return i1.end-i2.end;
			    return i1.start-i2.start;
			}
        }
        ;
        Collections.sort(intervals,comp);
        
        result.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval current = intervals.get(i);
            Interval last = result.get(result.size()-1);
            if(current.start>last.end){
                result.add(current);
            }else{
                if(last.end<current.end){
                    last.end=current.end;
                }
            }
        }
        
        return result;
    }
}