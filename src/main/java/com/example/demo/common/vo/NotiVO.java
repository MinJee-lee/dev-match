package com.example.demo.common.vo;

public class NotiVO {
    private int notiNo; //알림번호
    private String notiTitle; //알림제목
    private String notiContent; //알림내용
    private String notiStatus; //알림상태

    public NotiVO() {
    }

    public int getNotiNo() {
        return notiNo;
    }

    public void setNotiNo(int notiNo) {
        this.notiNo = notiNo;
    }

    public String getNotiTitle() {
        return notiTitle;
    }

    public void setNotiTitle(String notiTitle) {
        this.notiTitle = notiTitle;
    }

    public String getNotiContent() {
        return notiContent;
    }

    public void setNotiContent(String notiContent) {
        this.notiContent = notiContent;
    }

    public String getNotiStatus() {
        return notiStatus;
    }

    public void setNotiStatus(String notiStatus) {
        this.notiStatus = notiStatus;
    }

    @Override
    public String toString() {
        return "NotiVO{" +
                "notiNo=" + notiNo +
                ", notiTitle='" + notiTitle + '\'' +
                ", notiContent='" + notiContent + '\'' +
                ", notiStatus='" + notiStatus + '\'' +
                '}';
    }

}
