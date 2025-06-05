class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for( int i = 0; i< arr.length-1; i++)
        {
            if(arr[i+1] - arr[i] <= min)
            {
                min = arr[i+1] -arr[i];
            }
        }

        for( int i = 0; i< arr.length-1; i++)
        {
            if(arr[i+1] - arr[i] == min)
            {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                result.add(pair);
            }
        }
        return result;
    }
}