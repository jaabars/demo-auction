package kg.megacom.demoauction.database;

import kg.megacom.demoauction.model.entity.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
    Status getById(Long id);
    List<Status> findStatusesBy(Pageable pageable);
}
