package com.nuist.domain;

/**
 * @author LiZonggen
 * @date 2021-03-29 14:33
 * @description:版块表实体类
 * @version:
 */
public class Post {
    private Integer bbs_section_id;
    private String section_name;
    private Integer post_num;
    private String post_describe;

    public Integer getBbs_section_id() {
        return bbs_section_id;
    }

    public void setBbs_section_id(Integer bbs_section_id) {
        this.bbs_section_id = bbs_section_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public Integer getPost_num() {
        return post_num;
    }

    public void setPost_num(Integer post_num) {
        this.post_num = post_num;
    }

    public String getPost_describe() {
        return post_describe;
    }

    public void setPost_describe(String post_describe) {
        this.post_describe = post_describe;
    }
}
