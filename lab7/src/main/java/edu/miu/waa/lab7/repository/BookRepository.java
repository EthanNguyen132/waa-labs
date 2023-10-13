package edu.miu.waa.lab7.repository;

import edu.miu.waa.lab7.model.Book;
import edu.miu.waa.lab7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
