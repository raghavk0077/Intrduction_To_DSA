import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    
    static void findPatterns(int index, ArrayList<Integer> arr, boolean freq[], ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp){
        if(temp.size() == arr.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        // while(int i != index && arr.get(i) == arr.get(i - 1)) continue;
        for(int i = 0; i < arr.size(); i++){
            if(!freq[i]){
                temp.add(arr.get(i));
                freq[i] = true;
                findPatterns(i+1, arr, freq, ans, temp);
                temp.remove(temp.size() - 1);
                freq[i] = false;
            }
        }
    }
    
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(arr);
        boolean freq[] = new boolean[n];
        findPatterns(0, arr, freq, ans, new ArrayList<>());
        Set<ArrayList<Integer>> set = new HashSet<>(ans);
        ArrayList<ArrayList<Integer>> res= new ArrayList<>(set);
        Collections.sort(res,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> p,ArrayList<Integer> q)
            {   
                int oneSize = p.size();
                int twoSize = q.size();

                for(int i = 0; i < Math.min(oneSize,twoSize); i++){
                if(i == oneSize || i == twoSize)
                return oneSize - twoSize;

                int elementOne = p.get(i);
                int elementTwo = q.get(i);
                
                if(elementOne == elementTwo)
                   continue;
                   
                return Integer.compare(elementOne, elementTwo);
                }
                return p.size()-q.size();
            }
        });
        return res;
    }
};