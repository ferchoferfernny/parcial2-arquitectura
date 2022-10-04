package co.edu.unisabana.parcialarquitectura.service;


import co.edu.unisabana.parcialarquitectura.repository.Database;
import co.edu.unisabana.parcialarquitectura.service.Port.RepositoryPort;

public class Buy {

  private final Database database;
  private final RepositoryPort rp;

  
  public Buy(Database database,RepositoryPort rp) {
    this.rp=rp;
    this.database = database;
  }

  public String makePurchase(int vendorCode, int buyerCode, String item) {
    if (buyerCode == vendorCode) {
      throw new IllegalSaleException(vendorCode, buyerCode);
    }
    int result = database.savePurchase(buyerCode, item);
    if (result == 1) {
      return "Product sold";
    } else {
      return "The sale was not possible";
    }
  }
}
