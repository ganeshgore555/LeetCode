package com.algo.design;

import java.util.*;

public class VideoSharingPlatform {

	public static void main(String[] args) {
		VideoSharingPlatform obj = new VideoSharingPlatform();
		int param_1 = obj.upload("12313432424546656353543543274327493274873");
		System.out.println(param_1);
		int param_2 = obj.upload("87413432424546345435435276274398756226790");
		System.out.println(param_2);
		obj.remove(param_1);
		String param_3 = obj.watch(param_2, 2, 10);
		System.out.println(param_3);
		obj.like(param_2);
		obj.dislike(param_2);
		obj.dislike(param_2);
		obj.dislike(param_2);
		int[] param_6 = obj.getLikesAndDislikes(param_2);
		System.out.println(param_6[0] + "-" + param_6[1]);
		int param_7 = obj.getViews(param_2);
		System.out.println(param_7);
	}

	int count;
	HashMap<Integer, Video> hm;
	PriorityQueue<Integer> pq;

	public VideoSharingPlatform() {
		count = 0;
		hm = new HashMap<>();
		pq = new PriorityQueue<>();
	}

	public int upload(String video) {
		Video v = new Video(video);
		if (pq.isEmpty()) {
			hm.put(count, v);
			return count++;
		} else {
			int id = pq.remove();
			hm.put(id, v);
			return id;
		}
	}

	public void remove(int videoId) {
		if (hm.containsKey(videoId)) {
			hm.remove(videoId);
			pq.add(videoId);
		}
	}

	public String watch(int videoId, int startMinute, int endMinute) {
		if (hm.containsKey(videoId)) {
			Video v = hm.get(videoId);
			v.views++;
			return v.content.substring(startMinute, Math.min(v.content.length(), endMinute + 1));
		} else
			return "-1";
	}

	public void like(int videoId) {
		if (hm.containsKey(videoId))
			hm.get(videoId).like++;
	}

	public void dislike(int videoId) {
		if (hm.containsKey(videoId))
			hm.get(videoId).dislike++;
	}

	public int[] getLikesAndDislikes(int videoId) {
		if (hm.containsKey(videoId)) {
			Video v = hm.get(videoId);
			return new int[] { v.like, v.dislike };
		} else
			return new int[] { -1 };
	}

	public int getViews(int videoId) {
		if (hm.containsKey(videoId))
			return hm.get(videoId).views;
		else
			return -1;
	}

	class Video {
		String content;
		int like;
		int dislike;
		int views;

		public Video(String content) {
			this.content = content;
		}
	}
}
