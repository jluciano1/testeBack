package app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.dao.CustomerAccountDAO;
import app.entity.CustomerAccount;

@Service("CustomerAccountBusiness")
public class CustomerAccountBusiness {

  @Autowired
  @Qualifier("CustomerAccountDAO")
  protected CustomerAccountDAO repository;

  public Page<CustomerAccount> list(Pageable pageable){
    Page<CustomerAccount> result = repository.list(pageable);
    return result;
  }
}
