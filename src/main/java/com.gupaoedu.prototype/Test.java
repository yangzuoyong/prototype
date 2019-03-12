package com.gupaoedu.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 工作流中多节点审核，审批件不能一样
 */
public class Test {
    public static void main(String[] args) {
        Attachment attachment = new Attachment(1L, "R000001", "first_node", "https://www.ww.aa/a.doc");
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        attachmentList.add(attachment);
        Approve approve1 = new Approve(11111111111111L, "YYY", "Yes", attachmentList);
        Approve approve2 = approve1.deepClone();
        System.out.println(approve1 == approve2);

    }
}

