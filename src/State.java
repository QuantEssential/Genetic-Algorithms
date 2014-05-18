import java.util.Vector;


public class State {
	public Vector<State> ConnectedStates;

	
	public int fitness = 0;
	public int color;
	public int index;
	public String s;
	public int oldcolor;
	public int [] domain;

	
	public void revert() {
		color = oldcolor;
	}
	
	public void setcol(int c){
		color = c;
	}
	
	public  void reproduce() {
		oldcolor = color;
		color = (int)(Math.random() * 4);
	}

	public void createDomain() {
	}
	
	public void subfromDomain(int col) {
		domain[col] = 0;
	}
	
	public void addtoDomain(int col) {
		domain[col] = 1;
	}
	
	
	State(String str){
		ConnectedStates = new Vector<State>();
		s = str;
		color = (int)(Math.random() * 4);
		domain = new int[4];
		
		for(int h = 0; h<4; h++) {
			domain[h] = 1;
		}
		
		domain[color] = 2;  

	}
	
	public void print()	{
		System.out.print(s + ", Color: " + Integer.toString(color));
	}
}
