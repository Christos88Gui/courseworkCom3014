package courseworkCom3014.property;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
    
    Property findByPostcode(String postcode);
    @Query("select count(a) > 0 from Property a where a.postcode = :postcode")
    boolean exists(@Param("postcode") String postcode);

    @Query(
    value = "SELECT * FROM Property t where t.property_type = :property_type", 
    nativeQuery=true
    )
    public List<Property> findByPropertyType(@Param("property_type") String property_type);

    Property findOne(long id);

    @Override
    List<Property> findAll();
}
