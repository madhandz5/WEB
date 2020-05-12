package bm.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable {

	private static final long serialVersionUID = -646238139250986591L;

	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private Date noticeDate;
	private String noticeContent;
	private String original_filepath;
	private String rename_filepath;

	public Notice() {
		super();
	}

	public Notice(int noticeNo, String noticeTitle, String noticeWriter, Date noticeDate, String noticeContent,
			String original_filepath, String rename_filepath) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
		this.original_filepath = original_filepath;
		this.rename_filepath = rename_filepath;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getOriginal_filepath() {
		return original_filepath;
	}

	public void setOriginal_filepath(String original_filepath) {
		this.original_filepath = original_filepath;
	}

	public String getRename_filepath() {
		return rename_filepath;
	}

	public void setRename_filepath(String rename_filepath) {
		this.rename_filepath = rename_filepath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeWriter=" + noticeWriter
				+ ", noticeDate=" + noticeDate + ", noticeContent=" + noticeContent + ", original_filepath="
				+ original_filepath + ", rename_filepath=" + rename_filepath + "]";
	}

}
