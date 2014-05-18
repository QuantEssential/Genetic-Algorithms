/**
 * A class representing a border between two states.
 */
public class Border {
	public int index1, index2, color1, color2;
	public State s1, s2;
	public int NEWcolor1, NEWcolor2;
	

	
	
	
	public Border(int i1, int i2, State st1, State st2) {
		index1 = i1;
		s1 = st1;
		s2 = st2;
	//	color1 = (int)(Math.random() * 4);
		//color2 = (int)(Math.random() * 4);
		index2 = i2;
		if(!s1.ConnectedStates.contains(s2) ) {
			s1.ConnectedStates.add(s2);
		} 
		
		if(!s2.ConnectedStates.contains(s1) ) {
			s2.ConnectedStates.add(s1);
		}
		
	}
}

