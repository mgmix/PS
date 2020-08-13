class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i < m; i++) list.add(nums1[i]);
        
        for (int i : nums2 ){
            list.add(i);
        }
           
        Collections.sort(list, (a, b) -> a - b);
        
        for (int i=0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }
    
            
    }
}
