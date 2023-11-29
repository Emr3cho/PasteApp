package com.example.mypasteapp.dao;

import com.example.mypasteapp.model.MyPaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MyPasteRepository extends JpaRepository<MyPaste, UUID> {
    List<MyPaste> findAllByUserId(int userId);
}
