package org.example;

import java.io.IOException;

public interface Task {
    void start() throws IOException;
    void stop();
}
