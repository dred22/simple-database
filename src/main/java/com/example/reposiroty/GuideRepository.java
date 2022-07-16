package com.example.reposiroty;

import com.example.entity.Guide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends CrudRepository<Guide, Integer> {
}
