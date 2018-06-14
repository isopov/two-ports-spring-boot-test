package com.example.parenttest.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoobarRepository extends JpaRepository<Foobar, Long> {
}
