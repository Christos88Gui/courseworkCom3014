package courseworkCom3014.Model;

import courseworkCom3014.Model.Property;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
//    
//    @Query(
//    value = "SELECT * FROM Property t where t.property_type != :property_type", 
//    nativeQuery=true
//    )
//    public List<Property> findByDiffernetPropertyType(@Param("property_type") String property_type);

    
    @Query(value="SELECT id FROM Property ORDER BY id DESC LIMIT 1", nativeQuery=true)
    public long findMaxId();
    

}
