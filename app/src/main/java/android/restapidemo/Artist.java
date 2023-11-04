package android.restapidemo;

public class Artist {
    String name;
    String numberFans;
    String piclink;

    public Artist()
    {

    }

    public Artist(String name, String numberFans, String piclink) {
        this.name = name;
        this.numberFans = numberFans;
        this.piclink = piclink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberFans() {
        return numberFans;
    }

    public void setNumberFans(String numberFans) {
        this.numberFans = numberFans;
    }

    public String getPiclink() {
        return piclink;
    }

    public void setPiclink(String piclink) {
        this.piclink = piclink;
    }
}
