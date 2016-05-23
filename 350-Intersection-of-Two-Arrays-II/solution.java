public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> inter=new ArrayList<Integer>();
        int i=0;int j=0;
        while(i<len1&&j<len2){
            while(i<len1&&j<len2&&nums1[i]<nums2[j])i++;
            while(i<len1&&j<len2&&nums1[i]>nums2[j])j++;
            while(i<len1&&j<len2&&nums1[i]==nums2[j]){
                inter.add(nums1[i]);
                i++;
                j++;
            }
            
        }
        int []result = new int[inter.size()];
        for(i=0;i<inter.size();i++){
            result[i]=inter.get(i);
        }
        
        return result;
    }
}