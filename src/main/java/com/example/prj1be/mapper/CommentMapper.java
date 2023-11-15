package com.example.prj1be.mapper;

import com.example.prj1be.domain.Comment;
import com.example.prj1be.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("""
        INSERT INTO comment (boardId, comment, memberId) 
        VALUES (#{boardId}, #{comment}, #{memberId})
        """)
    int insert(Comment comment);

    @Select("""
        SELECT *
        FROM comment
        WHERE boardId = #{boardId}
        """)
    List<Comment> selectByBoardId(Integer boardId);

    @Select("""
    SELECT *
    FROM comment
    WHERE id = #{commentId}
    """)
    Comment selectCommentById(Integer commentId);

    @Delete("""
    DELETE FROM comment
    WHERE id = #{commentId}
    """)
    int deleteById(Integer commentId);

    @Update("""
    UPDATE comment
    SET comment = #{comment}
    WHERE id = #{id}
    """)
    int update(Comment comment);
}
