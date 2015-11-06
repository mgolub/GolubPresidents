package golub.presidents;

import java.io.Serializable;

/**
 * Created by student1 on 10/22/2015.
 */
public class President implements Serializable {
    private int number;
    private String president;
    private int birthYear;
    private int deathYear;
    private String tookOffice;
    private String leftOffice;
    private String party;

    public String getPresident(){
        return this.president;
    }
    public int getNumber(){return this.number; }
    public int getBirthYear(){return this.birthYear;}
    public int getDeathYear() {return deathYear;}
    public String getTookOffice(){ return tookOffice;}
    public String getLeftOffice(){ return leftOffice;}
    public String getParty() {return party;}




}
