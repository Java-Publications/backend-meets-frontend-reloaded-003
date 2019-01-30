package junit.org.rapidpm.vaadin.resourcebundles.v01;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VaadinAppResourceTest {

  @Test
  @DisplayName("Locale English")
  void test001() {
    final ResourceBundle a = ResourceBundle.getBundle(VaadinAppResource.class.getName(), Locale.ENGLISH );
    Assertions.assertEquals("value 01 - en", a.getString("s1"));
  }

  @Test
  @DisplayName("Locale German")
  void test002() {
    final ResourceBundle a = ResourceBundle.getBundle(VaadinAppResource.class.getName(), Locale.GERMAN );
    Assertions.assertEquals("value 01 - de", a.getString("s1"));
  }

  @Test
  @DisplayName("Locale Default")
  void test003() {
    final ResourceBundle a = ResourceBundle.getBundle(VaadinAppResource.class.getName() , Locale.ROOT);
    Assertions.assertEquals("value 01" , a.getString("s1"));
  }
}
