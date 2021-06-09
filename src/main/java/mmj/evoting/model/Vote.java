package mmj.evoting.model;

public class Vote {

    private String _name;
    private int _endDate;
    private int _codesCount;


    public Vote(String _name, int _endDate, int _codesCount) {
        this._name = _name;
        this._endDate = _endDate;
        this._codesCount = _codesCount;
    }

    public String get_name() {
        return _name;
    }

    public int get_endDate() {
        return _endDate;
    }

    public int get_codesCount() {
        return _codesCount;
    }
}
