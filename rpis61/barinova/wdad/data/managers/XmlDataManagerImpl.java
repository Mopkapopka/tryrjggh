package rpis61.barinova.wdad.data.managers;

import rpis61.barinova.wdad.learn.xml.librarystaff.Book;
import rpis61.barinova.wdad.learn.xml.librarystaff.Library;
import rpis61.barinova.wdad.learn.xml.librarystaff.Reader;
import rpis61.barinova.wdad.learn.xml.librarystaff.TakeDate;
import rpis61.barinova.wdad.learn.xml.XmlTask;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XmlDataManagerImpl  implements XmlDataManager {
    private XmlTask xmlTask;
    private  Library library;
    private File file = new File("C:\\Users\\Rina\\IdeaProjects\\starting-monkey-to-human-path\\src\\rpis61\\barinova\\wdad\\resources\\configuration\\rmi.xml");

    public void init() throws IOException {
        xmlTask = new XmlTask(file, library);
    }

    @Override
    public List<Reader> negligentReaders() throws RemoteException {
        return  xmlTask.negligentReaders();
    }

    @Override
    public void removeBook(Reader reader, Book book) throws RemoteException {
        try {
            xmlTask.removeBook(reader, book);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Reader reader, Book book) throws RemoteException {
        try {
            xmlTask.addBook(reader, book);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<Book, TakeDate> bookReturnDates(Reader reader) throws RemoteException {
        HashMap<Book,  TakeDate> map = new HashMap<>();
        ArrayList<Book> list = (ArrayList<Book>) xmlTask.takenBooks(reader);
        ArrayList<TakeDate> dates = reader.getTakeDates();
        for (int i = 0; i< dates.size(); i++) {
            map.put(list.get(i),dates.get(i));
        }
        return map;
    }

    @Override
    public void save() throws IOException {
        xmlTask.save();

    }

}
