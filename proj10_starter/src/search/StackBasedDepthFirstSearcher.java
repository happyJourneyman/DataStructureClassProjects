package search;

import java.util.List;
import java.util.*; 

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Stack. This results in a
 * depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {
	
	public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
	}

	@Override
	public List<T> solve() {
		// TODO
		if (solution != null) {
			return solution;
		}

		Stack<T> path = new Stack<T>();	
		Stack<T> p = depthFirstSearcher(path);
		if (path.size() > 0) {
			if (!isValid(path)) {
				throw new RuntimeException(
						"searcher should never find an invalid solution!");
			}
		}
		return p;
	}

	private Stack<T> depthFirstSearcher(Stack<T> path) {
		ArrayList<T> vs = new ArrayList<T>(); 
		Stack<T> stack = new Stack<T>();
		stack.push(searchProblem.getInitialState());
		vs.add(searchProblem.getInitialState());
		T b = null;
		while(!stack.isEmpty()){
 			
 			b = getNextUnvisitedNeighbor(stack.peek(), vs);
 			if (searchProblem.isGoalState(b)) break;
 			if (b==null) stack.pop(); // no unvisited neighbor
 			else {
 				vs.add(b); stack.push(b);
 			}
 		}
 		if(searchProblem.isGoalState(b)) return stack;
 else return null;

	}

	private T getNextUnvisitedNeighbor(T elem, ArrayList<T> vs) {
		 
		T newNode = null; 
			for (int i = 0; i < vs.size(); i++) {
				if (!visitedStates.contains(vs.get(i))) {
					newNode = vs.get(i);
				}
				}
				
		return newNode;
	}


}
