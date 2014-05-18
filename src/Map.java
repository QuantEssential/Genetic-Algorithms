import java.util.Vector;

public class Map {
	public  Vector<Border> borders;
	public Vector<State> states;
	double score;
	double runtime;
	
	
	public void scoregen() {
		double scoregen = 0;
		for (Border b : borders) {
			int test1 = states.get(b.index1).color;
			int test2 = states.get(b.index2).color;
			
			if(test1 == test2) {
				scoregen++;
			}
			
		}
		score = scoregen;
	}

	public double testscore() {
		double scoregen = 0;
		for (Border b : borders) {
			int test1 = states.get(b.index1).color;
			int test2 = states.get(b.index2).color;
			
			if(test1 == test2) {
				scoregen++;
			}
			
		}
		return scoregen;
		}
	
	public void randomizeall() {
		for(State s: states) {
			s.reproduce();		
		}
	}
	
	
	public double SimAC3()   {
	//search all borders that violate the constraint of different color, and
	// from the domains of these two states, select two new colors that do not 
		//violate the combined domain specifications, and that is the best option
		for (Border b : borders) {
			int test1 = states.get(b.index1).color;
			int test2 = states.get(b.index2).color;
			State teststate1 = states.get(b.index1);
			State teststate2 = states.get(b.index2);
			if(test1 == test2) {
					//search through domain for the best possible new color options
			//	for(int srch = 0; srch < 4; srch ++)  {
					boolean found = false;
					int srch=0;
					int srch2 = 0;
					while(!found) {
						srch =  (int)(Math.random() * 4);
						srch2 =  (int)(Math.random() * 4);
					//	for(int srch2 = 0; srch2 < 4; srch2 ++)  {
							if(teststate2.domain[srch] == 1 && teststate2.domain[srch2] == 1 && srch!=srch2)
							 {//valid domain for both border 1 & 2

							 for(State ST : teststate1.ConnectedStates) {
								//	
									//if(scoretest<bestscore)
								//	{
									ST.domain[srch] = 0;
									ST.domain[test1] = 1;
									teststate1.domain[test1] = 1;
									teststate1.domain[srch] = 2;
									teststate1.setcol(srch);
									found = true;
								}
							 }
							 for(State ST : teststate2.ConnectedStates) {
									ST.domain[srch2] = 0;
									ST.domain[test2] = 1;
									teststate2.domain[test2] = 1;
									teststate2.domain[srch2] = 2;
									found = true;
									teststate2.setcol(srch2);

									//break;
								}
						//}
						 if(found) {
							 double scoretest = testscore();
							 score = scoretest;
						//	 System.out.print("\n");
					    } 
							
					}
				}
			}
		
		return score;
		}
		
		
		
	
	
	public  double minconflict() {
		int testc1, testc2,ORIG1, ORIG2;
		int best1 =0 ;int best2=0;
		double bestscore = score;
		double scoretest = 0;
		double origscore = score;
		
		for (Border b : borders) {
			int test1 = states.get(b.index1).color;
			int test2 = states.get(b.index2).color;
			State teststate1 = states.get(b.index1);
			State teststate2 = states.get(b.index2);
			
			if(test1 == test2) {
				ORIG1 =  states.get(b.index1).color;
				ORIG2 =  states.get(b.index2).color;
				for(int j = 0 ; j<4; j++)  {
					teststate1.setcol(j);
	
					for(int k = 0 ; k<4; k++)  {
						teststate2.setcol(k);
						//testc2 = (int)(Math.random() * 4);
						scoretest = testscore();
						if(scoretest<bestscore)
						{
							bestscore = scoretest;
							best1 = j;
							best2 = k;
						}
					}
			}
				//iff no change, no better solution, randomize
				if(ORIG1==best1 && ORIG2 == best2) {
					teststate1.reproduce();
					teststate2.reproduce();
				}else {
					
				teststate1.setcol(best1);
				teststate2.setcol(best2);
				score = bestscore;//testscore();
				}
		}
	  }
		return score;

	}
	
	
	public  double Backtracking()	{
	 for(int j = 0 ; j<2;j++){
		double newscore = 0;
		double fitscore =0;
		for (Border b : borders) {
			int test1 = states.get(b.index1).color;
			int test2 = states.get(b.index2).color;
			
			if(test1 == test2){
				fitscore++;
				states.get(b.index1).reproduce();
				states.get(b.index2).reproduce();
			}
		}
		for (Border b : borders) {
			int test1 = states.get(b.index1).color;
			int test2 = states.get(b.index2).color;
			
			if(test1 == test2){
				newscore++;
			}
		}
		
		if(newscore<=fitscore || newscore ==0) {
			score = fitscore;
			return score;

		}
		else {
			if(j==2) {
				return score;
			}
			for(State s: states) {
				s.revert();		
			}

		}
  	  }  
	 return score;

	}
	
	
	public void generateDomains()   {
		for(State s: states) {
			
			 for(State ST : s.ConnectedStates) {
				 
				 s.subfromDomain(ST.color);
			
			 }
			 s.domain[s.color] = 2;
		}
	}
	
	public void print()	{
		for (Border b : borders) {
		//System.out.print(	"Border : ");
		states.get(b.index1).print();
		System.out.print("DOMAINS: ");
		System.out.print(states.get(b.index1).domain[0]);
		System.out.print(states.get(b.index1).domain[1]);
		System.out.print(states.get(b.index1).domain[2]);
		System.out.print(states.get(b.index1).domain[3]);
		System.out.print("\n");

		System.out.print("Borders: ");
			states.get(b.index2).print();
			System.out.print("DOMAINS: ");
			System.out.print(states.get(b.index2).domain[0]);
			System.out.print(states.get(b.index2).domain[1]);
			System.out.print(states.get(b.index2).domain[2]);
			System.out.print(states.get(b.index2).domain[3]);
			System.out.print("\n");

				
		}
		
	}
	

	
	public double ForwardChecking() {
		int testc1, testc2,ORIG1, ORIG2;
		int best1 =0 ;int best2=0;
		double bestscore = score;
		double scoretest = 0;
		double origscore = score;
		double OriginalScore = 0.0;
		for (Border b : borders) {
			 OriginalScore = testscore();
			int test1 = states.get(b.index1).color;
			int test2 = states.get(b.index2).color;
			State teststate1 = states.get(b.index1);
			State teststate2 = states.get(b.index2);
			
			if(test1 == test2) {
				ORIG1 =  states.get(b.index1).color;
				ORIG2 =  states.get(b.index2).color;
				//for(int j = 0 ; j<4; j++)  {
				int j = (int)(Math.random() * 4);
					teststate1.setcol(j);
		
					int k = (int)(Math.random() * 4);
					while(k==j) {
						 k = (int)(Math.random() * 4);
					}
					//	teststate2.setcol(k);
						//testc2 = (int)(Math.random() * 4);
						scoretest = testscore();
						if(scoretest<bestscore)
						{
							
							for(State s: teststate1.ConnectedStates) {
								if(s.color == j)  {
									int newcol = (int)(Math.random() * 4);
									while(newcol==j) {
										newcol = (int)(Math.random() * 4);
									}
									s.setcol(newcol);
									for(State snext: s.ConnectedStates)  {
										if(s.color == snext.color)  {
											int newcol2 = (int)(Math.random() * 4);
											while(newcol2==j) {
												newcol2 = (int)(Math.random() * 4);
											}
											snext.setcol(newcol2);
									}
								}
							  }
							}
						
							for(State s2: teststate2.ConnectedStates) {
								if(s2.color == k)  {
									
									int newcol3 = (int)(Math.random() * 4);
									while(newcol3==j) {
										newcol3 = (int)(Math.random() * 4);
									}
									s2.setcol(newcol3);
									for(State snext2: s2.ConnectedStates)  {
										if(s2.color == snext2.color)  {
											int newcol4 = (int)(Math.random() * 4);
											while(newcol4==j) {
												newcol4 = (int)(Math.random() * 4);
											}
											snext2.setcol(newcol4);

									}
								}
							}
								
						//	return scoretest;
						}
							scoretest = testscore();

					}
						if(ORIG1==best1 && ORIG2 == best2) {
							teststate1.reproduce();
							teststate2.reproduce();
						}

			}
			
			
	
	}

		score = testscore();
		return score;
	}
	
	
	
	
	
	public Map() {
		borders = new Vector<Border>();
		states = new Vector<State>();
	}
}
