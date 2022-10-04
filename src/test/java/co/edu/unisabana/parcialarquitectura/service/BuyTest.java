package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.Database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class BuyTest {

  @InjectMocks
  private Buy service;
  @Mock
  private Database database;

  /* 
  @Test
  public void test() {
    service.makePurchase(2, 3, "Books");
  }*/

  @Test
  public void Given_equalsVendorCodeAndBuyerCode_When_makePurchase_Then_ThowIllegalSaleException (){
    assertThrows(IllegalSaleException.class, () -> {
      service.makePurchase(2, 2, "Books");
    });
  }
  @Test
  public void Given_NoNullItem_When_makePurchase_Then_TheSaleWasNotPossible (){

    assertEquals("The sale was not possible",service.makePurchase(2, 3, null));
  }
  @Test
  public void Given_EmptylItem_When_makePurchase_Then_TheSaleWasNotPossible (){
    assertEquals("The sale was not possible",service.makePurchase(2, 3, ""));
  }
  @Test
  public void Given_NoBuyerCode_When_makePurchase_Then_TheSaleWasNotPossible (){
    assertEquals("The sale was not possible",service.makePurchase(2, 0, "Perros"));
  }
  @Test
  public void Given_CorrectParameter_When_makePurchase_Then_ProductSold (){
    Mockito.when(database.savePurchase(2,"Perros")).thenReturn(1);
    assertEquals("Product sold",service.makePurchase(1, 2, "Perros"));
  }


}