package io.swagger.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

@Configuration
public class JacksonConfiguration {

  private static final String DATE_TIME_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss";

  @Bean("dateTimeFormatter")
  public DateTimeFormatter dateTimeFormatter() {
    return DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_STRING);
  }

  @Bean
  @Primary
  public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
    ObjectMapper objectMapper = builder.createXmlMapper(false).build();
    //objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
    return objectMapper;
  }

//  @Bean
//  @Primary
//  public ObjectMapper objectMapper(final DateTimeFormatter dateTimeFormatter) {
//    final ObjectMapper mapper = new ObjectMapper();
//    mapper.enable(READ_UNKNOWN_ENUM_VALUES_AS_NULL);
//    mapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);
//    mapper.disable(WRAP_ROOT_VALUE);
//    mapper.disable(WRITE_DATES_AS_TIMESTAMPS);
//    mapper.setPropertyNamingStrategy(SNAKE_CASE);
//    final JavaTimeModule javaTimeModule = new JavaTimeModule();
//    javaTimeModule.addSerializer(OffsetDateTime.class, new CustomOffsetDateTimeSerializer(dateTimeFormatter));
//    javaTimeModule.addDeserializer(OffsetDateTime.class, new CustomOffsetDateTimeDeserializer(dateTimeFormatter));
//    mapper.registerModule(new Jdk8Module());
//    mapper.registerModule(javaTimeModule);
//    mapper.registerModule(new ParameterNamesModule());
//
//    return mapper;
//  }

  @Bean(name = "jacksonConverter")
  public MappingJackson2HttpMessageConverter jacksonConverter(final ObjectMapper objectMapper) {
    final MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter();
    httpMessageConverter.setObjectMapper(objectMapper);
    return httpMessageConverter;
  }
}

class CustomOffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {

  private final DateTimeFormatter dateTimeFormatter;

  public CustomOffsetDateTimeSerializer(final DateTimeFormatter dateTimeFormatter) {
    this.dateTimeFormatter = dateTimeFormatter;
  }

  @Override
  public void serialize(final OffsetDateTime value, final JsonGenerator gen,
      final SerializerProvider serializers)
      throws IOException {
    gen.writeString(dateTimeFormatter.format(value));
  }

}

//@Component
//class CustomOffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {
//
//  private final DateTimeFormatter dateTimeFormatter;
//
//  public CustomOffsetDateTimeDeserializer(final DateTimeFormatter dateTimeFormatter) {
//    this.dateTimeFormatter = dateTimeFormatter;
//  }
//
//  @Override
//  public OffsetDateTime deserialize(final JsonParser p, final DeserializationContext ctxt)
//      throws IOException, JsonProcessingException {
//    return OffsetDateTime.parse(p.getValueAsString(), dateTimeFormatter);
//  }
//}
