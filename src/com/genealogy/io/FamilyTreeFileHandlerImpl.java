package com.genealogy.io;

import com.genealogy.model.FamilyTree;
import com.genealogy.model.Person;
import java.io.*;

public class FamilyTreeFileHandlerImpl<T extends Person> implements FamilyTreeFileHandler<T> {

    @Override
    public void saveToFile(FamilyTree<T> familyTree, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<T> loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }
}


