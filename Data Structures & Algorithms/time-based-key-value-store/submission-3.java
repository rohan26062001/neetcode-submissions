class TimeMap {
    private final Map<String, String> actualMap;
    private final Map<String, Integer> min;

    public TimeMap() {
        this.actualMap = new HashMap<>();
        this.min = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        actualMap.put(key + "_" + timestamp, value);

        // set min
        if(min.get(key) == null) {
            min.put(key, timestamp);
        } else {
            min.put(key, Math.min(min.get(key), timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if(actualMap.get(key + "_" + timestamp) != null){
            return actualMap.get(key + "_" + timestamp);
        } else if(min.get(key) != null) {
            for(int i = timestamp - 1; i >= 0; i--) {
                if(actualMap.get(key + "_" + i) != null)
                    return actualMap.get(key + "_" + i);
            }
        } 

        return "";
    }
}
