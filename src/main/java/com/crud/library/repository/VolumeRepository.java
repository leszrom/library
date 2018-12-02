package com.crud.library.repository;

import com.crud.library.domain.Volume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface VolumeRepository extends CrudRepository<Volume, Long> {
    List<Volume> findAllByBookId(long id);
}
