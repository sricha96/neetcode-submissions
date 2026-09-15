class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // Total number of cars
        int n = position.length;

        /*
         * Har car ko [position, speed] ke form mein store karenge.
         *
         * cars[i][0] = car ki position
         * cars[i][1] = car ki speed
         */
        double[][] cars = new double[n][2];

        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        /*
                 * Cars ko position ke descending order mein sort karo.
         *
         * Matlab target ke closest car pehle aayegi,
         * aur target se sabse door car last mein.
         *
         * Example:
         * position = [10, 5, 8]
         *
         * Sorted:
         * [10, 8, 5]
         */
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // Ab tak kitni separate car fleets bani hain
        int carFleet = 0;

        /*
         * Previous fleet ko target tak pahunchne mein kitna time lagega.
         *
         * Hum sirf previous fleet ka time store kar rahe hain,
         * isliye alag time[] array ki zarurat nahi hai.
         */
        double prevTime = 0;

        /*
         * Cars ko target ke closest se farthest tak process karenge.
         */
        for(int i = 0; i < n; i++){

            /*
             * Target tak pahunchne ka time:
             *
             * Time = Distance / Speed
             *
             * Distance = target - current position
             */
            double time = (target - cars[i][0]) / cars[i][1];

            /*
             * Agar current car ko target tak pahunchne mein
             * previous fleet se ZYADA time lag raha hai,
             * to current car previous fleet ko catch nahi kar sakti.
             *
             * Isliye current car ek NEW fleet banayegi.
             */
            if(time > prevTime){

                // Ek new fleet mil gayi
                carFleet++;

                /*
                 * Current car ab latest fleet ban gayi.
                 * Iska time future mein peeche wali cars
                 * ke saath compare hoga.
                 */
                prevTime = time;
            }

            /*
             * Agar:
             *
             * time <= prevTime
             *
             * to current car previous fleet ko catch kar legi.
             *
             * Isliye new fleet nahi banegi.
             *
             * prevTime ko change nahi karna hai,
             * kyunki current car existing fleet mein merge ho gayi.
             */
        }

        // Total number of car fleets return karo
        return carFleet;
    }
}