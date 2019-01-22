package rpis61.barinova.wdad.data.managers;

import rpis61.barinova.wdad.data.storage.DataSourceFactory;
import rpis61.barinova.wdad.learn.xml.librarystaff.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JDBCDataManager implements DataManager {
    private DataSource ds = null;
    private Connection connection = null;

    public JDBCDataManager() {
        try {
            ds = DataSourceFactory.createDataSource();
            connection = ds.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reader> negligentReaders() throws RemoteException {
        ArrayList<Reader> readers = new ArrayList<>();
        String query = "SELECT readers.id, first_name, second_name\n" +
                "FROM books_readers INNER JOIN readers ON books_readers.readers_id = readers.id\n" +
                "WHERE return_date >= 14;";
        Statement stmt;
        ResultSet resultSet;

        try {
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                readers.add(
                        new Reader(
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return readers;
    }

    @Override
    public void removeBook(Reader reader, Book book) throws RemoteException {
        try {
            Statement statement = connection.createStatement();
            {
                StringBuilder st = new StringBuilder("DELETE FROM books_readers WHERE (books_dictionary_id=").append(book.getId())
                        .append(") AND (readers_id = ").append(reader.getId()).append(";");
                statement.executeUpdate(st.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } {

        }
    }

    @Override
    public void addBook(Reader reader, Book book) throws RemoteException {
        try {
            Statement statement = connection.createStatement();
                StringBuilder st = new StringBuilder("Insert into books_readers (books_dictionary_id, readers_id, take_date, return_date) values(").append(book.getId())
                        .append(",").append(reader.getId()).append(", CURDATE(), CURDATE()+14);");
                statement.executeUpdate(st.toString());
            } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public HashMap<Book, Takedate> bookReturnDates(Reader reader) throws RemoteException {
        HashMap<Book, Takedate> returnDates = new HashMap<>();
        Statement stmt;
        ResultSet resultSet;
        reader.getTakenBooks();

        StringBuilder query = new StringBuilder(
                " SELECT take_date, book_name, print_year, authors.first_name, authors.second_name, genre\n" +
                        " FROM books_readers INNER JOIN books ON books.id = books_readers.books_dictionary_id \n" +
                        " join books_authors on books.id = books_authors.books_id\n" +
                        " join authors on authors.id = books_authors.authors_id\n" +
                        " join books_genres on books.id = books_genres.books_id\n" +
                        " join genres on genres.id = books_genres.genres_id\n" +
                        " WHERE return_date IS NOT NULL AND readers_id = "
        );
        query.append(reader.getId()).append(";");

        try {
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(query.toString());
            while (resultSet.next()) {
                returnDates.put(
                        new Book(
                                new Author( resultSet.getString(4),resultSet.getString(5)),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                Genre.valueOf(resultSet.getString(6))
                        ),
                        pars_td(resultSet.getString(1))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnDates;
    }

    private Takedate pars_td(String date){
        Takedate td = null;
        td.setYear(date.substring(0,3));
        td.setMonth(date.substring(6,6));
        td.setDay(date.substring(7,8));
        return td;
    }

    @Override
    public void save() throws IOException {

    }
}
