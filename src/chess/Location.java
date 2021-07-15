package chess;

public class Location {
	
	public Location(int x, int y){
		positionX=x;
		positionY=y;
	}
	
	public Location(Location x){
		positionX=x.getPositionX();
		positionY=x.getPositionY();
	}
	
	public Location(){}

	private int positionX;
	private int positionY;
	
	/*
	 * returns the x-location
	 */
	int getPositionX(){
		return positionX;
	}
	
	/*
	 * returns the y-location
	 */
	int getPositionY(){
		return positionY;
	}
	
	/*
	 * sets location given a x and y location
	 */
	void setPosition(int x,int y){
		positionX=x;
		positionY=y;
	}
	
	/*
	 * sets location given a location
	 */
	void setPosition(Location pos){
		positionX=pos.getPositionX();
		positionY=pos.getPositionY();
	}
}