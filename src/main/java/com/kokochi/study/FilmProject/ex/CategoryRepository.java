
package com.kokochi.study.FilmProject.ex;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findByCategoryName(String categoryName);       // 가수이름으로 찾기
    List<Category> findByItemList(String str);


    List<Category> findByItemListAfter(String str);
    List<Category> findByItemListBefore(String str);

    List<Category> findByItemListContaining(String str);
    List<Category> findByItemListContains(String str);
    List<Category> findByItemListNotContains(String str);

    List<Category> findByItemListEndingWith(String str);
    List<Category> findByItemListEndsWith(String str);
    List<Category> findByItemListExists(String str);
}
