package com.kokochi.study.FilmProject.ex;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Document(collection = "music")
@Getter
@Setter
@ToString
public class Music {
    public static final String ID = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";

    @Id
    private String id;              // id값
    private String vocal;           // 가수
    private String title;           // 노래제목
    private String fileName;        // 파일이름
    private String extension;       // 확장자
    private Integer size;           // 파일크기
    private Date regDate;           // 등록일자
    private Integer readNum;        // 재생수
    private String highlight;       // 하이라이트 시간
    private Integer point;          // 인기점수
    private List<String> categoryList;        // 카테고리 리스트

}
