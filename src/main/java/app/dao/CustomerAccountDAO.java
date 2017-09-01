package app.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.entity.CustomerAccount; 

@Repository("CustomerAccountDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface CustomerAccountDAO extends JpaRepository<CustomerAccount, java.lang.Integer> {

  @Query("select c from CustomerAccount c")
  public Page<CustomerAccount> list(Pageable pageable);

}