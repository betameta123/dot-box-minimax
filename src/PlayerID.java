public enum PlayerID {
	
    BLUE('B'), RED('R');

    private final char id;

    PlayerID(char id){
       this.id = id;
    }

    public char asChar(){
        return this.id;
    }
}
