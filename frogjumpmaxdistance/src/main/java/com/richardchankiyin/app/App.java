package com.richardchankiyin.app;

import java.util.ArrayList;
import java.util.List;

/**
 * App
 *
 */
public class App 
{
	public static void main(String[] args) {
		App app = new App();
		System.out.println(app.solution(new int[]{10,9,6,7,8}));
	}
	
	
	
    public int solution(int[] block) {
    	int length = block.length;
    	int prevDirection = 1;
    	List<Peak> peaks = new ArrayList<Peak>();
    	Peak currentPeak = null;
    	int maxdist = -1;
    	for (int i = 0; i <= length; i++) {
    		int direction = checkMovingDirection(block, i);
    		System.out.println("position:" + i + " prevDirection: " + prevDirection + " direction:" + direction);
    		if (prevDirection != direction) {
    			// turning point detected, only going down direction can confirm peak
    			if (direction == -1) {
    				int noofPeaks = peaks.size();
    				Peak prevPeak = noofPeaks == 0 ? null : peaks.get(noofPeaks - 1);
    				if (currentPeak == null) {
    					currentPeak = new Peak(i-1,i-1);
    				} else {
    					currentPeak.setEnd(i-1);
    					
    				}
    				int dist = calculateDiffBtwTwoPeaks(prevPeak,currentPeak,length);
    				System.out.println("dist: " + dist + " from peaks[" + prevPeak + "|" + currentPeak + "]");
    				if (dist > maxdist) {
    					maxdist = dist;
    				}
    				peaks.add(currentPeak);
    				currentPeak = null;
    			} else if (direction == 0) {
    				// not confirmed
    				currentPeak = new Peak(i-1,i-1);
    			} else {
    				currentPeak = null;
    			}
    		}
    		
    		prevDirection = direction;
    		System.out.println("peaks: " + peaks);
    	}
    	
    	return maxdist;
    }
    
    public int calculateDiffBtwTwoPeaks(Peak first, Peak second, int lastpos) {
    	if (first == null) {
    		return second.getEnd();
    	}
    	else if (second == null) {
    		return lastpos - first.getStart();
    	} else {
    		return second.getEnd() - first.getStart();
    	}
    }
    
    /**
     * return 1 if go up
     * return -1 if go down
     * return 1 if current == 0
     * return -1 if current == length - 1
     * 
     * @param block
     * @param current
     * @throws IllegalStateException
     * @return
     */
    public int checkMovingDirection(int[] block, int current) {
    	int length = block.length;
    	if (current > 0 && current < length) {
    		if (block[current] > block[current - 1]) {
    			return 1;
    		} else if (block[current] < block[current - 1]) {
    			return -1;
    		} else {
    			return 0;
    		}
    	} else {
    		if (current == 0) {
    			return 1;
    		} else if (current == length) {
    			return -1;
    		} else {
    			throw new IllegalStateException("current=" + current + " violates block size=" + block.length);
    		}
    	}
    }
}

class Peak {
	private int start = 0;
	private int end = 0;
	Peak(int _start, int _end) {
		start = _start;
		end = _end;
	}
	public int getStart() { return start; }
	public int getEnd() { return end; }
	public void setEnd(int _end) { end = _end; }
	public String toString() { return "Peak(" + start + "," + end + ")"; }
}
