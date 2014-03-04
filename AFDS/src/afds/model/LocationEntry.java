package afds.model;

public class LocationEntry {

	long seatId;
	Integer sectionNo, rowNo;
	char seat;
	int kitchen;

	public LocationEntry(Integer sectionNo, Integer rowNo,
			String seatNo) {
		this.sectionNo = sectionNo;
		this.rowNo = rowNo;
		this.seat = seatNo.charAt(0);
		
	}

	public LocationEntry() {}

	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}

	public long getSeatId() {
		return seatId;
	}

	public void setSectionNo(Integer sectionNo) {
		this.sectionNo = sectionNo;
	}

	public Integer getSectionNo() {
		return sectionNo;
	}

	public void setRowNo(Integer rowNo) {
		this.rowNo = rowNo;
	}

	public Integer getRowNo() {
		return rowNo;
	}

	public void setSeat(char seat) {
		this.seat = seat;
	}

	public char getSeat() {
		return seat;
	}

	public int getKitchen() {
		return kitchen;
	}

	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}
	


}
