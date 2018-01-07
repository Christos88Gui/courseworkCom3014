/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseworkCom3014.property;

import courseworkCom3014.property.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ct00371
 */

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
    
}
