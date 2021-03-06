package model;


public class Company {
    private String name;
    private Integer id;
    private Adress adress;
    private String nip;
    private String regon;

    public Company() {
    }

    public Company( Integer id, Adress adress, String nip, String regon, String name) {
        this.id = id;
        this.adress = adress;
        this.nip = nip;
        this.regon = regon;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", adress=" + adress +
                ", nip='" + nip + '\'' +
                '}';
    }
}
