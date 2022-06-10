class Solution {
    public int maxArea(int[] height) {
        
    int start=0,end = height.length-1;
        int area = 0,maxArea=0;
        
        
        while(start<end){
            
            area = (end-start) * Math.min(height[start],height[end]);
            
            if(area>maxArea) maxArea = area;
            
          
            if(height[start]<height[end]) start++;
            else end--;
            
        }
            
        return maxArea;
    }
}