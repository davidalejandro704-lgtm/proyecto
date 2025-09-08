class Store {
    private int location;
    private long tengesInit;
    private long tengesCurr;

    public Store(int location, int money) {
        this.location = location;
        this.tengesInit = money;
        this.tengesCurr = money;
    }

    public int getLocation() {
        return location;
    }

    public long getMoney() {
        return tengesCurr;
    }

    public void empty() {
        this.tengesCurr = 0;
    }

    public void resupply() {
        this.tengesCurr = tengesInit;
    }

    public boolean isEmpty() {
        return tengesCurr == 0;
    }
}