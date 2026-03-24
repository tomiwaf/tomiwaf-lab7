public class EndStation extends Station {
    public EndStation(String lineColor, String name){
        super(lineColor, name);
        this.type = "ENDSTATION ";
    }
    public void addNext(Station s){
        addStation(s);
    }
    public void addPrev(Station s){
        addStation(s);
    }
    public void addStation(Station next){
        super.addNext(next);
        super.addPrev(next);
    }
    public String toString(){
        return super.toString();
    }
}