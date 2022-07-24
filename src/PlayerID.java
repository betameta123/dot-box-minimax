public enum  PlayerID {
    Blue('B'), Red('R');
    private char id;

    PlayerID(char id){
       this.id = id;
    }

    public char toChar(){
        return id;
    }
}
