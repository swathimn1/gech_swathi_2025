package com.example.smartevent.dto;

import java.util.List;

public class EmailRequest {
    private String to;
    private String templateName; // without .html
    private List<Placeholder> placeholders;

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public List<Placeholder> getPlaceholders() { return placeholders; }
    public void setPlaceholders(List<Placeholder> placeholders) { this.placeholders = placeholders; }
}
