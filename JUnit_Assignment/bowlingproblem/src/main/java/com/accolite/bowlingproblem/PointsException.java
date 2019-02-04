package com.accolite.bowlingproblem;
/*
 *  Created by : Madhukar Domakonda
 */
public class PointsException extends Exception {
	String exceptionMsg;
	PointsException(String exceptionMsg){
		super(exceptionMsg);
		this.exceptionMsg=exceptionMsg;
	}
	@Override
	public String toString() {
		return "PointsException [exceptionMsg=" + exceptionMsg + "]";
	}
}
