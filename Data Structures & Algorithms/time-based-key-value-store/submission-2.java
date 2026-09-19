class TimeMap {

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(map.containsKey(key)){
            List<Pair> pair = map.get(key);
            int l = 0;
            int r = pair.size() - 1;
            while(l <= r){
                int mid = l + (r - l)/2;
                if(pair.get(mid).timestamp <= timestamp){
                    res = pair.get(mid).value;
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return res;
    }
}

class Pair{
    String value;
    int timestamp;

    Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
