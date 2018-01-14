package courseworkCom3014.property;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
//    
//    @Query(
//    value = "SELECT * FROM Property t where t.property_type != :property_type", 
//    nativeQuery=true
//    )
//    public List<Property> findByDiffernetPropertyType(@Param("property_type") String property_type);

}
