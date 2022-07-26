package com.halead.eduservice.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: ChapterVo
 * @Author ppjjss
 * @Date: 2022/7/25 21:19
 * @Version 1.0
 */
@Data
public class ChapterVo {
    private String id;

    private String title;

    //表示小节
    private List<VideoVo> children = new ArrayList<>();
}
