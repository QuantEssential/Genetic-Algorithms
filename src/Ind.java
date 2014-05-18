
public class Ind {
			private Map map; // the map
			private double fitness; // fitness is cached and only updated on request whenever necessary
			// TODO some representation of the genom of the individual

			/**
			 * Updates the fitness value based on the genom and the map.
			 */
			public void updateFitness(int f) {
				// TODO implement fitness function
				fitness = f;
			}

			/**
			 * Default ctor. Creates a (valid) random individual.
			 * @param map The US states map.
			 */
			public Ind(Map mapn, int f) {
			this.map = map;
			
			// TODO implement random generation of an individual

			updateFitness(f);				
		}

			/**
			 * Reproduces a child randomly from two individuals (see textbook).
			 * @param x The first parent.
			 * @param y The second parent.
			 * @return The child created from the two individuals.
			 */
		
			/**
			 * Returns the current fitness value of the individual.
			 * @return The current fitness value.
			 */
			public double getFitness() {
				return fitness;
			}

			/**
			 * Randomly mutates the individual.
		
			/**
			 * Checks whether the individual represents a valid goal state.
			 * @return Whether the individual represents a valid goal state.
			 */
			public boolean isGoal() {
				return fitness == map.borders.size();
			}
			
			/**
			 * Prints out the individual to the console.
			 */
			void print() {
				// TODO implement printing the individual in the following format:
				// fitness: 15
				// North Carolina: 0
				// South Carolina: 2
				// ...
	}
}
