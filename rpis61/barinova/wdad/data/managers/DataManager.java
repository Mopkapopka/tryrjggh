package rpis61.barinova.wdad.data.managers;

import rpis61.barinova.wdad.learn.xml.librarystaff.Book;
import rpis61.barinova.wdad.learn.xml.librarystaff.Reader;
import rpis61.barinova.wdad.learn.xml.librarystaff.Takedate;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

public interface DataManager extends Remote {
    List<Reader> negligentReaders () throws RemoteException;
    void removeBook (Reader reader, Book book)  throws RemoteException;
    void addBook (Reader reader, Book book) throws RemoteException;
    HashMap<Book, Takedate> bookReturnDates (Reader reader)  throws RemoteException;

    void save() throws IOException;
}
