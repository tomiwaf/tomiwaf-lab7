public class EndStation extends Station {
    public EndStation(String lineColor, String name){
        super(lineColor, name);
        this.type = "ENDSTATION ";
    }
    public String toString(){
        return super.toString();
    }
}