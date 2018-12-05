package com.crud.library.repository;

import com.crud.library.domain.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
    List<Loan> findAllByUserId(long id);

    Optional<Loan> findById(Long id);
}
