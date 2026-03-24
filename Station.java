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
    }
    public void addNext(Station next) {
        this.next = next;
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
    public int tripLength(Station s){
        return -1;

    }
    public void switchAvailable(){
        this.inService = !this.inService;
    }
    public boolean equals(Station s){
        return this == s;
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