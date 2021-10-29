package com.kokochi.study.FilmProject.memo.repo;

import com.kokochi.study.FilmProject.memo.domain.MemoBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("memoRepository")
public interface MemoBoardRepository extends JpaRepository<MemoBoard, Long> {
}
