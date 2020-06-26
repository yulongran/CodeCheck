import java.util.*;
public class isUnique{
	public static boolean isUnique(String s){
		if(s == null || s.length() == 0){
			return true;
		}
		Set<Character> dict = new HashSet<>();
		for(Character c: s.toCharArray()){
			if(!dict.add(c)){
				return false;
			}
		}
		return true;	
	}


	public static boolean isUnique2(String str){
		if(str == null || str.length() == 0){
			return true;
		}
		char[] sortedString = str.toCharArray();
		Arrays.sort(sortedString);
		for(int i=0; i<sortedString.length-1; i++){
			if(sortedString[i] == sortedString[i+1]){
				return false;
			}
		}

		return true;
	}

	public static void main(String[]args){
		System.out.println(isUnique("car"));
	}

}

/**

Time complexity O(n) where n is number of characters of input string s
Space complexity O(n) because in the worse case our set stores all characters in string s


Without data structure

Time complexity O(nlogn) because of sorting
Space complexity O(n) 

**/
