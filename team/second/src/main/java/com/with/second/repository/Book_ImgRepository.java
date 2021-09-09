package com.with.second.repository;

import com.with.second.entity.Book_ImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Book_ImgRepository extends JpaRepository<Book_ImgEntity,Long> {

    @Modifying
    @Query("delete from Book_ImgEntity i where i.bookEntity.bno =:bno")
    void deleteByBno(@Param("bno") Long bno);
}
