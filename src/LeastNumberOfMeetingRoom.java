import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Interval{
	int start = 0;
	int end = 0;
	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}
class start implements Comparator<Interval>{
		public int compare(Interval I1, Interval I2){
			if(I1.start == I2.start){
				if(I1.end > I2.end){
					return 1;
				}else if(I1.end < I2.end){
					return -1;
				}else{
					return 0;
				}
			}else{
				if(I1.start > I2.start){
					return 1;
				}else if(I1.start < I2.start){
					return -1;
				}else{
					return 0;
				}
			}
		}
	}
class end implements Comparator<Interval>{
	public int compare(Interval I1, Interval I2){
		if(I1.end == I2.end){
			if(I1.start > I2.start){
				return 1;
			}else if(I1.start < I2.start){
				return -1;
			}else{
				return 0;
			}
		}else{
			if(I1.end > I2.end){
				return 1;
			}else if(I1.end < I2.end){
				return -1;
			}else{
				return 0;
			}
		}
	}
}
public class LeastNumberOfMeetingRoom {
	public static int leastMeetingRoom(List<Interval> meet){
		int max = 0;
		int num = 0;
		List<Interval> one = new ArrayList<Interval>(meet);
		List<Interval> two = new ArrayList<Interval>(meet);
		Collections.sort(one, new start());
		Collections.sort(two, new end());
		for(Interval i : one){
			System.out.println(i.start + " " + i.end);
		}
		System.out.println();
		for(Interval i : two){
			System.out.println(i.start + " " + i.end);
		}
		System.out.println();
		int i = 0;
		int j = 0;
		while(i < one.size()){
			if(one.get(i).start < two.get(j).end){
				num++;
				max = Math.max(num, max);
				i++;
			}else{
				num--;
				max = Math.max(num, max);
				j++;
			}
			//System.out.println(num);
		}
		return max;
	}
	public static void main(String[] args){
		List<Interval> meet = new ArrayList<Interval>();
		//meet.add(new Interval(10, 20));
		meet.add(new Interval(18, 19));
		meet.add(new Interval(17, 19));
		meet.add(new Interval(16, 18));
		meet.add(new Interval(10, 12));
		meet.add(new Interval(8, 10));
		meet.add(new Interval(9, 10));
		meet.add(new Interval(9, 12));
		//meet.add(new Interval(8, 10));
		//meet.add(new Interval(8, 10));
		//meet.add(new Interval(8, 10));
		//meet.add(new Interval(8, 10));
		//meet.add(new Interval(8, 10));
		//meet.add(new Interval(8, 10));
		//meet.add(new Interval(8, 10));
		//meet.add(new Interval(8, 10));
		//meet.add(new Interval(8, 10));
		System.out.print(leastMeetingRoom(meet));
	}
}
