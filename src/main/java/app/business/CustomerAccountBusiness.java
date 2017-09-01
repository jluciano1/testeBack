package app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.dao.CustomerAccountDAO;
import app.entity.CustomerAccount;

/**
 * Classe que representa a camada de negócios de CustomerAccountBusiness
 * 
 * @generated
 **/
@Service("CustomerAccountBusiness")
public class CustomerAccountBusiness {



  /**
   * Instância da classe CustomerAccountDAO que faz o acesso ao banco de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("CustomerAccountDAO")
  protected CustomerAccountDAO repository;

  // CRUD

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
  public CustomerAccount post(final CustomerAccount entity) throws Exception {
    // begin-user-code  
    // end-user-code  
    CustomerAccount result = repository.save(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  public CustomerAccount put(final CustomerAccount entity) throws Exception {
    // begin-user-code  
    // end-user-code
    CustomerAccount result = repository.saveAndFlush(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public void delete(java.lang.Integer id) throws Exception {
    CustomerAccount entity = this.get(id);
    // begin-user-code  
    // end-user-code
    this.repository.delete(entity);
    // begin-user-code  
    // end-user-code        
  }
  
  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public CustomerAccount get(java.lang.Integer id) throws Exception {
    // begin-user-code  
    // end-user-code
    CustomerAccount result = repository.findOne(id);
    // begin-user-code
    // end-user-code
    return result;
  }

  // CRUD
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<CustomerAccount> list(Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<CustomerAccount> result = repository.list(pageable);
    // begin-user-code
    // end-user-code
    return result;
  }
}
