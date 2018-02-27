package br.com.middleware.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.middleware.dataaccess.entity.Bank;

/**
 * Created by zup134 on 23/02/18.
 */
@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
