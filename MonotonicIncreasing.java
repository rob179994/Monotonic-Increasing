import java.util.ArrayList;
import java.util.Collections;

public class MonotonicIncreasing {
	
	public ArrayList<Integer> getMonoSubSeq(ArrayList<Integer> inputArray){
		ArrayList<Integer> longestSubSeq = new ArrayList<Integer>();
		ArrayList<Integer> tempSubSeq = new ArrayList<Integer>();
		
		// error check that the size > 0, and a valid result exhists
		if(inputArray.size()==0) {
			return longestSubSeq;
		}
		
		// add initial number to begin process
		longestSubSeq.add(inputArray.get(0));
		tempSubSeq.add(inputArray.get(0));
		
		// run through all numbers looking for monotonically increasing subsequences
		for(int i=1;i<inputArray.size();i++) {
			// if the next element is monotonically increasing, add to list
			if(inputArray.get(i) >= tempSubSeq.get(tempSubSeq.size()-1)) {
				tempSubSeq.add(inputArray.get(i));
			}
			else {
				if(tempSubSeq.size()>longestSubSeq.size()) {
					// clone the new one
					longestSubSeq = new ArrayList<Integer>(tempSubSeq);
				}
				// start new temp array from current item
				tempSubSeq.clear();
				tempSubSeq.add(inputArray.get(i));
			}
		}
		
		// check to see if final array is bigger
		if(tempSubSeq.size()>longestSubSeq.size()) {
			longestSubSeq = new ArrayList<Integer>(tempSubSeq);
		}
		
		// reverse ArrayList
		Collections.reverse(longestSubSeq);
		
		return longestSubSeq;
	}
	
	public static void main(String[] args){
		MonotonicIncreasing mon = new MonotonicIncreasing();
		
		// create test case and add test items
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(5); 
		testList.add(6);   // 5 long
		testList.add(4);
		testList.add(6);   // 2 long
		testList.add(3);
		testList.add(7);
		testList.add(11);
		testList.add(12);
		testList.add(13);
		testList.add(20);   // 6 long
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(5); 
		testList.add(6);   
		testList.add(9);
		testList.add(10);	// 7 long
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(5); 
		testList.add(6);   // 5 long
		
		// get results and print them
		ArrayList<Integer> result = mon.getMonoSubSeq(testList);
		System.out.println(result);
	}
}
