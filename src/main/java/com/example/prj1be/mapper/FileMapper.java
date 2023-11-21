package com.example.prj1be.mapper;

import com.example.prj1be.domain.BoardFile;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("""
    INSERT INTO boardFile (boardId, name)
    VALUES (#{boardId}, #{name})
    """)
    int insert(Integer boardId, String name);

    @Select("""
    SELECT name
    FROM boardFile
    WHERE boardId = #{boardId}
    """)
    List<BoardFile> selectNameByBoardId(Integer id);

    @Delete("""
    DELETE FROM boardFile
    WHERE boardId = #{boardId}
    """)
    int deleteByBoardId(Integer boardId);

    @Delete("""
    <script>
    DELETE FROM boardFile
    WHERE boardId = #{boardId}
    <if test="fileName != '*'">
        AND name = #{fileName}
    </if>
    </script>
    """)
    int deleteByFileNameAndBoardId(Integer boardId, String fileName);
}