class Robot {
    private int posInit;
    private int posCurr;

    public Robot(int pos) {
        this.posInit = pos;
        this.posCurr = pos;
    }

    public int getPos() {
        return posCurr;
    }

    public void returnToStart() {
        this.posCurr = posInit;
    }
}