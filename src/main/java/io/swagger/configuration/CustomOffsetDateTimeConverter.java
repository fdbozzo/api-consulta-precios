package io.swagger.configuration;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomOffsetDateTimeConverter implements Converter<String, OffsetDateTime> {

  @Autowired
  private DateTimeFormatter dateTimeFormatter;

  @Override
  public OffsetDateTime convert(final String source) {
    if (source.isEmpty()) {
      return null;
    }
    return OffsetDateTime.parse(source, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    //return OffsetDateTime.parse(source, dateTimeFormatter);
  }

}
