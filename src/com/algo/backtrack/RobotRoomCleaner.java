package com.algo.backtrack;

import java.util.*;

public class RobotRoomCleaner {

	interface Robot {
		// Returns true if the cell in front is open and robot moves into the cell.
		// Returns false if the cell in front is blocked and robot stays in the current
		// cell.
		public boolean move();

		// Robot will stay in the same cell after calling turnLeft/turnRight.
		// Each turn will be 90 degrees.
		public void turnLeft();

		public void turnRight();

		// Clean the current cell.
		public void clean();
	}

	class Pair<T1,T2>{
		public Pair(T1 row, T2 col) {
			this.row = row;
			this.col = col;
		}
		T1 row;
		T2 col;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Objects.hash(col, row);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			return Objects.equals(this.col, other.col) && Objects.equals(this.row, other.row);
		}		
	}
	
	// going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
	int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	Set<Pair<Integer, Integer>> visited = new HashSet();
	Robot robot;

	public void goBack() {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}

	public void backtrack(int row, int col, int d) {
		visited.add(new Pair(row, col));
		robot.clean();
		// going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
		for (int i = 0; i < 4; ++i) {
			int newD = (d + i) % 4;
			int newRow = row + directions[newD][0];
			int newCol = col + directions[newD][1];

			if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
				backtrack(newRow, newCol, newD);
				goBack();
			}
			// turn the robot following chosen direction : clockwise
			robot.turnRight();
		}
	}

	public void cleanRoom(Robot robot) {
		this.robot = robot;
		backtrack(0, 0, 0);
	}
}
