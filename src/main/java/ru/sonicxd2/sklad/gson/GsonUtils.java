package ru.sonicxd2.sklad.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by: Yaroslav Skrebets <sonic@c7x.dev>
 * Date: 08.01.2020: 20:07
 */
public class GsonUtils {
    private static final GsonBuilder builder = new GsonBuilder();

    private static final Gson GSON = builder.create();
    private static final Gson PRETTY_GSON = builder.setPrettyPrinting().create();

    public static <T> T loadFromFile(File file, Class<T> clazz) {
        try (FileReader reader = new FileReader(file)) {
            return GSON.fromJson(reader, clazz);
        } catch (Throwable thr) {
            throw new RuntimeException(thr);
        }
    }
    public static <T> T loadFromFile(File file, Type type) {
        try (FileReader reader = new FileReader(file)) {
            return GSON.fromJson(reader, type);
        } catch (Throwable thr) {
            throw new RuntimeException(thr);
        }
    }

    private static <T> void saveToFile(File file, T value, Gson gson) {
        try (FileWriter writer = new FileWriter(file)) {
            String jsonValue = gson.toJson(value);

            writer.append(jsonValue);
        } catch (Throwable thr) {
            throw new RuntimeException(thr);
        }
    }

    public static <T> void saveToFile(File file, T value) {
        saveToFile(file, value, GSON);
    }

    public static <T> void savePrettyToFile(File file, T value) {
        saveToFile(file, value, PRETTY_GSON);
    }
}
