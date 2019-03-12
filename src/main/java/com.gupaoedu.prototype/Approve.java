package com.gupaoedu.prototype;

import java.io.*;
import java.util.List;

/**
 * 审批实体类
 */
public class Approve implements Serializable {
    private Long id;
    /**审批人*/
    private String auditor;
    /**审批意见*/
    private String opinions;
    /**审批件*/
    private List<Attachment> attachments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getOpinions() {
        return opinions;
    }

    public void setOpinions(String opinions) {
        this.opinions = opinions;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public Approve() {
    }

    public Approve(Long id, String auditor, String opinions, List<Attachment> attachments) {
        this.id = id;
        this.auditor = auditor;
        this.opinions = opinions;
        this.attachments = attachments;
    }

    /**
     * 深度克隆
     * @return
     */
    public Approve deepClone(){
        Approve approve = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteArrayInputStream =null;
        ObjectInputStream objectInputStream =null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            approve = (Approve)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
                objectOutputStream.close();
                byteArrayInputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return approve;
    }

}
