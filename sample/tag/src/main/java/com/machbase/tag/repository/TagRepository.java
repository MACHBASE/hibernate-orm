package com.machbase.tag.repository;

import com.machbase.tag.domain.Tag;
import com.machbase.tag.domain.TagPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TagRepository extends JpaRepository<Tag, TagPK> {
    @Query(value = "SELECT * FROM tag WHERE name = :name", nativeQuery=true)
    List<Tag> findTagsByName(@Param("name") String name);
}
