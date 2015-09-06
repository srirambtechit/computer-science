package com.algorithms.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Oracle Interview: A media player selects songs from a database contains huge
 * number of songs. Create a shuffle function such that it selects a song
 * randomly but it does not repeat the songs. You can assume random function
 * rand() is available
 * 
 * @author sriram
 *
 */
public class MusicPlayer {

    public static void main(String[] args) {
	MusicPlayer mp = new MusicPlayer();
	List<Integer> trackList = mp.getTrackList();
	if (trackList != null) {
	    while (!trackList.isEmpty()) {
		int track = mp.shuffleAndGetTrack(trackList);
		mp.play(track);
	    }
	}
    }

    public List<Integer> getTrackList() {
	List<Integer> trackList = new ArrayList<>();
	for (int i = 1; i < 20; i++) {
	    trackList.add(i);
	}
	return trackList;
    }

    public Integer shuffleAndGetTrack(List<Integer> list) {
	int randomIndex = new Random().nextInt(list.size());
	return list.remove(randomIndex);
    }

    public void play(int trackNumber) {
	System.out.println("Playing track #" + trackNumber);
    }

}
