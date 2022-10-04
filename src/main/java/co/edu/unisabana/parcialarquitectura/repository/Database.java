package co.edu.unisabana.parcialarquitectura.repository;

import co.edu.unisabana.parcialarquitectura.service.Port.RepositoryPort;

public class Database implements RepositoryPort{

  public int savePurchase(int buyerCode, String item) {
    if (buyerCode == 0 || item == null || item.isEmpty()) {
      return 0;
    }
    return 1;
  }

  @Override
  public void conectionExmaple() {
    // El metodo de Inversion de dependncias
  }
}
