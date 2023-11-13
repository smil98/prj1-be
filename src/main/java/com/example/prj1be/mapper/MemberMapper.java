package com.example.prj1be.mapper;

import com.example.prj1be.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
    INSERT INTO member (id, password, email)
    VALUES (#{id}, #{password}, #{email})
    """)
    int insert(Member member);

    @Select("""
    SELECT id FROM member
    WHERE id = #{id}
    """)
    String selectId(String id);

    @Select("""
    SELECT email FROM member
    WHERE email = #{email}
    """)
    String selectEmail(String email);

    @Select("""
    SELECT id, password, email, inserted
    FROM member
    ORDER BY inserted DESC
    """)
    List<Member> selectAllMembers();

    @Select("""
    SELECT *
    FROM member
    WHERE id = #{id}
    """)
    Member selectById(String id);

    @Delete("""
    DELETE FROM member
    WHERE id = #{id}
    """)
    int deleteById(String id);

    @Update("""
    <script>
    UPDATE member
    SET 
        <if test="password != ''">
        password = #{password}, 
        </if>
        email = #{email}
    WHERE id = #{id}
    </script>
    """)
    int updateById(Member member);
}
