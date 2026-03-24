import java.util.*;
public class TransferStation extends Station{
    ArrayList<Station> otherStations = new ArrayList<Station>();
    public TransferStation(String line, String name){
        super(line, name);
        type = "TRANSFERSTATION ";
    }
    public void addTransferStationPrev(Station s){
        this.otherStations.add(0, s);
    }
    public void addTransferStationNext(Station s){
        this.otherStations.add(s);
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