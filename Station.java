import java.util.*;
public class Station {
    protected String name;
    protected String lineColor;
    protected boolean inService;
    public Station prev;
    public Station next;
    protected String type;
    protected String prevName;
    protected String nextName;
    public Station(String lineColor, String name) {
        this.name = name;
        this.lineColor = lineColor;
        this.inService = true;
        type = "STATION ";
    }
    public String getName() {
        return name;
    }
    public String getLineColor() {
        return lineColor;
    }
    public boolean isAvailable() {
        return inService;
    }
    public void addPrev(Station prev) {
        this.prev = prev;
        if (prev.next == null) {
            prev.next = this;
        }
    }
    public void addNext(Station next) {
        this.next = next;
        if(next.prev == null) {
            next.prev = this;
        }

    }
    public void makeEnd(){
        if (next != null && prev == null) {
            prev = next;
        } else if (prev != null && next == null) {
            next = prev;
        }
    }
    public void connect(Station s){
        addNext(s);
        s.addPrev(this);
    }
    public int tripLength(Station t){
        if (this == t){
            return 0;
        }
        ArrayList<Station> queue = new ArrayList<Station>();
        ArrayList<Station> visited = new ArrayList<Station>();
        queue.add(this);
        visited.add(this);
        int distance = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                Station current = queue.remove(0);

                if (current.next != null && !visited.contains(current.next)){
                    if (current.next.equals(t)){
                        return distance;
                    }
                    visited.add(current.next);
                    queue.add(current.next);
                }
                if (current.prev != null && !visited.contains(current.prev)){
                    if (current.prev.equals(t)){
                        return distance;
                    }
                    visited.add(current.prev);
                    queue.add(current.prev);
                }
                if (current instanceof TransferStation){
                    for(Station s : ((TransferStation) current).otherStations){
                        if (!visited.contains(s)){
                            if (s.equals(t)){
                                return distance;
                            }
                            visited.add(s);
                            queue.add(s);
                        }
                    }
                }
            }
        }
        return -1;

    }
    public void switchAvailable(){
        this.inService = !this.inService;
    }
    public boolean equals(Object s){
        if (!(s instanceof Station)) {
            return false;
        }
        Station s1 = (Station) s;
        return s1.getName().equals(this.getName()) && s1.getLineColor().equals(this.getLineColor());
    }
    public String toString(){
        if (prev == null){
            prevName = "none";
        }
        if (next == null){
            nextName = "none";
        }
        if (prev != null){
            prevName = prev.getName();
        }
        if (next != null){
            nextName = next.getName();
        }
        return type + name + ": " + lineColor + " line, in service: " + inService + ", previous station: " + prevName + ", next station: " + nextName;
    }
}