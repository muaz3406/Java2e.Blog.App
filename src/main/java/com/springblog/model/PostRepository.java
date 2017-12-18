package com.springblog.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {
	@Query("select p from Post where title like %:search% or content like %:search%")
	Page<Post> findByTitleOrContent(Pageable pageable, @Param("search") String search);

}
