package afds.model;

public class LocationEntry {

	Integer seatId, sectionNo, rowNo, seatNo;

	public LocationEntry(Integer seatId, Integer sectionNo, Integer rowNo,
			Integer seatNo) {
		this.seatId = seatId;
		this.sectionNo = sectionNo;
		this.rowNo = rowNo;
		this.seatNo = seatNo;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public Integer getSeatId() {
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

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

}
