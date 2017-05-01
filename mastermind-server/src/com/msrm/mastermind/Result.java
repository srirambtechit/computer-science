package com.msrm.mastermind;

public class Result {
	private int points;
	private int valueCount;
	private int positionAndValueCount;

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getValueCount() {
		return valueCount;
	}

	public void setValueCount(int valueCount) {
		this.valueCount = valueCount;
	}

	public int getPositionAndValueCount() {
		return positionAndValueCount;
	}

	public void setPositionAndValueCount(int positionAndValueCount) {
		this.positionAndValueCount = positionAndValueCount;
	}

	@Override
	public String toString() {
		return "Result [points=" + points + ", valueCount=" + valueCount + ", positionAndValueCount="
				+ positionAndValueCount + "]";
	}

}
