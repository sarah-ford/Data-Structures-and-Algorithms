// file: InstrumentedHashSet.java
// author: Josh Bloch,
//
// This code is from Effective Java: Item 16 favor composition over inheritance
//
// Broken - Inappropriate use of inheritance!    

import java.util.*;

public class InstrumentedHashSet<E> extends HashSet<E> {
    // The number of attempted element insertions
    private int addCount = 0;
    public InstrumentedHashSet() {}
    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor); 
    }

    @Override public boolean add(E e) {     
        addCount++;     
        return super.add(e); 
    }
    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size(); 
        return super.addAll(c); 
    }
    
    public static void main(String[] args) {
        
        InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println("addCount = " + s.addCount);
    }
}
    