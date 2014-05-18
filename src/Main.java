import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	
	 public static ArrayList<Ind> alist;
	 public static Map map1;
	 public static Map newmap;

	static void initMap(Map map)
	{
		
		int randcolor = 0;
		
		map.states.add(new State("North Carolina"));
		map.states.add(new State("South Carolina"));
		map.states.add(new State("Virginia"));
		map.states.add(new State("Tennessee"));
		map.states.add(new State("Kentucky"));
		map.states.add(new State("West Virginia"));
		map.states.add(new State("Georgia"));
		map.states.add(new State("Alabama"));
		map.states.add(new State("Mississippi"));
		map.states.add(new State("Florida"));

		map.borders.add(new Border(0, 1,map.states.get(0),map.states.get(1)));
		map.borders.add(new Border(0, 2,map.states.get(0),map.states.get(2)));
		map.borders.add(new Border(0, 3,map.states.get(0),map.states.get(3)));
		map.borders.add(new Border(0, 6,map.states.get(0),map.states.get(6)));
		map.borders.add(new Border(1, 6,map.states.get(1),map.states.get(6)));
		map.borders.add(new Border(2, 3,map.states.get(2),map.states.get(3)));
		map.borders.add(new Border(2, 4,map.states.get(2),map.states.get(4)));
		map.borders.add(new Border(2, 5,map.states.get(2),map.states.get(5)));
		map.borders.add(new Border(3, 4,map.states.get(3),map.states.get(4)));
		map.borders.add(new Border(3, 6,map.states.get(3),map.states.get(6)));
		map.borders.add(new Border(3, 7,map.states.get(3),map.states.get(7)));
		map.borders.add(new Border(3, 8,map.states.get(3),map.states.get(8)));
		map.borders.add(new Border(4, 5,map.states.get(4),map.states.get(5)));
		map.borders.add(new Border(6, 7,map.states.get(6),map.states.get(7)));
		map.borders.add(new Border(6, 9,map.states.get(6),map.states.get(9)));
		map.borders.add(new Border(7, 8,map.states.get(7),map.states.get(8)));
		map.borders.add(new Border(7, 9,map.states.get(7),map.states.get(9)));
		map.generateDomains();
	}
	
	/**
	 * @param args
	 */
	

	public static void ForwardCheck(Map map)	{
		
		 
		final int populationSize = 100; // TODO find reasonable value

		double result = 0;
		final int maxIterations = 100; // TODO find reasonable value
		int currentIteration = 0;
		boolean goalFound = false;

		while(currentIteration < maxIterations && goalFound==false)
		{
			Map mapold = new Map();

		
			result = map.ForwardChecking();

		//	System.out.print("Result# " + Integer.toString(currentIteration) + " : " +result);

				//alist.add(new Ind(map, (int)result));
			if(result == 0)
				{goalFound = true;	}
		
			++currentIteration;
		if(currentIteration>maxIterations) {
			System.out.println("MaX ItErAtIoN ReaCHed"); break;
		}

	}

		if(goalFound)
		{
			
			System.out.printf("Found a solution after %d iterations\n", currentIteration);
			//System.out.print("\n");
			map.runtime = currentIteration;
			//map.print();
			//bestInd.print();
		}
		else
		{
			System.out.printf("Did not find a solution after %d iterations\n", currentIteration);
		}
		
	}
	
	
	public static void SimulateBackTracking(Map map) {
	//	 alist = new ArrayList<Ind>();
		 
		final int populationSize = 100; // TODO find reasonable value

		double result = 0;
		final int maxIterations = 100; // TODO find reasonable value
		int currentIteration = 0;
		boolean goalFound = false;
		Ind bestInd;// = new Ind(map); // to hold the Ind representing the goal, if any
		//Map oldmap = new Map();

		while(currentIteration < maxIterations && goalFound==false)
		{
			Map mapold = new Map();

			mapold.borders = map.borders;
			double oldscore = map.score;
			mapold.states = map.states;				
			result = map.Backtracking();

		//	System.out.print("Result# " + Integer.toString(currentIteration) + " : " +result);

				//alist.add(new Ind(map, (int)result));
			if(result == 0)
				{goalFound = true;	}
		
			++currentIteration;
		if(currentIteration>maxIterations) {
			System.out.println("MaX ItErAtIoN ReaCHed"); break;
		}

	}

		if(goalFound)
		{
			System.out.printf("Found a solution after %d iterations\n", currentIteration);
			//System.out.print("\n");
			map.runtime = currentIteration;
			//map.print();
			//bestInd.print();
		}
		else
		{
			System.out.printf("Did not find a solution after %d iterations\n", currentIteration);
		}
}
	
	public static void SimulateAC3(Map map)		{
		final int populationSize = 100; // TODO find reasonable value

		double result = 0;
		final int maxIterations = 100; // TODO find reasonable value
		int currentIteration = 0;
		boolean goalFound = false;
		Ind bestInd;// = new Ind(map); // to hold the Ind representing the goal, if any
		//Map oldmap = new Map();

		while(currentIteration < maxIterations && goalFound==false)
		{
			Map mapold = new Map();
			
			result = map.SimAC3();

			if(result == 0)
			{goalFound = true;	break;	}
	
		++currentIteration;
	if(currentIteration>maxIterations) {
		System.out.println("MaX ItErAtIoN ReaCHed"); break;
	}

}

	if(goalFound)
	{
		System.out.printf("Found a solution after %d iterations\n", currentIteration);
		//System.out.print("\n");
		map.runtime = currentIteration;
		//map.print();
		//bestInd.print();
	}
	else
	{
		System.out.printf("Did not find a solution after %d iterations\n", currentIteration);
	}
	
}
		
	
	public static void SimulateMinCon(Map map)	{
		
		 
		final int populationSize = 100; // TODO find reasonable value

		double result = 0;
		final int maxIterations = 100; // TODO find reasonable value
		int currentIteration = 0;
		boolean goalFound = false;

		while(currentIteration < maxIterations && goalFound==false)
		{
			Map mapold = new Map();

		
			result = map.minconflict();

		//	System.out.print("Result# " + Integer.toString(currentIteration) + " : " +result);

				//alist.add(new Ind(map, (int)result));
			if(result == 0)
				{goalFound = true;	}
		
			++currentIteration;
		if(currentIteration>maxIterations) {
			System.out.println("MaX ItErAtIoN ReaCHed"); break;
		}

	}

		if(goalFound)
		{
			
			System.out.printf("Found a solution after %d iterations\n", currentIteration);
			//System.out.print("\n");
			map.runtime = currentIteration;
			//map.print();
			//bestInd.print();
		}
		else
		{
			System.out.printf("Did not find a solution after %d iterations\n", currentIteration);
		}
		
	}
	
	
	public static void main(String[] args) {
	   long starttime;
		double sumresult = 0;
		long total;
		long endtime;
		/*	 map1 = new Map();
			initMap(map1);
			map1.scoregen();
			simulate(map1);
			*/
		System.out.println("Enter 'B' for Backtracking, 'A' for AC3, 'M' for Min-Conflict, and 'F' for Forward Checking: ");
		String in = "";
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			in = input.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(in.equals("B"))
		{
			starttime = System.currentTimeMillis();
			for(int i = 0; i<10000; i++)
			{
				newmap = new Map();
				initMap(newmap);
				newmap.randomizeall();
				newmap.scoregen();
				SimulateBackTracking(newmap);
				sumresult += newmap.runtime;
			}
				sumresult/=10000;
			 endtime = System.currentTimeMillis();
			 total = endtime-starttime;
			System.out.println("Runtime: "+total+" Milliseconds. AVG Iterations to find solutions: " + sumresult);
			sumresult = 0; 
		}   
		else if (in.equals("M")) {
			starttime = System.currentTimeMillis();
			for(int i = 0; i<10000; i++)
			{	newmap = new Map();
				
				initMap(newmap);
				newmap.randomizeall();
				newmap.scoregen();
				SimulateMinCon(newmap);
				sumresult += newmap.runtime;
			}
			
			sumresult/=10000;
			endtime = System.currentTimeMillis();
			total = endtime-starttime;
			System.out.println("Runtime: "+total+" Milliseconds. AVG function calls to find a solution: " + sumresult);
		}

		else if(in.equals("A")) {
	    starttime = System.currentTimeMillis();

			for(int i = 0; i<10000; i++)
			{
				newmap = new Map();
				initMap(newmap);
				newmap.randomizeall();
				newmap.scoregen();
				SimulateAC3(newmap);
				sumresult += newmap.runtime;

			}	
			sumresult/=10000;
			endtime = System.currentTimeMillis();
			total = endtime-starttime;
			System.out.println("Runtime: "+total+" Milliseconds. AVG function calls to find a solution: " + sumresult);
			
	  }
	
	else if(in.equals("F")) {
	    starttime = System.currentTimeMillis();

			for(int i = 0; i<10000; i++)
			{
				newmap = new Map();
				initMap(newmap);
				newmap.randomizeall();
				newmap.scoregen();
				ForwardCheck(newmap);
				sumresult += newmap.runtime;

			}	
			sumresult/=10000;
			endtime = System.currentTimeMillis();
			total = endtime-starttime;
			System.out.println("Runtime: "+total+" Milliseconds. AVG function calls to find a solution: " + sumresult);
			
	  }
	}
	
}



