package pojo;

public class Student {
    private int sID=-1;
    private String sName;
    private int sSex;
    private int sAge;
    private String sMajor;

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsSex() {
        return sSex;
    }

    public void setsSex(int sSex) {
        this.sSex = sSex;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public String getsMajor() {
        return sMajor;
    }

    public void setsMajor(String sMajor) {
        this.sMajor = sMajor;
    }

    public Student(String sName, int sSex, int sAge, String sMajor) {
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
        this.sMajor = sMajor;
    }

    public Student(int sID, String sName, int sSex, int sAge, String sMajor) {
        this.sID = sID;
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
        this.sMajor = sMajor;
    }

    @Override
    public String toString() {
        return "["+sID+"，"+sName+"，"+sSex+"，"+sAge+"，"+sMajor+"]";
    }
}
