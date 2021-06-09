package mmj.evoting.model;

public class Voter {

    private String firstname;
    private String lastname;
    private String[] codes;

    public Voter(int _ID ,String _name, int _voteCount) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.codes = codes;
    }
    public String get_firstname() { return firstname; }

    public String get_lastname() {
        return lastname;
    }

    public String[] get_codes() {
        return codes;
    }
}
