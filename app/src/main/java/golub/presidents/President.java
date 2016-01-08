package golub.presidents;

import java.io.Serializable;

/**
 * Created by student1 on 10/22/2015.
 */
public class President implements Serializable {
    private int number;
    private String president;
    private int birth_year;
    private int death_year;

    private String took_office;
    private String left_office;
    private String party;

    public String getPresident(){
        return this.president;
    }
    public int getNumber(){return this.number; }
    public int getBirthYear(){return this.birth_year;}
    public int getDeathYear() {return death_year;}
    public String getTookOffice(){ return took_office;}
    public String getLeftOffice(){ return left_office;}
    public String getParty() {return party;}




}
