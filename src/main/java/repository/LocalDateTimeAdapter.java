package repository;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class LocalDateTimeAdapter extends TypeAdapter<java.time.LocalDateTime>{
    public LocalDateTimeAdapter() {
    }

    @Override
    public void write(JsonWriter out, java.time.LocalDateTime value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value.toString());
    }

    @Override
    public java.time.LocalDateTime read(JsonReader in) throws IOException {
        return java.time.LocalDateTime.parse(in.nextString());
    }
}
