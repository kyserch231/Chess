package chess;

public class Movable implements Constants{
	
	public Location position = new Location();
	boolean state; 	// true if alive, false otherwise.
	int color;		// BLACK or WHITE
	
		
	public boolean isActive() {
		return state;
	}

	public boolean isBlack() {
		return (color == BLACK);
	}

	public boolean isWhite() {
		return (color == WHITE);
	}
	

	public Location getLocation(){
		return position;
	}
	
	public void setinActive(){
		state = INACTIVE;
	}
	
	public int getColor(){
		return color;
	}
	
	public void setPosition(Location end){
		position = end;
	}
	
	public void setState(boolean a){
		state = a;
	}
}
