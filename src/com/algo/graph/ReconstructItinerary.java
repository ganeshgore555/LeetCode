package com.algo.graph;

import java.util.*;

public class ReconstructItinerary {

	public static void main(String[] args) {
		//String[][] ticketArr = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
		String[][] ticketArr = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		List<List<String>> tickets = new ArrayList<>();
		for(String[] ticket : ticketArr) {
			List<String> temp = new ArrayList<>();
			temp.add(ticket[0]);
			temp.add(ticket[1]);
			tickets.add(temp);
		}
		new ReconstructItinerary().findItinerary(tickets).stream().forEach(System.out::println);

	}

	  // origin -> list of destinations
	  HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
	  LinkedList<String> result = null;

	  public List<String> findItinerary(List<List<String>> tickets) {
	    // Step 1). build the graph first
	    for(List<String> ticket : tickets) {
	      String origin = ticket.get(0);
	      String dest = ticket.get(1);
	      flightMap.computeIfAbsent(origin,d -> new LinkedList()).add(dest);
	    }

	    // Step 2). order the destinations
	    this.flightMap.forEach((key, value) -> Collections.sort(value));

	    this.result = new LinkedList<String>();
	    // Step 3). post-order DFS
	    this.DFS("JFK");
	    return this.result;
	  }

	  protected void DFS(String origin) {
	    // Visit all the outgoing edges first.
	    if (this.flightMap.containsKey(origin)) {
	      LinkedList<String> destList = this.flightMap.get(origin);
	      while (!destList.isEmpty()) {
	        // while we visit the edge, we trim it off from graph.
	        String dest = destList.pollFirst();
	        DFS(dest);
	      }
	    }
	    // add the airport to the head of the itinerary
	    this.result.offerFirst(origin);
	  }
}
