package com.example.smartevent.dto;

import lombok.Data;

@Data
public class TestEmailRequest {

    private String to;
    private String templateName; // without .html
    private Placeholder[] placeholders;

    

    // Converts to the format EmailService expects (String[][])
    public String[][] getPlaceholdersArray() {
        if (placeholders == null) return new String[0][0];

        String[][] arr = new String[placeholders.length][2];
        for (int i = 0; i < placeholders.length; i++) {
            arr[i][0] = "{{" + placeholders[i].getKey() + "}}";
            arr[i][1] = placeholders[i].getValue();
        }
        return arr;
    }



	public String getTo() {
		return to;
	}



	public void setTo(String to) {
		this.to = to;
	}



	public String getTemplateName() {
		return templateName;
	}



	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}



	public Placeholder[] getPlaceholders() {
		return placeholders;
	}



	public void setPlaceholders(Placeholder[] placeholders) {
		this.placeholders = placeholders;
	}
}
