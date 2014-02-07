package model;

public class SeatLocation {
	private long seatID;
	private int sectionNumber;
	private int rowNumber;
	private int seatNumber;
	
	public SeatLocation (long seatID, int sectionNumber, int rowNumber, int seatNumber){
		this.seatID = seatID;
		this.sectionNumber = sectionNumber;
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
	}

	public long getSeatID() {
		return seatID;
	}

	public void setSeatID(long seatID) {
		this.seatID = seatID;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
}
