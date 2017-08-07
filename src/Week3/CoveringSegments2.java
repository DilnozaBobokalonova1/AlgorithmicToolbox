package Week3;

import java.util.Scanner;

import org.apache.commons.lang3.*;

public class CoveringSegments2 {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
    	int count = 0;
    	 Segment[] mySortedSegments = new Segment[segments.length];
      while(segments.length > 0) {   
        int minEnd = segments[0].end; //the minimum end is assumed to be in the first set
        Segment segmentsSorted = new Segment(0,0);
        segmentsSorted.end = segments[0].end;
		segmentsSorted.start = segments[0].start;
		int index = 0;
        for(int i = 1; i < segments.length; i++) {
        	if(minEnd > segments[i].end) {
        		minEnd = segments[i].end;
        		segmentsSorted.end = segments[i].end;
        		segmentsSorted.start = segments[i].start;
        		index = i; //to know which segment was the least one
        		
        	}
        }
        segments = ArrayUtils.removeElement(segments, segments[index]);//once the min set was found, we remove it from the original segments
        mySortedSegments[count] = new Segment(segmentsSorted.start, segmentsSorted.end); //move the elements in sorted order into an array of segments
       	count++;
        
      }
       int[] points = new int[mySortedSegments.length];
       int count2 = 0;
       for(int i = 0; i < mySortedSegments.length - 1; i++) {
    	   if(mySortedSegments[i].end >= mySortedSegments[i+1].start && mySortedSegments[i].point == -1) { //if the sets intersect
    		   mySortedSegments[i+1].point = mySortedSegments[i].end;
			   mySortedSegments[i].point = mySortedSegments[i].end;
			   points[count2] = mySortedSegments[i].end;
			   count2++; 
    	   } else if(mySortedSegments[i].point >= mySortedSegments[i+1].start) {
    		   mySortedSegments[i+1].point = mySortedSegments[i].point;
    	   } else {
    		   mySortedSegments[i+1].point = mySortedSegments[i].end;
    		   points[count2] = mySortedSegments[i+1].point;
    		   count2++;
    	   }
    		   /*
    		   if(mySortedSegments[i].marked != true) { //if the first one was already joined to the segment before, we dont wanna add new point to points so we mark it as marked
    			   mySortedSegments[i+1].marked = true;
    			   mySortedSegments[i].marked = true;
    			   points[count2] = mySortedSegments[i].end;
    			   count2++;
    		   }
    		   else {
    			   mySortedSegments[i+1].marked = true;
    		   }
    	   }*/
       /*
    	   else {
    		   if(mySortedSegments[i].marked != true) {
    			   points[count2] = mySortedSegments[i].end;
    			   mySortedSegments[i].marked = true;
    			   count2++;
    			   
    		   }
    		   else {
    			   mySortedSegments[i+1].marked = true;
    			   points[count2] = mySortedSegments[i+1].end;
    			   count2++;
    		   }
    	   }*/
       }
       
        return points;
        
    }

    private static class Segment {
        int start, end;
        boolean marked = false;
        int point = -1;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
        	if(point != 0) {
        		System.out.print(point + " ");
        	}
        }
        
    }
}
/*
int[] markedPoints = new int[2*segments.length];
int counter = 0;
for(int i = 1; i < segments.length; i++) {
	if((minEnd >= segments[i].start) && (minEnd <= segments[i].end)) {
		markedPoints[counter] = minEnd;
		counter++;
		segments[i].start = (Integer) null;
		segments[i].end = (Integer) null;
		
	}
	
}

for(int i = 0; i < markedPoints.length; i++){
	
	
}
*/

