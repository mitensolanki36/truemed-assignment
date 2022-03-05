package in.truemeds.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.truemeds.assignment.entity.Output;

@Repository
public interface OutputRepository extends JpaRepository<Output, Integer> {

}
