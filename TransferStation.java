import java.util.*;
public class TransferStation extends Station{
    public ArrayList<Station> otherStations = new ArrayList<Station>();
    public TransferStation(String line, String name){
        super(line, name);
        type = "TRANSFERSTATION ";
    }
    public void addTransferStationPrev(Station s){
        otherStations.add(s);
        s.next = this;
    }
    public void addTransferStationNext(Station s){
        otherStations.add(s);
        s.prev = this;
    }
    public String getOtherStations(){
        String k = "";
        for (Station s : otherStations){
            k+= "\t" + s.toString() + "\n";
        }
        return k;
    }
    public String toString(){
        return super.toString() + "\n\tTransfers: \n" + getOtherStations();
    }
}