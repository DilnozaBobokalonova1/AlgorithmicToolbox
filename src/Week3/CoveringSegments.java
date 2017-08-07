package Week3;
//this ran in 0.25/1.50 seconds---- amazing!!
import java.util.Scanner;

//import org.apache.commons.lang3.*; //used this at first to fully remove the segment element and shrink the array but it was not acceptible on coursera

public class CoveringSegments {
	static int count2 = 0;
    private static int[] optimalPoints(Segment[] segments) {
    	int count = 0;
    	 Segment[] mySortedSegments = new Segment[segments.length];
    	 int size = segments.length;
      while(count < segments.length) {   
        int minEnd = segments[0].end; //the minimum end is assumed to be in the first set
        Segment segmentsSorted = new Segment(segments[0].start, segments[0].end);
		int index = 0;
        for(int i = 1; i < size; i++) {
        	if(minEnd > segments[i].end ) {
        		minEnd = segments[i].end;
        		segmentsSorted.end = segments[i].end;
        		segmentsSorted.start = segments[i].start;
        		index = i; //to know which segment was the least one
        		
        	} else if(minEnd == segments[i].end && (segments[index].start > segments[i].start)) {
        		
        		segmentsSorted.end = segments[i].end;
        		segmentsSorted.start = segments[i].start;
        		index = i;
        	}
        }
      //  segments = ArrayUtils.removeElement(segments, segments[index]);//once the min set was found, we remove it from the original segments
        //note: the above gave an error when submitting on coursera because the library was assumed to not be used, so the alternate solution is written below
       if(index <= size - 1){
    	   for(int i = index; i < size - 1; i++) {
    		   segments[i] = segments[i+1];
    		   segments[i+1] = null;
    	   }
    	   size--;
       } 
        mySortedSegments[count] = new Segment(segmentsSorted.start, segmentsSorted.end); //move the elements in sorted order into an array of segments
       	count++;    
      }
       int[] points = new int[mySortedSegments.length];
       for(int i = 0; i < mySortedSegments.length - 1; i++) {
    	   if(mySortedSegments[i].end >= mySortedSegments[i+1].start && mySortedSegments[i].point == -1) { //if the sets intersect
    		   mySortedSegments[i+1].point = mySortedSegments[i].end;
			   mySortedSegments[i].point = mySortedSegments[i].end;
			   points[count2] = mySortedSegments[i].end;
			   count2++; 
    	   } else if(mySortedSegments[i].end < mySortedSegments[i+1].start && mySortedSegments[i].point == -1) {/*
    	    the above is to make sure i includes the points such as of segments [0 1] [2 3] */
    		   mySortedSegments[i].point = mySortedSegments[i].end;
    		   points[count2] = mySortedSegments[i].point;
    		   count2++;
    		   mySortedSegments[i+1].point = mySortedSegments[i+1].end;
    		   points[count2] = mySortedSegments[i+1].point;
    		   count2++;
    	   } else if(mySortedSegments[i].point >= mySortedSegments[i+1].start) { //for the case when the segment was already marked with a point
    		   mySortedSegments[i+1].point = mySortedSegments[i].point;
    	   } else {
    		   mySortedSegments[i+1].point = mySortedSegments[i+1].end;
    		   points[count2] = mySortedSegments[i+1].point;
    		   count2++;
    	   }
       }
       int[] points2 = new int[count2];
       for(int i = 0; i < count2; i++) {
    	  
    		   points2[i] = points[i];
    	   
       }
        return points2;
        
    }

    private static class Segment {
        int start, end;
        int point = -1; //i added this field myself to make it easier to keep track of what was already marked

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
        	System.out.print(point + " ");
        }
        
    }
}

