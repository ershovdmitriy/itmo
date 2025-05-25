package collectionManagers;

import collection.HumanBeing.HumanBeing;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;

public interface FileManager<T> {

    public T readFromFile(String pathToDataFile, TypeReference<T> typeReference) throws IOException;

    public void writeToFile(String pathToDataFile, T object) throws IOException;
}
