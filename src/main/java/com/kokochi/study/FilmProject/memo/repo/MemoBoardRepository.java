package com.kokochi.study.FilmProject.memo.repo;

import com.kokochi.study.FilmProject.memo.domain.MemoBoardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memoRepository")
public interface MemoBoardRepository extends JpaRepository<MemoBoardVO, Long> {

    @Query(
            value = "SELECT mb FROM MemoBoardVO mb WHERE mb.master.id = :masterId"
    )
    List<MemoBoardVO> findAllByMasterId(Long masterId);
}
