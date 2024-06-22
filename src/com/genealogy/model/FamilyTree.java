package com.genealogy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        if (member != null) {
            this.members.add(member);
        } else {
            throw new IllegalArgumentException("Member cannot be null");
        }
    }

    public T findMemberByName(String name) {
        for (T member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<T> getAllChildren(String name) {
        T member = findMemberByName(name);
        if (member != null) {
            List<T> children = new ArrayList<>();
            for (Person child : member.getChildren()) {
                children.add((T) child);
            }
            return children;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        Collections.sort(members, Comparator.comparing(T::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(members, Comparator.comparing(T::getBirthDate));
    }
}

