import java.util.*;

public class Distance {
	
	public static void main(String[] args) {
		List<Integer> listTest1  = Arrays.asList(1, 2, 1, 2, 1);
		System.out.println("Test list #1: " + listTest1.toString());	
		System.out.println("Distances: " + findDistancesBetweenTwoMins(listTest1).toString());	
		System.out.println("");	
		
		randomList(5);
		System.out.println("Random list: " + listRandom.toString());			
		System.out.println("Distances: " + findDistancesBetweenTwoMins(listRandom).toString());	
		System.out.println("");	
		
		List<Integer> listTest2  = Arrays.asList(1, 1, 1, 1, 1);
		System.out.println("Test list #2: " + listTest2.toString());	
		System.out.println("Distances: " + findDistancesBetweenTwoMins(listTest2).toString());	
		System.out.println("");	
	}
	
	//TODO equals
	
	static List<Integer> listRandom = new ArrayList<Integer>();
	public static void randomList(int size) {
		for(int i = 0; i <  size; i++) {
			listRandom.add((int)(Math.random() * 10 + 1));
		}
	}
	
	public static List<Integer> findDistancesBetweenTwoMins(List<Integer> list) {
		List<Integer> Mins = new ArrayList<Integer>(findTwoMins(list));				
		List<Integer> indexesMins = new ArrayList<Integer>();	
		
		indexesMins = findIndexes(Mins.get(0), list);
		if (!Mins.get(0).equals(Mins.get(1))) {
			List<Integer> indexesSecondMins = new ArrayList<Integer>(findIndexes(Mins.get(1), list));			
			indexesMins.addAll(indexesSecondMins);
		} 			
		System.out.println("Indexes of all mins: " + indexesMins.toString());			
		
		return findDistances(indexesMins, list);
	}
	
	public static List<Integer> findTwoMins(List<Integer> list) {
		List<Integer> twoMins = new ArrayList<Integer>(list.size());
		twoMins.addAll(list);
		Collections.sort(twoMins);
		for (int i = twoMins.size() - 1; i > 1; i--) {
			twoMins.remove(i);
		}
		System.out.println("Two mins: " + twoMins.toString());
		return twoMins;
	}	
		
	public static List<Integer> findIndexes(Integer mins, List<Integer> list) {
		List<Integer> indexes = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals((int)mins)) {
				indexes.add(i);				
			}
		}
		return indexes;		
	}
		
	public static List<Integer> findDistances(List<Integer> indexes, List<Integer> list) {
		List<Integer> distances = new ArrayList<Integer>();		
		for (int i = 0; i < indexes.size() - 1; i++) {
			for (int y = 1 + i; y < indexes.size(); y++) {
				int a = Math.abs((int)indexes.get(y) - (int)indexes.get(i));
				distances.add(a);				
			}			
		}						
		return distances;	
	}	
	
}
