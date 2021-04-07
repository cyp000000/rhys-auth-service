package za.co.infowarestudios.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mail database table.
 * 
 */
@Entity
@NamedQuery(name="Mail.findAll", query="SELECT m FROM Mail m")
public class Mail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Lob
	@Column(name="attachment_file")
	private byte[] attachmentFile;

	@Column(name="attachment_name")
	private String attachmentName;

	@Column(name="base64attachment_file")
	private String base64attachmentFile;

	@Lob
	private String content;

	@Column(name="email_from")
	private String emailFrom;

	@Column(name="email_to")
	private String emailTo;

	private String subject;

	public Mail() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getAttachmentFile() {
		return this.attachmentFile;
	}

	public void setAttachmentFile(byte[] attachmentFile) {
		this.attachmentFile = attachmentFile;
	}

	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getBase64attachmentFile() {
		return this.base64attachmentFile;
	}

	public void setBase64attachmentFile(String base64attachmentFile) {
		this.base64attachmentFile = base64attachmentFile;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmailFrom() {
		return this.emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return this.emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}