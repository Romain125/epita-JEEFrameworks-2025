package epita.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class Tracer {

    public String filename;

    @Autowired
    public Tracer(@Value("${tracer.filename}") String filename) {
        this.filename = filename;
    }

    public void trace(String message) {
        try {
            Files.write(Path.of(filename), List.of(message));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
