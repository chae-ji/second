package com.with.second.repository;

import com.with.second.entity.BookEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Long> {

    @Query("select b,i from BookEntity b left outer join Book_ImgEntity i on i.bookEntity = b")
    List<Object[]> getList(Sort sort);

    @Query("select b,i from BookEntity b left outer join Book_ImgEntity i on i.bookEntity = b where b.bno =:bno")
    List<Object[]> read(@Param("bno") Long bno);

    @Query("select b,i from BookEntity b left outer join Book_ImgEntity i on i.bookEntity = b where b.name like %:keyword%")
    List<Object[]> getListSearchByName(@Param("keyword")String keyword,Sort sort);

    @Query("select b,i from BookEntity b left outer join Book_ImgEntity i on i.bookEntity = b where b.department = :department")
    List<Object[]> getListSearchByDepartment(@Param("department")String department,Sort sort);

    @Query("select b,i from BookEntity b left outer join Book_ImgEntity i on i.bookEntity = b where b.name like %:keyword% and " +
            "b.department = :department")
    List<Object[]> getListSearchByDepartmentAndName(@Param("keyword")String keyword,@Param("department")String department, Sort sort);

    @Query("select b,i from BookEntity b left outer join Book_ImgEntity i on i.bookEntity = b where b.isNew = :isNew")
    List<Object[]> getNewOrOldList(@Param("isNew")boolean isNew, Sort sort);

    @Query("select b,i from BookEntity b left outer join Book_ImgEntity i on i.bookEntity = b where b.department = :department and " +
            "b.isNew = :isNew")
    List<Object[]> getOldOrNewListSearchByDepartment(@Param("department")String department,@Param("isNew")boolean isNew, Sort sort);

    @Query("select b,i from BookEntity b left outer join Book_ImgEntity i on i.bookEntity = b where b.name like %:keyword% and " +
            "b.isNew = :isNew")
    List<Object[]> getOldOrNewListSearchByName(@Param("keyword")String keyword,@Param("isNew")boolean isNew, Sort sort);

    @Query("select b,i from BookEntity b left outer join Book_ImgEntity i on i.bookEntity = b where b.name like %:keyword% and " +
            "b.department = :department and b.isNew = :isNew")
    List<Object[]> getOldOrNewListSearchByNameAndDepartment(@Param("keyword")String keyword,
                                                            @Param("department")String department,@Param("isNew")boolean isNew, Sort sort);
}
