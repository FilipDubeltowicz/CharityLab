package pl.coderslab.charity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonationRepository extends JpaRepository<Donation,Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d")
    Integer sumQuantity();

    @Query("SELECT COUNT(d) FROM Donation d")
    Long countDonations();
}
