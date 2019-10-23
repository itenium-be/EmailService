package be.itenium.EmailService;

import java.io.File;
import java.util.List;
import java.util.Map;

public class IteniumEmail
{
    private Map<String,String> to;
    private Map<String,String> cc;
    private Map<String,String> bcc;
    private String subject;
    private String html;
    private List<File> attachments;

    public Map<String, String> getTo() {
        return to;
    }

    public void setTo(Map<String, String> to) {
        this.to = to;
    }

    public Map<String, String> getCc() {
        return cc;
    }

    public void setCc(Map<String, String> cc) {
        this.cc = cc;
    }

    public Map<String, String> getBcc() {
        return bcc;
    }

    public void setBcc(Map<String, String> bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }
}
