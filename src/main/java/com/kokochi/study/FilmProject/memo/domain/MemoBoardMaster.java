package com.kokochi.study.FilmProject.memo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "memo_board_master")
@Getter @Setter
@DynamicInsert @DynamicUpdate
public class MemoBoardMaster {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Memo_board_GEN"
    )
    private Long id;                        // PK 값

    @Column(nullable = false)
    private String name;                    // 게시판 이름

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;               //  생성 날짜

    @OneToMany(mappedBy = "master")
    private List<MemoBoard> boardList = new ArrayList<>();
}
