package br.com.middleware.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.middleware.dataaccess.entity.Bank;

/**
 * Created by zup134 on 23/02/18.
 */
public interface BankRepository extends JpaRepository<Bank, Long> {
}
