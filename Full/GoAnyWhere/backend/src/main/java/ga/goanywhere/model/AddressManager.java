package ga.goanywhere.model;

import ga.goanywhere.entities.AddressEntity;

public interface AddressManager {

    Long getOrCreateAddress(AddressEntity addressEntity);

}
