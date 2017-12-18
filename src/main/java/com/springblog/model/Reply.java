package com.springblog.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true, exclude = {"post"})
@ToString(callSuper = true, exclude = {"post"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reply extends AbstractPersistable<Long> {
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Post post;

    @Size(min = 1, max = 32)
    @Column(nullable = false)
    private String name;

    @Size(min = 1, max = 32)
    @Column(nullable = false)
    private String password;

    @Size(min = 1, max = 1024)
    @Column(nullable = false)
    private String comment;

    @Basic(optional = false)
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdAt = new Date();

    public void update(Reply reply) {
        this.name = reply.name;
        this.password = reply.password;
        this.comment = reply.comment;
    }

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
    
    
}