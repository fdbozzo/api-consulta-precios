package io.swagger.configuration;

import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

  //private static final String DATE_TIME_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
  private static final String DATE_TIME_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss";

  /**
   * Esta configuración permite que las fechas guardadas con horario Zulu no sean convertidas al horario local.
   */
  @PostConstruct
  void started() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }
//  @Bean
//  @ConditionalOnMissingBean(ThreeTenModule.class)
//  ThreeTenModule threeTenModule() {
//    ThreeTenModule module = new ThreeTenModule();
//    module.addDeserializer(Instant.class, CustomInstantDeserializer.INSTANT);
//    module.addDeserializer(OffsetDateTime.class, CustomInstantDeserializer.OFFSET_DATE_TIME);
//    module.addDeserializer(ZonedDateTime.class, CustomInstantDeserializer.ZONED_DATE_TIME);
//    return module;
//  }

  @Bean("dateTimeFormatter")
  public DateTimeFormatter dateTimeFormatter() {
    return DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_STRING);
  }

//  @Bean
//  @Primary
//  public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
//    ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//
//    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//    //objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
//    return objectMapper;
//  }

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

//  @Bean(name = "jacksonConverter")
//  public MappingJackson2HttpMessageConverter jacksonConverter(final ObjectMapper objectMapper) {
//    final MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter();
//    httpMessageConverter.setObjectMapper(objectMapper);
//    return httpMessageConverter;
//  }
}

//class CustomOffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {
//
//  private final DateTimeFormatter dateTimeFormatter;
//
//  public CustomOffsetDateTimeSerializer(final DateTimeFormatter dateTimeFormatter) {
//    this.dateTimeFormatter = dateTimeFormatter;
//  }
//
//  @Override
//  public void serialize(final OffsetDateTime value, final JsonGenerator gen,
//      final SerializerProvider serializers)
//      throws IOException {
//    gen.writeString(dateTimeFormatter.format(value));
//  }
//
//}
//
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
