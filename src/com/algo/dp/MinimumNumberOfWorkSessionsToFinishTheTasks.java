package com.algo.dp;

import java.util.Arrays;

public class MinimumNumberOfWorkSessionsToFinishTheTasks {

	public static void main(String[] args) {
		int[] tasks = {1,2,3}; 
		int sessionTime = 3;
		System.out.println(new MinimumNumberOfWorkSessionsToFinishTheTasks().minSessions(tasks, sessionTime));
	}

    int res;
    int maxSessionTime;
    int[] tasks;
    int[] sessions;
    public int minSessions(int[] tasks, int sessionTime) {
	    Arrays.sort(tasks);
        this.res = tasks.length;
        this.maxSessionTime = sessionTime;
        this.tasks = tasks;
        this.sessions = new int[tasks.length];
        dfs(tasks.length - 1, 0);
        return res;
    }
    
    private void dfs(int taskID, int sessionNo) {
        if (sessionNo > res) return; //prune, if we didn't use prune, it will be 2200ms, if lucky you get ac
        if (taskID == -1) {
            res = Math.min(res, sessionNo);
            return;
        }
        for (int i = 0; i < sessionNo; i++)
            if (sessions[i] + tasks[taskID] <= maxSessionTime) { //put task into old session bucket
                sessions[i] += tasks[taskID];
                dfs(taskID - 1, sessionNo);
                sessions[i] -= tasks[taskID];
            }
        sessions[sessionNo] += tasks[taskID]; //put task into new empty session bucket
        dfs(taskID - 1, sessionNo + 1);
        sessions[sessionNo] -= tasks[taskID];
    }
}
