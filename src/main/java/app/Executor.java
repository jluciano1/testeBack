package app;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import app.business.CustomerAccountBusiness;
import app.entity.CustomerAccount;

@Configuration
public class Executor {

  @Autowired
  @Qualifier("CustomerAccountBusiness")
  private CustomerAccountBusiness customerAccountBusiness;

	@EventListener(ApplicationReadyEvent.class)
   public void doSomethingAfterStartup() {
    BigDecimal mediaSaldo = new BigDecimal(0.0);
    double somaSaldo = 0.0;
    int qtdeCustomers = 0;
    
    List<CustomerAccount> customers = customerAccountBusiness.list(null).getContent();
    TreeSet<CustomerAccount> clientesUtilizados = new TreeSet<CustomerAccount>(Collections.reverseOrder());
    
    for (CustomerAccount ca : customers)
    {
      if ((ca.getSaldo().doubleValue() > 560.0) && (ca.getId().intValue() >= 1500 && ca.getId().intValue() <= 2700)) 
      {
        somaSaldo += ca.getSaldo().doubleValue();
        qtdeCustomers++;
        clientesUtilizados.add(ca);
      }
    }
    if (qtdeCustomers > 0)
    {
      mediaSaldo = new BigDecimal(somaSaldo/qtdeCustomers);  
    }
    System.out.println("Média de saldo de clientes id entre 1500 e 2700 e saldo maior que 560: " + mediaSaldo.setScale(2, BigDecimal.ROUND_HALF_UP));
    System.out.println("Lista de clientes contabilizados ordenados pelo saldo decrescente: ");
    for (CustomerAccount c : clientesUtilizados)
    {
      System.out.println("ID: " + c.getId());
      System.out.println("Nome: " + c.getNome());
      System.out.println("CPF/CNPJ: " + c.getCpf_cnpj());
      System.out.println("Ativo: " + c.getAtivo());
      System.out.println("Saldo: " + c.getSaldo());
    }
  }

}
