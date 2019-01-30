package junit.org.rapidpm.vaadin.resourcebundles.v01;

import java.util.ListResourceBundle;

public class VaadinAppResource extends ListResourceBundle {

  @Override
  protected Object[][] getContents() {
    return new Object[][]{
        {"s1" , "value 01"} ,
        {"s2" , "value 02"}
    };
  }
}
