package Problems.HashTables;

import Common.Problem;

import java.util.HashMap;
import java.util.Map;

public class TraceCompletePath extends Problem {
    @Override
    public void run() {
        System.out.println("Running Trace Complete Path Of A Journey");
        HashMap<String, String> travelMap;
        travelMap = new HashMap<>();
        travelMap.put("NewYork", "Chicago");
        travelMap.put("Boston", "Texas");
        travelMap.put("Missouri", "NewYork");
        travelMap.put("Texas", "Missouri");
        System.out.println("Travel Path: " + this.tracePath(travelMap));
        System.out.println("Travel Path (Better Solution): " + this.tracePathBetterSolution(travelMap));
        travelMap = new HashMap<>();
        travelMap.put("NewYorKk", "Chicago");
        travelMap.put("Boston", "Texas");
        travelMap.put("Missouri", "NewYork");
        travelMap.put("Texas", "Missouri");
        System.out.println("Travel Path: " + this.tracePath(travelMap));
        System.out.println("Travel Path (Better Solution): " + this.tracePathBetterSolution(travelMap));
    }

    // O(n^2) solution
    private String tracePath(HashMap<String, String> map) {
        String result = "";
        int count = 0;
        for (Map.Entry entry: map.entrySet()) {
            result = "";
            count = 0;
            String currKey = (String) entry.getKey();
            while (map.containsKey(currKey)) {
                String value =  map.get(currKey);
                result = result + currKey + "->" + value + ", ";
                count++;
                currKey = value;
            }
            if (count == map.size()) return result;
        }
        return "";
    }
    // O(n) Solution
    // Reverse the map
    // In Original map ending point will not be there in the key
    // In reverse map starting point will not be there in the key
    // Determine the starting point and build the result string
    private String tracePathBetterSolution(HashMap<String, String> map) {
        String result = "";
        // Reverse the map
        HashMap<String, String> reverseMap = new HashMap<>();
        for (Map.Entry<String, String> entry: map.entrySet()) {
            reverseMap.put(entry.getValue(),entry.getKey());
        }
        String from = "";
        int count = 0;
        for (Map.Entry<String, String> entry: map.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                from = entry.getKey();
                count++;
            }
        }
        // More than one key missing means disconnected travel path
        if (count > 1) return "";
        while (map.containsKey(from)) {
            String value =  map.get(from);
            result = result + from + "->" + value + ", ";
            from = value;
        }
        return result;
    }
}
