package mmj.evoting.model;

public class Candidate {

    private int _ID;
    private String _name;
    private int _voteCount;

    public Candidate(int _ID ,String _name, int _voteCount) {
        this._ID = _ID;
        this._name = _name;
        this._voteCount = _voteCount;
    }
    public int get_ID() { return _ID; }

    public String get_name() {
        return _name;
    }

    public int get_voteCount() {
        return _voteCount;
    }
}
