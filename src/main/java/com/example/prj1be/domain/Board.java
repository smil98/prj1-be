package com.example.prj1be.domain;

import com.example.prj1be.util.AppUtil;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Board {
    private Integer id;
    private String title;
    private String content;
    private String writer;
    private String nickName;
    private LocalDateTime inserted;
    private Integer countComment;
    private Integer countLike;
    private Integer countFile;

    private List<BoardFile> files;

    public String getAgo() {
        return AppUtil.getAgo(inserted);
    }
}
