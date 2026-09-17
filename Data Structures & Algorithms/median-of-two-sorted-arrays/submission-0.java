class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /*
         * Binary Search hum hamesha SMALLER array par karenge.
         *
         * Agar nums1 bada hai, to arrays ko swap kar do.
         *
         * Example:
         * nums1 = [1,2,3,4,5]
         * nums2 = [6,7]
         *
         * To recursive call ke baad:
         * nums1 = [6,7]       -> smaller array
         * nums2 = [1,2,3,4,5] -> bigger array
         */
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // nums1 aur nums2 ki length
        int m = nums1.length;
        int n = nums2.length;

        /*
         * Hum nums1 ke elements par directly binary search nahi kar rahe.
         *
         * Hum PARTITION POSITION par binary search kar rahe hain.
         *
         * Example:
         * nums1 = [1, 3]
         *
         * Possible partitions:
         *
         * | 1 3       -> partition = 0
         * 1 | 3       -> partition = 1
         * 1 3 |       -> partition = 2
         *
         * Isliye:
         * left = 0
         * right = m
         */
        int left = 0;
        int right = m;

        /*
         * Jab tak nums1 mein koi possible partition position available hai,
         * binary search continue karo.
         */
        while (left <= right) {

            /*
             * nums1 mein partition position.
             *
             * Ye normal Binary Search ka mid hai.
             */
            int partition1 = left + (right - left) / 2;

            /*
             * Total left side mein kitne elements hone chahiye?
             *
             * (m + n + 1) / 2
             *
             * partition1 elements nums1 se left side mein aa rahe hain.
             *
             * Isliye remaining elements nums2 se lene hain:
             *
             * partition2 =
             * total required left elements - partition1
             */
            int partition2 = (m + n + 1) / 2 - partition1;


            /*
             * nums1 ke partition ke LEFT side ka last element.
             *
             * Example:
             * nums1 = [1 | 3]
             *
             * partition1 = 1
             * left1 = 1
             *
             * Agar partition1 == 0 hai:
             *
             * nums1 = [ | 1 3]
             *
             * Left side mein koi element nahi hai.
             *
             * Is case mein Integer.MIN_VALUE use karte hain
             * taaki comparison mein ye sabse chhota value behave kare.
             */
            int left1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];


            /*
             * nums1 ke partition ke RIGHT side ka first element.
             *
             * Example:
             * nums1 = [1 | 3]
             *
             * right1 = 3
             *
             * Agar partition1 == m hai:
             *
             * nums1 = [1 3 |]
             *
             * Right side mein koi element nahi hai.
             *
             * Isliye Integer.MAX_VALUE use karte hain.
             */
            int right1 = (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];


            /*
             * Same logic nums2 ke liye.
             *
             * nums2 ke LEFT side ka last element.
             *
             * Example:
             * nums2 = [2, 4 | 5]
             *
             * left2 = 4
             */
            int left2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];


            /*
             * nums2 ke RIGHT side ka first element.
             *
             * Example:
             * nums2 = [2, 4 | 5]
             *
             * right2 = 5
             *
             * Agar partition2 == n hai,
             * to right side mein koi element nahi hai,
             * isliye Integer.MAX_VALUE.
             */
            int right2 = (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];


            /*
             * AB CHECK KARO KI PARTITION CORRECT HAI YA NAHI.
             *
             * Humein chahiye:
             *
             * left1 <= right2
             * AND
             * left2 <= right1
             *
             * Iska simple meaning:
             *
             * LEFT side ka koi bhi element
             * RIGHT side ke kisi element se bada nahi hona chahiye.
             *
             * Example:
             *
             * nums1 = [1, 3 | ]
             * nums2 = [2 | 4, 5]
             *
             * left1  = 3
             * right1 = MAX
             * left2  = 2
             * right2 = 4
             *
             * Check:
             *
             * 3 <= 4  -> true
             * 2 <= MAX -> true
             *
             * So partition correct hai.
             */
            if (left1 <= right2 && left2 <= right1) {

                /*
                 * Ab partition correct mil gaya.
                 *
                 * Ab sirf ye dekhna hai ki total elements
                 * EVEN hain ya ODD.
                 */
                if ((m + n) % 2 == 0) {

                    /*
                     * EVEN number of elements mein
                     * median = middle ke 2 elements ka average.
                     *
                     * LEFT side ka largest element:
                     * max(left1, left2)
                     *
                     * RIGHT side ka smallest element:
                     * min(right1, right2)
                     *
                     * Median:
                     *
                     * (leftMax + rightMin) / 2
                     *
                     * 2.0 use kiya hai taaki decimal answer mile.
                     */
                    return (Math.max(left1, left2)
                            + Math.min(right1, right2)) / 2.0;
                }

                /*
                 * ODD number of elements mein
                 * median LEFT side ka maximum element hota hai.
                 *
                 * Isliye:
                 *
                 * max(left1, left2)
                 */
                return Math.max(left1, left2);
            }


            /*
             * Agar partition correct nahi hai,
             * to decide karna hai ki nums1 ka partition
             * LEFT move kare ya RIGHT.
             *
             * CASE 1:
             *
             * left1 > right2
             *
             * Example:
             *
             * nums1: [1, 5 | 6]
             * nums2: [2 | 3, 4]
             *
             * left1 = 5
             * right2 = 3
             *
             * 5 > 3
             *
             * Matlab nums1 se humne LEFT side mein
             * bahut zyada elements le liye.
             *
             * Partition ko LEFT move karna hoga.
             */
            if (left1 > right2) {

                // nums1 ka partition left side mein move karo
                right = partition1 - 1;

            } else {

                /*
                 * Agar left1 > right2 nahi hai,
                 * to problem ye hai:
                 *
                 * left2 > right1
                 *
                 * Matlab nums1 se LEFT side mein
                 * bahut kam elements liye hain.
                 *
                 * Partition ko RIGHT move karna hoga.
                 */
                left = partition1 + 1;
            }
        }

        /*
         * Valid input ke case mein yahan normally nahi aayenge.
         */
        return 0.0;
    }
}
