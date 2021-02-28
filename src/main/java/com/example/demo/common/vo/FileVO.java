package com.example.demo.common.vo;

public class FileVO {

    private int fileNo;
    private String uploadFileName;
    private long fileSize;
    private int postNo;
    private int projectNo;
    private int portfolioNo;
    private String path;

	public FileVO() {
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public int getPortfolioNo() {
		return portfolioNo;
	}

	public void setPortfolioNo(int portfolioNo) {
		this.portfolioNo = portfolioNo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("FileVO{");
		sb.append("fileNo=").append(fileNo);
		sb.append(", uploadFileName='").append(uploadFileName).append('\'');
		sb.append(", fileSize=").append(fileSize);
		sb.append(", postNo=").append(postNo);
		sb.append(", projectNo=").append(projectNo);
		sb.append(", portfolioNo=").append(portfolioNo);
		sb.append(", path='").append(path).append('\'');
		sb.append('}');
		return sb.toString();
	}
}