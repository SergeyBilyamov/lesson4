package com.genealogy.io;

import com.genealogy.model.FamilyTree;
import com.genealogy.model.Person;
import java.io.IOException;

public interface FamilyTreeFileHandler<T extends Person> {
    void saveToFile(FamilyTree<T> familyTree, String filename) throws IOException;
    FamilyTree<T> loadFromFile(String filename) throws IOException, ClassNotFoundException;
}



