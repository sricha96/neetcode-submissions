class TimeMap {

    HashMap<String, List<Data>> map = null;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Data> data = map.get(key);
        int n = data.size();
        int start = 0;
        int end = n - 1;
        String res = "";
        while(start <= end){
            int mid = start + (end - start)/2;
            if(data.get(mid).timestamp <= timestamp){
                res = data.get(mid).value;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return res;
    }
}

class Data{
    String value;
    int timestamp;

    public Data(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
