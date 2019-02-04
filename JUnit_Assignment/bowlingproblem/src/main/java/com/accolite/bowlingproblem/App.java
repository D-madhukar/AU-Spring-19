package com.accolite.bowlingproblem;
/*
 *  Created by : Madhukar Domakonda
 */


public class App 
{
    public static void main( String[] args )
    {
     
    }
    public static int getBowlingScore(int[] points){
    	
    	try {
	    	//Handling Border-cases
    		if(points.length<10 || points.length>22)
    			throw new PointsException("Invalid Number of Points !");
	    	for(int i=0;i<points.length;i++) {
	    		if(points[i]<0 || points[i]>10)
	    			throw new PointsException("Invalid points.!");
	    	}
	    	
	    	int frameCount=0,i=0;
	    	int finalScore=0;
	    	for(;frameCount<10;frameCount++) {
	    		if(i>points.length)
	    			throw new PointsException("Invalid Number of Points");
	    		if(points[i]==10) {
	    			finalScore+=10+points[i+1]+points[i+2];
	    			if(frameCount==9) {
	    				i+=2;
	    			}
	    			i++;
	    		}
	    		else {
	    			if(points[i]+points[i+1]==10) {
	    				finalScore+=10+points[i+2];
	    				if(frameCount==9)
	    					i++;
	    			}
	    			else if(points[i]+points[i+1]<10) {
	    				finalScore+=points[i]+points[i+1];
	    			}
	    			else
	    				throw new PointsException("Invalid Sum !");
	    			i=i+2;
	    		}
	    	}
	    	if(i!=points.length)
	    		throw new PointsException("Invalid number of Points");
	    	return finalScore;
    	}
    	catch(PointsException pe) {
    		System.out.println(pe);
    	}
    	return 0;
    }
}
