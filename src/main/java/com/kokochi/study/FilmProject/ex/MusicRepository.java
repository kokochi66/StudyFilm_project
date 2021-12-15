
package com.kokochi.study.FilmProject.ex;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MusicRepository extends MongoRepository<Music, String> {
    List<Music> findByVocal(String vocal);       // 가수이름으로 찾기
    List<Music> findByTitle(String title);       // 노래제목으로 찾기

    List<Music> findByCategoryList(String str);
    List<Music> findByCategoryListAfter(String str);
    List<Music> findByCategoryListBefore(String str);
    List<Music> findByCategoryListContaining(String str);
    List<Music> findByCategoryListContains(String str);
    List<Music> findByCategoryListNotContains(String str);
    List<Music> findByCategoryListEndingWith(String str);
    List<Music> findByCategoryListEndsWith(String str);
    List<Music> findByCategoryListExists(String str);
}
