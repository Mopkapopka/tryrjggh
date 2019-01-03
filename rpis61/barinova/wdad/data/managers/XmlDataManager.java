package rpis61.barinova.wdad.data.managers;

import rpis61.barinova.wdad.learn.xml.librarystaff.Book;
import rpis61.barinova.wdad.learn.xml.librarystaff.Reader;
import rpis61.barinova.wdad.learn.xml.librarystaff.TakeDate;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

public interface XmlDataManager extends Remote {
    List<Reader> negligentReaders () throws RemoteException;
    void removeBook (Reader reader, Book book)  throws RemoteException;
    void addBook (Reader reader, Book book) throws RemoteException;
    HashMap<Book, TakeDate> bookReturnDates (Reader reader)  throws RemoteException;

    void save() throws IOException;
}

//    public List<Reader> negligentReaders () – возвращающий список
//        читателей – должников (у которых книга на руках уже более 2-х
//        недель).
//public void removeBook (Reader reader, Book book) – удаляющий запись
//        о книге у заданного читателя. Записывает результат в этот же xmlдокумент.
//public void addBook (Reader reader, Book book) – добавляющий запись о
//        книге заданному читателю. Записывает результат в этот же xmlдокумент.
//public HashMap<Book, Date> bookReturnDates (Reader reader) –
//        возвращает Hashmap для получения даты возврата книги заданного
//        читателя