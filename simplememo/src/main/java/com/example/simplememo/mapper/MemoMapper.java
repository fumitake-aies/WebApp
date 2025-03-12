package com.example.simplememo.mapper;

import com.example.simplememo.model.Memo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemoMapper {
    @Select("SELECT * FROM memos")
    List<Memo> findAll();

    @Select("SELECT * FROM memos WHERE id = #{id}")
    Memo findById(int id);

    @Insert("INSERT INTO memos(content, created_at, updated_at) VALUES(#{content}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Memo memo);

    @Update("UPDATE memos SET content=#{content}, updated_at=#{updatedAt} WHERE id=#{id}")
    void update(Memo memo);

    @Delete("DELETE FROM memos WHERE id=#{id}")
    void delete(int id);
}
