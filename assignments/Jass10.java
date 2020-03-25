package assignments;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

interface SListIterator<T> {
  boolean hasNext();
  T next();
  void remove();
  void add(T element);
}

class SList<T> {
	
  private final Link<T> header = new Link<T>(null, null);
  SList() { header.next = header; }
  
  
  public String toString() {
    StringBuilder buffer = new StringBuilder();
    buffer.append("[");
    for(SListIterator<T> iterator = iterator(); iterator.hasNext();) {
      T element = iterator.next();
      buffer.append(element == this ? "(this SList)" :
        String.valueOf(element));
      if(iterator.hasNext())
        buffer.append(", ");
    }
    buffer.append("]");
    return buffer.toString();
  }
  
  
  public SListIterator<T> iterator() {
    return new SListIteratorImpl();
  }
  private static class Link<T> {
    T element;
    Link<T> next;
    Link(T element, Link<T> next) {
      this.element = element;
      this.next = next;
    }
  }
  private class SListIteratorImpl
  implements SListIterator<T> {
    private Link<T> lastReturned = header;
    private Link<T> next;
    
    SListIteratorImpl() { next = header.next; }
  
    
    public boolean hasNext() { return next != header; }
    
    
    public T next() {
      if(next == header)
        throw new NoSuchElementException();
      lastReturned = next;
      next = next.next;
      return lastReturned.element;
    }
    
    
    public void remove() {
      if(lastReturned == header)
        throw new IllegalStateException();
      // Find an element before the last returned one
      for(Link<T> current = header; ; current = current.next)
        if(current.next == lastReturned) {
          current.next = lastReturned.next;
          break;
        }
      lastReturned = header;
    }
    
    
    public void add(T element) {
      lastReturned = header;
      Link<T> newLink = new Link<T>(element, next);
      if(header.next == header)   // Empty list
        header.next = newLink;
      else {
        // Find an element before the one pointed by 'next'
        for(Link<T> current = header; ; current = current.next)
          if(current.next == next) {
            current.next = newLink;
            break;
          }
      }
    }
    
    
  }
}

public class ListIterator {
  public static void main(String[] args) {
	  final  Logger logger = Logger.getLogger(ListIterator.class.getName());
    logger.log(Level.INFO,"Demonstrating SListIterator...");
    SList<String> sList = new SList<String>();
    logger.log(Level.INFO,String.valueOf(sList));
    SListIterator<String> sListIterator =sList.iterator();
    sListIterator.add("One");
    sListIterator.add("Two");
    sListIterator.add("Three");
    logger.log(Level.INFO,String.valueOf(sListIterator.hasNext()));
    logger.log(Level.INFO,String.valueOf(sList));
    sListIterator = sList.iterator();
    sListIterator.add("Four");
    for(; sListIterator.hasNext();)
    	 logger.log(Level.INFO,String.valueOf(sListIterator.next()));
    logger.log(Level.INFO,String.valueOf(sList));
    sListIterator = sList.iterator();
    logger.log(Level.INFO,String.valueOf(sListIterator.next()));
    sListIterator.remove();
    logger.log(Level.INFO,String.valueOf(sListIterator.next()));
    logger.log(Level.INFO,String.valueOf(sList));
  }
} 
