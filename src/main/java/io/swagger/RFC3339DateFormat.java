package io.swagger;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class RFC3339DateFormat extends DateFormat {
  private static final long serialVersionUID = 1L;
  private static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone("UTC");

  private final StdDateFormat fmt = new StdDateFormat()
      .withTimeZone(TIMEZONE_Z)
      .withColonInTimeZone(true);

  public RFC3339DateFormat() {
    this.calendar = new GregorianCalendar();
  }

  @Override
  public Date parse(String source, ParsePosition pos) {
    return fmt.parse(source, pos);
  }

  @Override
  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
    return fmt.format(date, toAppendTo, fieldPosition);
  }

  @Override
  public Object clone() {
    return this;
  }
}

//public class RFC3339DateFormat extends ISO8601DateFormat {
//
//  private static final long serialVersionUID = 1L;
//
//  // Same as ISO8601DateFormat but serializing milliseconds.
//  @Override
//  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
//    String value = ISO8601Utils.format(date, true);
//    //String value = ISO8601Utils.format(date, true, TimeZone.getTimeZone(ZoneId.of("+00:00")));
//
//    //DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//    //OffsetDateTime dt = OffsetDateTime.of(date);
//    //fmt.format(date);
//    //String value = SimpleDateFormat.getDateTimeInstance().format(date);
//
//    toAppendTo.append(value);
//    return toAppendTo;
//  }
//
// //StdDateFormat
// public class RFC3339DateFormat2 extends StdDateFormat {
//
//   private static final long serialVersionUID = 1L;
//   private final boolean _tzSerializedWithColon = true;
//
//   @Override
//   public StringBuffer format(Date date, StringBuffer toAppendTo,
//       FieldPosition fieldPosition)
//   {
//     super.format(date, toAppendTo, fieldPosition);
//     return toAppendTo;
//   }
//
// }
//
//}