package rpis61.barinova.wdad;

import rpis61.barinova.wdad.learn.xml.librarystaff.*;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        rpis61.barinova.wdad.learn.rmi.Client client = new rpis61.barinova.wdad.learn.rmi.Client();

        Reader reader = new Reader("ye","vaar");
        Author author = new Author("Эрик","Шпикерман");
        Book book = new Book(author,"О шрифте","2010", Genre.NOVEL);
        reader.takeBook(book);

        client.main().addBook(reader,book);
        client.main().save();
    }
}
