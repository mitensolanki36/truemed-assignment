package in.truemeds.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.truemeds.assignment.entity.Input;

@Repository
public interface InputRepository extends JpaRepository<Input, Integer> {

}
