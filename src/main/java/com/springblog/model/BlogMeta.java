package com.springblog.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Component
public class BlogMeta extends AbstractPersistable<Long> {
	
	@Length(min=1, max=255)
	@NonNull
	private String title = "";
	
	@Length(min=1, max=255)
	@NonNull
	private String author = "";
	
	@Length(max=1024)
	@NonNull
	private String greeting = "";
	
	@Length(max=1024)
	@NonNull
	private String introduce = "";
	
	@Length(max=1024)
	@NonNull
	private String mail = "";
	
	@Length(min=1, max=255)
	@NonNull
	private String authorFacebookEmail = "";
	
	@Basic(optional=false)
	@Column(updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
	@NonNull
	private Date createdAt = new Date();
	
	@Basic(optional=false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
	@NonNull
	private Date updatedAt = new Date();
	
	
	public void set(BlogMeta meta){
		this.title = meta.title;
		this.author = meta.author;
		this.introduce = meta.introduce;
		this.greeting = meta.mail;
		this.authorFacebookEmail = meta.authorFacebookEmail;
		//this.createdAt = meta.createdAt;
		this.updatedAt = meta.updatedAt;
	}
	
	public boolean isInitialized(){
		return !StringUtils.isEmpty(title) && !StringUtils.isEmpty(authorFacebookEmail);
	}

}
