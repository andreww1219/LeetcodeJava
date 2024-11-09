package SuiXiangLu.Backtrace;


import org.junit.Test;

import java.util.*;

// 重新安排行程
public class Solution332 {
    @Test
    public void test () {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList(new String[]{"MUC","LHR"}));
        tickets.add(Arrays.asList(new String[]{"JFK","MUC"}));
        tickets.add(Arrays.asList(new String[]{"SFO","SJC"}));
        tickets.add(Arrays.asList(new String[]{"LHR","SFO"}));
        System.out.println(findItinerary2(tickets));
    }

    // 初见 回溯 used数组
    private LinkedList<String> result = new LinkedList<>();
    private boolean[] used;

    private boolean backtrace1(List<List<String>> tickets) {
        if (result.size() == tickets.size() + 1) {
            return true;
        }
        for (int i = 0; i < tickets.size(); ++i) {
            List<String> ticket = tickets.get(i);
            if (!used[i]) {
                if (ticket.get(0).equals(result.getLast())) {
                    result.add(ticket.get(1));
                    used[i] = true;
                    if (backtrace1(tickets))
                        return true;
                    result.removeLast();
                    used[i] = false;
                }
            }
        }
        return false;
    }
    public List<String> findItinerary1(List<List<String>> tickets) {
        used = new boolean[tickets.size()];
        Arrays.fill(used, false);
        tickets.sort((t1, t2)-> t1.get(1).compareTo(t2.get(1)));
        result.add("JFK");
        backtrace1(tickets);
        return result;
    }

    // 回溯，hashmap + treemap

    private Map<String, Map<String, Integer>> map = new HashMap<>();
    private boolean backtrace2(int ticketNum) {
        if (result.size() == ticketNum + 1) {
            return true;
        }
        if (map.containsKey(result.getLast())) {
            for (Map.Entry<String, Integer> entry: map.get(result.getLast()).entrySet()) {
                int cnt = entry.getValue();
                if (cnt > 0) {
                    entry.setValue(cnt - 1);
                    result.add(entry.getKey());
                    if (backtrace2(ticketNum))
                        return true;
                    result.removeLast();
                    entry.setValue(cnt);
                }
            }
        }
        return false;
    }
    public List<String> findItinerary2(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String ticketSrc = ticket.get(0), ticketDest = ticket.get(1);
            if (map.containsKey(ticketSrc)) {
                Map<String, Integer> val = map.get(ticketSrc);
                val.put(ticketDest, val.getOrDefault(ticketDest, 0) + 1);
            } else {
                // 升序 Map
                Map<String, Integer> val = new TreeMap<>();
                val.put(ticketDest, 1);
                map.put(ticketSrc, val);
            }
        }
        result.add("JFK");
        backtrace2(tickets.size());
        return result;
    }
}
