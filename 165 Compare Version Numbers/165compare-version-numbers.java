class Solution {
    public int compareVersion(String version1, String version2) {

        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");

        int length = v1.length>v2.length?v1.length:v2.length;

        boolean valid = true;

        for(int i=0;i<length;i++){
            int d1 = i<v1.length? Integer.valueOf(v1[i]):0;
            int d2 = i<v2.length? Integer.valueOf(v2[i]):0;
            if(d1>d2){
                return 1;
            }
            if(d2>d1){
                return -1;
            }
        }

        return 0;

        
    }
}