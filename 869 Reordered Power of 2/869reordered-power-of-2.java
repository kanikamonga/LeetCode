class Solution {
    public boolean reorderedPowerOf2(int n) {
        // 1. Let's get a "fingerprint" of the digits in our number n
        int[] nArr = getDigit(n);

        // 2. Now, we'll check every power of 2 up to a certain point
        for (int i = 0; i < 31; i++) { // We only need to go up to 2^30 because n <= 10^9
            int power = 1 << i; // This is a fancy way of calculating 2^i (2 to the power of i)

            // 3. Get the "fingerprint" of the digits in this power of 2
            int[] powerArr = getDigit(power);

            // 4. Are the "fingerprints" the same? If so, we found a match!
            if (Arrays.equals(nArr, powerArr)) return true; // Bingo! We can rearrange n to be a power of 2!
        }

        // 5. If we get here, it means we didn't find any matching power of 2 fingerprints
        return false; 
    }

    // Helper function to get the "fingerprint" of a number (how many times each digit appears)
    public int[] getDigit(int num) {
        int[] arr = new int[10]; // Create an array to count digits 0-9
        while (num > 0) {
            int digit = num % 10; // Get the last digit (like finding the remainder when dividing by 10)
            arr[digit]++; // Increment the count for that digit
            num /= 10; // Remove the last digit (like integer division by 10)
        }
        return arr; // Return the array with digit counts
    }
}