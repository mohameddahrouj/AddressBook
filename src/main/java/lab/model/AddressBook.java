package lab.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<BuddyInfo> book;

    public Collection<BuddyInfo> getBook() {
        return book;
    }

    public void setBook(Collection<BuddyInfo> book) {

        this.book = book;
    }

    public AddressBook(){
        book = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy){
        book.add(buddy);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(BuddyInfo b: book){
            s.append(b.toString());
            s.append('\n');
        }
        return s.toString();
    }

    public void removeBuddy(BuddyInfo buddy){
        if(book.contains(buddy)){
            book.remove(buddy);
        }
    }

    public int getSize(){
        return this.book.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!AddressBook.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        AddressBook newBook = (AddressBook) obj;
        if(newBook.getBook().equals(this.getBook())){
            return true;
        }
        return false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}