package dfsbfs.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
class Ticket implements Comparable<Ticket> {
    String departures;
    String arrivals;

    public Ticket() {}

    public Ticket(String departures, String arrivals) {
        this.departures = departures;
        this.arrivals = arrivals;
    }

    @Override
    public int compareTo(Ticket o) {
//        if (this.departures.equals(o.departures)) {
//            return o.arrivals.charAt(0) - this.arrivals.charAt(0);
//        }
//        return this.departures.charAt(0) - o.departures.charAt(0);
        if (this.arrivals.equals(o.departures)) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "[" + departures + ", " + arrivals + "]";
    }
}

class Travel {

    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        PriorityQueue<Ticket> ticketQueue = new PriorityQueue<>();

        for (String[] ticket : tickets) {
            ticketQueue.add(new Ticket(ticket[0], ticket[1]));
        }
        System.out.println(ticketQueue);




        return new String[]{};
    }

    public static void main(String[] args) {
        new Travel().solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        new Travel().solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
    }
}
