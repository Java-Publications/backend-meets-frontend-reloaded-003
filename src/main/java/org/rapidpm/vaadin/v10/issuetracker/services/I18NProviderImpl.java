package org.rapidpm.vaadin.v10.issuetracker.services;

import static java.util.Locale.ENGLISH;
import static java.util.Locale.GERMAN;
import static java.util.Locale.ROOT;
import static java.util.ResourceBundle.getBundle;
import static javax.cache.Caching.getCachingProvider;
import static org.rapidpm.frp.matcher.Case.match;
import static org.rapidpm.frp.matcher.Case.matchCase;
import static org.rapidpm.frp.model.Result.success;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.cache.spi.CachingProvider;

import org.rapidpm.dependencies.core.logger.HasLogger;
import com.vaadin.flow.i18n.I18NProvider;

public class I18NProviderImpl implements I18NProvider, HasLogger {

  public I18NProviderImpl() {
    logger().info("I18NProviderImpl was found..");
  }

  public static final String RESOURCE_BUNDLE_NAME = "labels";

  private static final ResourceBundle RESOURCE_BUNDLE_ROOT = getBundle(RESOURCE_BUNDLE_NAME , ROOT);
  private static final ResourceBundle RESOURCE_BUNDLE_EN = getBundle(RESOURCE_BUNDLE_NAME , ENGLISH);
  private static final ResourceBundle RESOURCE_BUNDLE_DE = getBundle(RESOURCE_BUNDLE_NAME , GERMAN);

  private static final List<Locale> LOCALES = List.of(ENGLISH ,
                                                      GERMAN);

  @Override
  public List<Locale> getProvidedLocales() {
    logger().info("VaadinI18NProvider getProvidedLocales.. " + LOCALES);
    return LOCALES;
  }

  @Override
  public String getTranslation(String key , Locale locale , Object... params) {
    logger().info("VaadinI18NProvider getTranslation.. key : " + key + " - " + locale);
    return match(
        matchCase(() -> success(RESOURCE_BUNDLE_ROOT)) ,
        matchCase(() -> GERMAN.equals(locale) , () -> success(RESOURCE_BUNDLE_DE)) ,
        matchCase(() -> ENGLISH.equals(locale) , () -> success(RESOURCE_BUNDLE_EN))
    )
        .map(resourceBundle -> {
          if (! resourceBundle.containsKey(key))
            logger().info("missing ressource key (i18n) " + key);

          String pattern = (resourceBundle.containsKey(key)) ? resourceBundle.getString(key) : key;
          return new MessageFormat(pattern, locale).format(params);

        })
        .getOrElse(() -> key + " - " + locale);
  }

}