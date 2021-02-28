package com.example.demo.projectApplicant.vo;

public class TestHashVO {
	
	private int hashNo;
	private String hashTag;
	public int getHashNo() {
		return hashNo;
	}
	public void setHashNo(int hashNo) {
		this.hashNo = hashNo;
	}
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}
	@Override
	public String toString() {
		return "TestHashVO [hashNo=" + hashNo + ", hashTag=" + hashTag + "]";
	}
	
	

}
