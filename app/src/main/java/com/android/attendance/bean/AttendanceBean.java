package com.android.attendance.bean;

public class AttendanceBean {

	private int attendance_session_id;
	private int attendance_student_id;
	private String attendance_status;
	private String attendance_subject;

	public String getAttendance_subject() {
		return attendance_subject;
	}

	public void setAttendance_subject(String attendance_subject) {
		this.attendance_subject = attendance_subject;
	}

	public int getAttendance_session_id() {
		return attendance_session_id;
	}
	public void setAttendance_session_id(int attendance_session_id) {
		this.attendance_session_id = attendance_session_id;
	}
	public int getAttendance_student_id() {
		return attendance_student_id;
	}
	public void setAttendance_student_id(int attendance_student_id) {
		this.attendance_student_id = attendance_student_id;
	}
	public String getAttendance_status() {
		return attendance_status;
	}
	public void setAttendance_status(String attendance_status) {
		this.attendance_status = attendance_status;
	}
	
	
	
}
