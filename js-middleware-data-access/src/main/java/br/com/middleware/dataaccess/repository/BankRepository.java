package br.com.middleware.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.middleware.dataaccess.entity.BankEntity;

/**
 * Created by Joel on 23/02/18.
 */
@Repository
public interface BankRepository extends JpaRepository<BankEntity, Long> {

}
