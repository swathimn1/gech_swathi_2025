package com.example.smartevent.dto;

public class AdminQueryResponse {
    private Long id;
    private String visitorName;
    private String stallName;
    private String message;
    private String reply;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getStallName() {
		return stallName;
	}
	public void setStallName(String stallName) {
		this.stallName = stallName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public AdminQueryResponse(Long id, String visitorName, String stallName, String message, String reply) {
		super();
		this.id = id;
		this.visitorName = visitorName;
		this.stallName = stallName;
		this.message = message;
		this.reply = reply;
	}
	public AdminQueryResponse() {
		super();
	}
    
}
